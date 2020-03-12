package com.jaats.agrovehicledriver.listeners;

import com.jaats.agrovehicledriver.model.IssueListBean;

/**
 * Created by Jemsheer K D on 19 May, 2017.
 * Package com.jaats.agrovehicledriver.listeners
 * Project LaTaxiDriver
 */

public interface IssueListListener {

    void onLoadCompleted(IssueListBean issueListBean);

    void onLoadFailed(String error);

}
