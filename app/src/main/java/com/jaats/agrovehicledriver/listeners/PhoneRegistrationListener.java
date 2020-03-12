package com.jaats.agrovehicledriver.listeners;


import com.jaats.agrovehicledriver.model.AuthBean;

public interface PhoneRegistrationListener {

    void onLoadCompleted(AuthBean authBean);

    void onLoadFailed(String error);
}
