package com.company;

import java.util.UUID;

public class SmartDevice {
    private String id;
    private String name;
    private int brightness;

    public SmartDevice(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.brightness = 0;
    }

    public void setBrightness(int brightness) {
        this.brightness = Math.max(0, Math.min(100, brightness));
    }

}
