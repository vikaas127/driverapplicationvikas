package com.jaats.agrovehicledriver.listeners;

import com.jaats.agrovehicledriver.model.TripBean;

/**
 * Created by Jemsheer K D on 09 June, 2017.
 * Package com.jaats.agrovehicledriver.listeners
 * Project LaTaxiDriver
 */

public interface TripDetailsListener {

    void onLoadCompleted(TripBean tripBean);

    void onLoadFailed(String error);
}
