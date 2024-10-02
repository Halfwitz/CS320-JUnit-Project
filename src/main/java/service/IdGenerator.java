package service;

import java.util.HashMap;
import java.util.Map;

public class IdGenerator {
    private static final Map<Class<? extends Entity>, Long> counters = new HashMap<>();
    private static final int ID_MAX_CHARS = 10;

    private IdGenerator() {
    };

    // add new counter to track ids for entities of type entityClass
    public static String generateId(Class<? extends Entity> entityClass) {

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
    public static void setCounter(Class<? extends Entity> counterClass, Long value) {
        counters.put(counterClass, value);
    }

    // print all counters
    public static void printCounters() {
        for (Map.Entry<Class<? extends Entity>, Long> mapElement : counters.entrySet()) {
            System.out.println(mapElement.getKey() + ":" + mapElement.getValue());

        }

    }
}
