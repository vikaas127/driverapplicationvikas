package com.jaats.agrovehicledriver.net.WSAsyncTasks;

import android.os.AsyncTask;

import java.util.HashMap;

import com.jaats.agrovehicledriver.model.TripListBean;
import com.jaats.agrovehicledriver.net.invokers.TodayTripListInvoker;

/**
 * Created by Jemsheer K D on 08 May, 2017.
 * Package com.jaats.agrovehicledriver.net.WSAsyncTasks
 * Project LaTaxiDriver
 */

public class TodayTripListTask extends AsyncTask<String, Integer, TripListBean> {

    private TodayTripListTaskListener todayTripListTaskListener;

    private HashMap<String, String> urlParams;

    public TodayTripListTask(HashMap<String, String> urlParams) {
        super();
        this.urlParams = urlParams;
    }

    @Override
    protected TripListBean doInBackground(String... params) {
        System.out.println(">>>>>>>>>doInBackground");
        TodayTripListInvoker todayTripListInvoker = new TodayTripListInvoker(urlParams, null);
        return todayTripListInvoker.invokeTodayTripListWS();
    }

    @Override
    protected void onPostExecute(TripListBean result) {
        super.onPostExecute(result);
        if (result != null)
            todayTripListTaskListener.dataDownloadedSuccessfully(result);
        else
            todayTripListTaskListener.dataDownloadFailed();
    }

    public static interface TodayTripListTaskListener {
        void dataDownloadedSuccessfully(TripListBean tripListBean);

        void dataDownloadFailed();
    }

    public TodayTripListTaskListener getTodayTripListTaskListener() {
        return todayTripListTaskListener;
    }

    public void setTodayTripListTaskListener(TodayTripListTaskListener todayTripListTaskListener) {
        this.todayTripListTaskListener = todayTripListTaskListener;
    }
}
