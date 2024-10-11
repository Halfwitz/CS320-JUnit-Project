package service.taskservice;

import java.util.HashMap;
import java.util.Map;

/**
 * [BasicIdGenerator.java]
 * Author: Michael Lorenz
 * - CS320 - Software Test, Automation QA
 * - Southern New Hampshire University
 *
 * This class is able to generate unique IDs for any class that extends Task passed into generateId(entityClass)
 * - Includes static methods for testing, resetCounters(), setCounter(), and printCounters()
 * Modified: 10/11/2024 to merge with superclass

 */
public class BasicIdGenerator
{
    private static final Map<Class<? extends Task>, Long> counters = new HashMap<>();
    private static final int ID_MAX_CHARS = 10;

    private BasicIdGenerator() {
    }

    // add new counter to track ids for entities of type entityClass
    public static String generateId(Class<? extends Task> entityClass) {

        // get id value of next id to use or initialize to 0 for entityClass in counters
        long nextId = counters.getOrDefault(entityClass, 0L);
        String id = String.valueOf(nextId);
        // throw error if
        if (id.length() > ID_MAX_CHARS) {
            throw new IllegalArgumentException("ID overflow error (IDs cannot exceed 10 characters)");
        }

        // increment counter for entityClass
        counters.put(entityClass, ++nextId);

        // return the ID as string:
        return id;
    }

    // clear all counters - meant for testing only
    public static void resetCounters() {
        counters.clear();
    }
    // modify specific counter - meant for testing only
    public static void setCounter(Class<? extends Task> counterClass, Long value) {
        counters.put(counterClass, value);
    }

    // print all counters (Excluded unless needed for debug)
    /*public static void printCounters() {
        for (Map.Entry<Class<? extends Task>, Long> mapElement : counters.entrySet()) {
            System.out.println(mapElement.getKey() + ":" + mapElement.getValue());
        }
    }*/
}
