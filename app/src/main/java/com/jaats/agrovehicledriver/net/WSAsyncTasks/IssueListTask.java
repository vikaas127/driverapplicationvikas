package com.jaats.agrovehicledriver.net.WSAsyncTasks;

import android.os.AsyncTask;

import java.util.HashMap;

import com.jaats.agrovehicledriver.model.IssueListBean;
import com.jaats.agrovehicledriver.net.invokers.IssueListInvoker;

/**
 * Created by Jemsheer K D on 19 May, 2017.
 * Package com.jaats.agrovehicledriver.net.WSAsyncTasks
 * Project LaTaxiDriver
 */

public class IssueListTask extends AsyncTask<String, Integer, IssueListBean> {

    private IssueListTaskListener issueListTaskListener;

    private HashMap<String, String> urlParams;

    public IssueListTask(HashMap<String, String> urlParams) {
        super();
        this.urlParams = urlParams;
    }

    @Override
    protected IssueListBean doInBackground(String... params) {
        System.out.println(">>>>>>>>>doInBackground");
        IssueListInvoker issueListInvoker = new IssueListInvoker(urlParams, null);
        return issueListInvoker.invokeIssueListWS();
    }

    @Override
    protected void onPostExecute(IssueListBean result) {
        super.onPostExecute(result);
        if (result != null)
            issueListTaskListener.dataDownloadedSuccessfully(result);
        else
            issueListTaskListener.dataDownloadFailed();
    }

    public static interface IssueListTaskListener {
        void dataDownloadedSuccessfully(IssueListBean issueListBean);

        void dataDownloadFailed();
    }

    public IssueListTaskListener getIssueListTaskListener() {
        return issueListTaskListener;
    }

    public void setIssueListTaskListener(IssueListTaskListener issueListTaskListener) {
        this.issueListTaskListener = issueListTaskListener;
    }
}
