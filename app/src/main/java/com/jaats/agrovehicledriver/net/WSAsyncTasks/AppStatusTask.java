package com.jaats.agrovehicledriver.net.WSAsyncTasks;

import android.os.AsyncTask;

import java.util.HashMap;

import com.jaats.agrovehicledriver.model.AppStatusBean;
import com.jaats.agrovehicledriver.net.invokers.AppStatusInvoker;

/**
 * Created by Jemsheer K D on 14 June, 2017.
 * Package com.jaats.agrovehicledriver.net.WSAsyncTasks
 * Project LaTaxiDriver
 */

public class AppStatusTask extends AsyncTask<String, Integer, AppStatusBean> {

    private AppStatusTaskListener appStatusTaskListener;

    private HashMap<String, String> urlParams;

    public AppStatusTask(HashMap<String, String> urlParams) {
        super();
        this.urlParams = urlParams;
    }

    @Override
    protected AppStatusBean doInBackground(String... params) {
        System.out.println(">>>>>>>>>doInBackground");
        AppStatusInvoker appStatusInvoker = new AppStatusInvoker(urlParams, null);
        return appStatusInvoker.invokeAppStatusWS();
    }

    @Override
    protected void onPostExecute(AppStatusBean result) {
        super.onPostExecute(result);
        if (result != null)
            appStatusTaskListener.dataDownloadedSuccessfully(result);
        else
            appStatusTaskListener.dataDownloadFailed();
    }

    public static interface AppStatusTaskListener {
        void dataDownloadedSuccessfully(AppStatusBean appStatusBean);

        void dataDownloadFailed();
    }

    public AppStatusTaskListener getAppStatusTaskListener() {
        return appStatusTaskListener;
    }

    public void setAppStatusTaskListener(AppStatusTaskListener appStatusTaskListener) {
        this.appStatusTaskListener = appStatusTaskListener;
    }
}
