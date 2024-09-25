package Service;

import java.util.HashMap;
import java.util.Map;

public class IdGenerator {
    private static final Map<Class<? extends Entity>, Integer> counters = new HashMap<>();

    private IdGenerator() {
    };

    // add new counter to track ids for entities of type entityClass
    public static String generateId(Class<? extends Entity> entityClass) throws Exception {

        // get id value of next id to use or initialize to 0 for entityClass in counters

        int nextId = counters.getOrDefault(entityClass, 0);
        String id = String.valueOf(nextId);

        if (id.length() > 10) {
            throw new Exception("ID overflow error (IDs cannot exceed 10 characters)");
        }

        // increment counter for entityClass
        counters.put(entityClass, ++nextId);

        // return the ID as string:
        return id;
    }

    // clear all counters
    public static void resetCounters() {
        counters.clear();
    }

    // print all counters
    public static void printCounters() {
        for (Map.Entry<Class<? extends Entity>, Integer> mapElement : counters.entrySet()) {
            System.out.println(mapElement.getKey() + ":" + mapElement.getValue());

        }

    }
}
