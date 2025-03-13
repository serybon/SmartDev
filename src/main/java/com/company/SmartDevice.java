package com.company;

import java.util.UUID;

public class SmartDevice {
    private String id;
    private String name;
    private boolean isOn;
    private int brightness;

    public SmartDevice(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.isOn = false;
    }

    public void turnOn() {
        isOn = true;
    }

    public void turnOff() {
        isOn = false;
    }
