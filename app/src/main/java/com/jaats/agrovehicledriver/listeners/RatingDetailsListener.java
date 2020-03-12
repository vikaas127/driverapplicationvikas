package com.jaats.agrovehicledriver.listeners;

import com.jaats.agrovehicledriver.model.RatingDetailsBean;

/**
 * Created by Jemsheer K D on 18 May, 2017.
 * Package com.jaats.agrovehicledriver.listeners
 * Project LaTaxiDriver
 */

public interface RatingDetailsListener {
    void onLoadCompleted(RatingDetailsBean ratingDetailsBean);

    void onLoadFailed(String error);

}
