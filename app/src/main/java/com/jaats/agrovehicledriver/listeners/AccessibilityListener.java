package com.jaats.agrovehicledriver.listeners;


import com.jaats.agrovehicledriver.model.AccessibilityBean;

public interface AccessibilityListener {

    void onLoadCompleted(AccessibilityBean accessibilityBean);

    void onLoadFailed(String error);
}
