package com.jaats.agrovehicledriver.listeners;

import com.jaats.agrovehicledriver.model.AppStatusBean;
import com.jaats.agrovehicledriver.model.BasicBean;

/**
 * Created by Jemsheer K D on 14 June, 2017.
 * Package com.jaats.agrovehicledriver.listeners
 * Project LaTaxiDriver
 */

public interface AppStatusListener {
    void onLoadCompleted(AppStatusBean appStatusBean);

    void onLoadFailed(String error);
}
