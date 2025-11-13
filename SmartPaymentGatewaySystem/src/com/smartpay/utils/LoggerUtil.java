package com.smartpay.utils;

public class LoggerUtil {
    public static void log(String message) {
        System.out.println("[LOG] " + message);
    }

    public static void error(String message) {
        System.err.println("[ERROR] " + message);
    }
}
