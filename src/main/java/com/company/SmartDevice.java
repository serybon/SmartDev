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
    private boolean isOn;
    private LocalDateTime lastInteraction;
    private ArrayList<String> activityLog;
    private String color;
    private ArrayList<String> supportedColors;
    private int brightness;

    public SmartDevice(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.isOn = false;
        this.lastInteraction = LocalDateTime.now();
        this.activityLog = new ArrayList<>();
        this.color = "white";
        this.supportedColors = new ArrayList<>(
                List.of("white", "red", "green", "blue", "yellow")
        );
        this.brightness = 0;
    }

    public void turnOn() {
        isOn = true;
    }

    public void turnOff() {
        isOn = false;
    }
  
    private void updateLastInteraction() {
        this.lastInteraction = LocalDateTime.now();
    }

    private void logActivity(String activity) {
        String logEntry = LocalDateTime.now() + ": " + activity;
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter("activity.log", true))) {
            writer.write(logEntry);
            writer.newLine();
        } catch (IOException e) {
            logActivity("Ошибка при записи в файл лога: " + e.getMessage());
        }
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
