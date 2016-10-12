/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.so.webblog.info;

/**
 *
 * @author user
 */
public class DeviceInfo {
    public static enum Device{
        IOS, ANDROID, PC
    };
    private Device device;
    private String deviceToken;

    public DeviceInfo(Device device, String deviceToken) {
        this.device = device;
        this.deviceToken = deviceToken;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }
    
    
}
