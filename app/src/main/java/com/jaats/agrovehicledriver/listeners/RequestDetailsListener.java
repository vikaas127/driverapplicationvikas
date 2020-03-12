package com.jaats.agrovehicledriver.listeners;

import com.jaats.agrovehicledriver.model.RequestDetailsBean;

/**
 * Created by Jemsheer K D on 08 June, 2017.
 * Package com.jaats.agrovehicledriver.listeners
 * Project LaTaxiDriver
 */

public interface RequestDetailsListener {

    void onLoadCompleted(RequestDetailsBean requestDetailsBean);

    void onLoadFailed(String error);
}
