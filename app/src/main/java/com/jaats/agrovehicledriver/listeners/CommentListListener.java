package com.jaats.agrovehicledriver.listeners;

import com.jaats.agrovehicledriver.model.CommentListBean;

/**
 * Created by Jemsheer K D on 19 May, 2017.
 * Package com.jaats.agrovehicledriver.listeners
 * Project LaTaxiDriver
 */

public interface CommentListListener {

    void onLoadCompleted(CommentListBean commentListBean);

    void onLoadFailed(String error);
}
