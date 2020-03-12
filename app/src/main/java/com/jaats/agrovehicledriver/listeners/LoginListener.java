package com.jaats.agrovehicledriver.listeners;

import com.jaats.agrovehicledriver.model.AuthBean;

/**
 * Created by Jemsheer K D on 28 April, 2017.
 * Package com.jaats.agrovehicledriver.listeners
 * Project LaTaxiDriver
 */

public interface LoginListener {

    void onLoadCompleted(AuthBean authBean);

    void onLoadFailed(String error);

}
