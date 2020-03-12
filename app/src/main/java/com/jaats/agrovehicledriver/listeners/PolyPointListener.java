package com.jaats.agrovehicledriver.listeners;

import com.jaats.agrovehicledriver.model.PolyPointBean;

/**
 * Created by Jemsheer K D on 09 May, 2017.
 * Package com.jaats.agrovehicledriver.listeners
 * Project LaTaxiDriver
 */

public interface PolyPointListener {
    void onLoadCompleted(PolyPointBean polyPointBean);

    void onLoadFailed(String error);
}
