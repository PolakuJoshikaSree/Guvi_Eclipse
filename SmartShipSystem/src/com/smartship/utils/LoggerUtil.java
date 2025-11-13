package com.smartship.utils;

import java.time.LocalDateTime;

public class LoggerUtil {
    public static void log(String message) {
        System.out.println("[" + LocalDateTime.now() + "] " + message);
    }

    public static void error(String message) {
        System.err.println("[" + LocalDateTime.now() + "] ERROR: " + message);
    }
}
