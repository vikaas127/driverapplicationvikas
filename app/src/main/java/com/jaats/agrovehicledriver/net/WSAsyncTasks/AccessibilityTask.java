package com.jaats.agrovehicledriver.net.WSAsyncTasks;


import android.os.AsyncTask;

import org.json.JSONObject;

import com.jaats.agrovehicledriver.model.BasicBean;
import com.jaats.agrovehicledriver.net.invokers.AccessibilityInvoker;

public class AccessibilityTask extends AsyncTask<String, Integer, BasicBean> {

    private AccessibilityTaskListener accessibilityTaskListener;

    private JSONObject postData;

    public AccessibilityTask(JSONObject postData) {
        super();
        this.postData = postData;
    }

    @Override
    protected BasicBean doInBackground(String... params) {
        System.out.println(">>>>>>>>>doInBackground");
        AccessibilityInvoker accessibilityInvoker = new AccessibilityInvoker(null, postData);
        return accessibilityInvoker.invokeAccessibilityWS();
    }

    @Override
    protected void onPostExecute(BasicBean result) {
        // TODO Auto-generated method stub
        super.onPostExecute(result);
        if (result != null)
            accessibilityTaskListener.dataDownloadedSuccessfully(result);
        else
            accessibilityTaskListener.dataDownloadFailed();
    }

    public static interface AccessibilityTaskListener {

        void dataDownloadedSuccessfully(BasicBean dummyBean);

        void dataDownloadFailed();
    }

    public AccessibilityTaskListener getAccessibilityTaskListener() {
        return accessibilityTaskListener;
    }

    public void setAccessibilityTaskListener(AccessibilityTaskListener accessibilityTaskListener) {
        this.accessibilityTaskListener = accessibilityTaskListener;
    }
}
