package com.jaats.agrovehicledriver.listeners;

import com.jaats.agrovehicledriver.model.WeeklyEarningsBean;

/**
 * Created by Jemsheer K D on 16 May, 2017.
 * Package com.jaats.agrovehicledriver.listeners
 * Project LaTaxiDriver
 */

public interface WeeklyEarningsListener {

    void onLoadCompleted(WeeklyEarningsBean weeklyEarningsBean);

    void onLoadFailed(String error);
}
