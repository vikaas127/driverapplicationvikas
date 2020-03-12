package com.jaats.agrovehicledriver.listeners;


import com.jaats.agrovehicledriver.model.TripFeedbackBean;

public interface TripFeedbackListener {

    void onLoadFailed(String error);

    void onLoadCompleted(TripFeedbackBean tripFeedbackBean);

}
