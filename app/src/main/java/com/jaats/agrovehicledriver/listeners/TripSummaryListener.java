package com.jaats.agrovehicledriver.listeners;


import com.jaats.agrovehicledriver.model.AuthBean;
import com.jaats.agrovehicledriver.model.TripSummaryBean;

public interface TripSummaryListener {

    void onLoadCompleted(TripSummaryBean tripSummaryBean);

    void onLoadFailed(String error);
}
