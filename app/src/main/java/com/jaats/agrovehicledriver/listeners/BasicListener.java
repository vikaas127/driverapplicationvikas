package com.jaats.agrovehicledriver.listeners;


import com.jaats.agrovehicledriver.model.BasicBean;

public interface BasicListener {

    void onLoadCompleted(BasicBean basicBean);

    void onLoadFailed(String error);
}
