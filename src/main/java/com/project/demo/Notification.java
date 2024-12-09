package com.project.demo;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Notification implements Serializable {

    private String message;
    private LocalDateTime time;
    private boolean feStatus;

    public Notification(String message) {
        this.message = message;
        this.time = LocalDateTime.now();
    }

    public String getMessage() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedTime = time.format(formatter);
        return "Time: " + formattedTime + "\nMessage: " + message;
    }

    public boolean isFeStatus() {
        return feStatus;
    }

    public void setFeStatus(boolean feStatus) {
        this.feStatus = feStatus;
    }
}

