package com.company;

import java.util.UUID;

public class SmartDevice {
    private String id;
    private String name;

    public SmartDevice(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;

    }
}
