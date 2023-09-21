package com.seam.focs.entity;

import java.util.Date;

public class Visitor {
    private String ipAddress;
    private String deviceInfo;
    private Date timing;

    public Visitor() {
        // Default constructor
    }

    public Visitor(String ipAddress, String deviceInfo, Date timing) {
        this.ipAddress = ipAddress;
        this.deviceInfo = deviceInfo;
        this.timing = timing;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public Date getTiming() {
        return timing;
    }

    public void setTiming(Date timing) {
        this.timing = timing;
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "ipAddress='" + ipAddress + '\'' +
                ", deviceInfo='" + deviceInfo + '\'' +
                ", timing=" + timing +
                '}';
    }
}
