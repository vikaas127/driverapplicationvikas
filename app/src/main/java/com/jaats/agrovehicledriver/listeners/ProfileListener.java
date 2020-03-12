package com.jaats.agrovehicledriver.listeners;


import com.jaats.agrovehicledriver.model.ProfileBean;


public interface ProfileListener {

    void onLoadCompleted(ProfileBean profileBean);

    void onLoadFailed(String error);
}
