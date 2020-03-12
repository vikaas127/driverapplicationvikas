package com.jaats.agrovehicledriver.activity;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.HapticFeedbackConstants;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import com.jaats.agrovehicledriver.R;
import com.jaats.agrovehicledriver.app.App;
import com.jaats.agrovehicledriver.listeners.BasicListener;
import com.jaats.agrovehicledriver.model.BasicBean;
import com.jaats.agrovehicledriver.net.DataManager;
import com.jaats.agrovehicledriver.util.AppConstants;

public class ForgotPasswordActivity extends BaseAppCompatNoDrawerActivity {

    private Button btnReset;
    private EditText etxtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);


        getSupportActionBar().hide();
        swipeView.setPadding(0, 0, 0, 0);

        initViews();

    }

    private void initViews() {

        btnReset = (Button) findViewById(R.id.btn_forgot_password_reset);
        etxtEmail = (EditText) findViewById(R.id.etxt_forgot_password_email);

        etxtEmail.setTypeface(typeface);
        btnReset.setTypeface(typeface);

    }

    public void onForgotPasswordResetClick(View view) {
        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
//        mVibrator.vibrate(25);

        if (collectForgotPasswordData()) {

            if (App.isNetworkAvailable()) {
                performForgotPassword();
            }else{
                Snackbar.make(coordinatorLayout, AppConstants.NO_NETWORK_AVAILABLE, Snackbar.LENGTH_LONG)
                        .setAction(R.string.btn_dismiss, snackBarDismissOnClickListener).show();
            }
        }

    }

    private void performForgotPassword() {

        JSONObject postData = getForgotPasswordJSObj();

        DataManager.performForgotPassword(postData, new BasicListener() {
            @Override
            public void onLoadCompleted(BasicBean basicBean) {
                finish();
            }

            @Override
            public void onLoadFailed(String error) {
                Snackbar.make(coordinatorLayout, error, Snackbar.LENGTH_LONG)
                        .setAction(R.string.btn_dismiss, snackBarDismissOnClickListener).show();
            }
        });


    }

    private JSONObject getForgotPasswordJSObj() {

        JSONObject postData = new JSONObject();

        try {
            postData.put("email", etxtEmail.getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return postData;
    }

    private boolean collectForgotPasswordData() {

        if (etxtEmail.getText().toString().equals("")) {
            Snackbar.make(coordinatorLayout, R.string.message_enter_email_to_recover_password, Snackbar.LENGTH_LONG)
                    .setAction(R.string.btn_dismiss, snackBarDismissOnClickListener).show();
            return false;
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(etxtEmail.getText().toString()).matches()) {
            Snackbar.make(coordinatorLayout, R.string.message_enter_a_valid_email_address, Snackbar.LENGTH_LONG)
                    .setAction(R.string.btn_dismiss, snackBarDismissOnClickListener).show();
            return false;
        }

        return true;
    }
}
