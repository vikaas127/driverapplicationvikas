package com.jaats.agrovehicledriver.net.WSAsyncTasks;


import android.os.AsyncTask;

import org.json.JSONObject;

import com.jaats.agrovehicledriver.model.BasicBean;
import com.jaats.agrovehicledriver.net.invokers.DriverTypeRegistrationInvoker;

public class DriverTypeRegistrationTask extends AsyncTask<Integer, String, BasicBean> {

    private DriverTypeRegistrationTask.DriverTypeRegistrationTaskListener driverTypeRegistrationTaskListener;

    private JSONObject postData;

    public DriverTypeRegistrationTask(JSONObject postData) {
        super();
        this.postData = postData;
    }

    @Override
    protected BasicBean doInBackground(Integer... params) {

        System.out.println(">>>>>>>>>doInBackground");
        DriverTypeRegistrationInvoker driverTypeRegistrationInvoker = new DriverTypeRegistrationInvoker(null, postData);
        return driverTypeRegistrationInvoker.invokeDriverTypeRegistrationWS();

    }

    @Override
    protected void onPostExecute(BasicBean result) {
        super.onPostExecute(result);

        if (result != null)
            driverTypeRegistrationTaskListener.dataDownloadedSuccessfully(result);
        else
            driverTypeRegistrationTaskListener.dataDownloadFailed();
    }

    public interface DriverTypeRegistrationTaskListener {

        void dataDownloadedSuccessfully(BasicBean basicBean);

        void dataDownloadFailed();
    }

    public DriverTypeRegistrationTaskListener getDriverTypeRegistrationTaskListener() {
        return driverTypeRegistrationTaskListener;
    }

    public void setDriverTypeRegistrationTaskListener(DriverTypeRegistrationTaskListener driverTypeRegistrationTaskListener) {
        this.driverTypeRegistrationTaskListener = driverTypeRegistrationTaskListener;
    }
}
