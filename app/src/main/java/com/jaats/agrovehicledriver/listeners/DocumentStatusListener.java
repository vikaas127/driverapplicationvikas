package com.jaats.agrovehicledriver.listeners;

import com.jaats.agrovehicledriver.model.DocumentStatusBean;

/**
 * Created by Jemsheer K D on 28 April, 2017.
 * Package com.jaats.agrovehicledriver.listeners
 * Project LaTaxiDriver
 */

public interface DocumentStatusListener {

    void onLoadCompleted(DocumentStatusBean documentStatusBean);

    void onLoadFailed(String error);
}
