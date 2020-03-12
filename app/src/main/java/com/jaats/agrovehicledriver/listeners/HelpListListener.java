package com.jaats.agrovehicledriver.listeners;

import com.jaats.agrovehicledriver.model.HelpListBean;

/**
 * Created by Jemsheer K D on 19 May, 2017.
 * Package com.jaats.agrovehicledriver.listeners
 * Project LaTaxiDriver
 */

public interface HelpListListener {
    void onLoadCompleted(HelpListBean helpListBean);

    void onLoadFailed(String error);
}
