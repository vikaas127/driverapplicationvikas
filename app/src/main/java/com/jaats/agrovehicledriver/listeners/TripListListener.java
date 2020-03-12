package com.jaats.agrovehicledriver.listeners;

import com.jaats.agrovehicledriver.model.TripListBean;

/**
 * Created by Jemsheer K D on 08 May, 2017.
 * Package com.jaats.agrovehicledriver.listeners
 * Project LaTaxiDriver
 */

public interface TripListListener {

    void onLoadCompleted(TripListBean tripListBean);

    void onLoadFailed(String error);

}
