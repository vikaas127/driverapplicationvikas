package com.jaats.agrovehicledriver.net.WSAsyncTasks;

import android.os.AsyncTask;

import org.json.JSONObject;

import com.jaats.agrovehicledriver.model.TripBean;
import com.jaats.agrovehicledriver.net.invokers.TripAcceptInvoker;

/**
 * Created by Jemsheer K D on 08 June, 2017.
 * Package com.jaats.agrovehicledriver.net.WSAsyncTasks
 * Project LaTaxiDriver
 */

public class TripAcceptTask extends AsyncTask<String, Integer, TripBean> {

    private TripAcceptTaskListener tripAcceptTaskListener;

    private JSONObject postData;

    public TripAcceptTask(JSONObject postData) {
        super();
        this.postData = postData;
    }

    @Override
    protected TripBean doInBackground(String... params) {
        System.out.println(">>>>>>>>>doInBackground");
        TripAcceptInvoker tripAcceptInvoker = new TripAcceptInvoker(null, postData);
        return tripAcceptInvoker.invokeTripAcceptWS();
    }

    @Override
    protected void onPostExecute(TripBean result) {
        super.onPostExecute(result);
        if (result != null)
            tripAcceptTaskListener.dataDownloadedSuccessfully(result);
        else
            tripAcceptTaskListener.dataDownloadFailed();
    }

    public static interface TripAcceptTaskListener {
        void dataDownloadedSuccessfully(TripBean tripBean);

        void dataDownloadFailed();
    }

    public TripAcceptTaskListener getTripAcceptTaskListener() {
        return tripAcceptTaskListener;
    }

    public void setTripAcceptTaskListener(TripAcceptTaskListener tripAcceptTaskListener) {
        this.tripAcceptTaskListener = tripAcceptTaskListener;
    }
}
