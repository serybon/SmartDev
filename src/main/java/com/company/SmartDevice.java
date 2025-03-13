package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

public class SmartDevice {
    private String id;
    private String name;
    private LocalDateTime lastInteraction;
    private ArrayList<String> activityLog;

    public SmartDevice(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.lastInteraction = LocalDateTime.now();
        this.activityLog = new ArrayList<>();
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

}
