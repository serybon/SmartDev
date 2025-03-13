package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SmartDevice {
    private String id;
    private String name;
    private String color;
    private ArrayList<String> supportedColors;

    public SmartDevice(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.color = "white";
        this.supportedColors = new ArrayList<>(
                List.of("white", "red", "green", "blue", "yellow")
        );

    }

    public void setColor(String color) {
        if (supportedColors.contains(color.toLowerCase())) {
            this.color = color.toLowerCase();
        }
    }

    public void addSupportedColor(String color) {
        supportedColors.add(color.toLowerCase());
    }

    public ArrayList<String> getSupportedColors() {
        return new ArrayList<>(supportedColors);
    }

    public void showSupportedColors() {
        supportedColors.forEach(System.out::println);
    }
}
