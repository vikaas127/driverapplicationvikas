package com.jaats.agrovehicledriver.listeners;


public interface PermissionListener {

    void onPermissionCheckCompleted(int requestCode, boolean isPermissionGranted);

}
