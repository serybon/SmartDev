package com.company;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SmartDevice {
    private String id;
    private String name;
    private LocalDateTime lastInteraction;
    private ArrayList<String> activityLog;
    private String color;
    private ArrayList<String> supportedColors;
    private int brightness;

    public SmartDevice(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.brightness = 0;
        this.lastInteraction = LocalDateTime.now();
        this.activityLog = new ArrayList<>();
        this.color = "white";
        this.supportedColors = new ArrayList<>(
                List.of("white", "red", "green", "blue", "yellow")
        );
        this.brightness = 0;
    }
  
    private void updateLastInteraction() {
        this.lastInteraction = LocalDateTime.now();
    }

    public void setBrightness(int brightness) {
        this.brightness = Math.max(0, Math.min(100, brightness));
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
