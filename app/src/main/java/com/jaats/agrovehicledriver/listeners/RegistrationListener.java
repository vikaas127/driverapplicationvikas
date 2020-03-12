package com.jaats.agrovehicledriver.listeners;

import com.jaats.agrovehicledriver.model.AuthBean;

/**
 * Created by Jemsheer K D on 24 April, 2017.
 * Package com.jaats.agrovehicledriver.listeners
 * Project LaTaxiDriver
 */

public interface RegistrationListener {

    void onLoadCompleted(AuthBean authBean);

    void onLoadFailed(String error);
}
