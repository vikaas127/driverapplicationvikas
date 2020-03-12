package com.jaats.agrovehicledriver.net.WSAsyncTasks;

import android.os.AsyncTask;

import java.util.HashMap;

import com.jaats.agrovehicledriver.model.RequestDetailsBean;
import com.jaats.agrovehicledriver.net.invokers.RequestDetailsInvoker;

/**
 * Created by Jemsheer K D on 08 June, 2017.
 * Package com.jaats.agrovehicledriver.net.WSAsyncTasks
 * Project LaTaxiDriver
 */

public class RequestDetailsTask extends AsyncTask<String, Integer, RequestDetailsBean> {

    private RequestDetailsTaskListener requestDetailsTaskListener;

    private HashMap<String, String> urlParams;

    public RequestDetailsTask(HashMap<String, String> urlParams) {
        super();
        this.urlParams = urlParams;
    }

    @Override
    protected RequestDetailsBean doInBackground(String... params) {
        System.out.println(">>>>>>>>>doInBackground");
        RequestDetailsInvoker requestDetailsInvoker = new RequestDetailsInvoker(urlParams, null);
        return requestDetailsInvoker.invokeRequestDetailsWS();
    }

    @Override
    protected void onPostExecute(RequestDetailsBean result) {
        super.onPostExecute(result);
        if (result != null)
            requestDetailsTaskListener.dataDownloadedSuccessfully(result);
        else
            requestDetailsTaskListener.dataDownloadFailed();
    }

    public static interface RequestDetailsTaskListener {
        void dataDownloadedSuccessfully(RequestDetailsBean requestDetailsBean);

        void dataDownloadFailed();
    }

    public RequestDetailsTaskListener getRequestDetailsTaskListener() {
        return requestDetailsTaskListener;
    }

    public void setRequestDetailsTaskListener(RequestDetailsTaskListener requestDetailsTaskListener) {
        this.requestDetailsTaskListener = requestDetailsTaskListener;
    }
}
