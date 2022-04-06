package com.kreitek.pets.infraestructure.logger;

public class LoggerPets {
    private static volatile LoggerPets instance = null;
    private static int count = 0;

    private LoggerPets() {
        if (instance != null) {
            throw new RuntimeException("Usage getInstance method to create");
        }
    }

    public static LoggerPets getInstance() {
        if (instance == null) {
            synchronized (LoggerPets.class) {
                if (instance == null) {
                    instance = new LoggerPets();
                }
            }
        }
        return instance;
    }

    public void debug(String message) {
        System.out.println("[debug][" + count + "] - " + message);
        count += 1;
    }
}
