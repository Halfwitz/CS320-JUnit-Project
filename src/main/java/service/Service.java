/******************************************************************************
 * Module Three Milestone
 * [Service.java]
 * Author: Michael Lorenz
 * - CS320 - Software Test, Automation QA
 * - Southern New Hampshire University
 *
 * Description:
 * This abstract class provides common functionality to use or implement in
 * each service class. Supports storage of type T (extends entity),
 * includes functions to add, remove, and update T objects.
 *
 * Date: Due 9/29/2024
 *****************************************************************************/
package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Service<T extends Entity> {

    /**
     * Container for set of entities, maps entity id to entity object.
     * (Use entity extensions (Task, Contact, Appointment))
     */
    private final Map<String, T> entityMap = new HashMap<>();

    /**
     * Return an entity of type T from the stored map
     * @param id the unique id used to identity entity in map
     * @return entity of type T associated with given id key from map
     * @throws IllegalArgumentException if entity with specified id can't be found
     */
    public T getEntityById(String id) {
        T entity = entityMap.get(id);
        if (entity == null) {
            throw new IllegalArgumentException("Object with ID [" + id + "] does not exist");
        }
        return entity;
    }

    /**
     * Adds an object to the service storage, mapped to its id.
     * @param object object to add to service.
     */
    protected void add(T object) {
        entityMap.put(object.getId(), object);
    }

    /**
     * Removes object of type T with given id from contacts map
     * @param object object to be removed from lsit
     * @throws IllegalArgumentException if contact does not exist
     * @return object that was removed
     */
    public T delete(T object) {
        return entityMap.remove(object.getId());

    }
    /**
     * Removes object of type T with given id from service map
     * @param id identifier of object to be removed from service map
     * @throws IllegalArgumentException if object does not exist
     * @return object of type T that was removed
     */
    public T delete(String id) {
        return delete(getEntityById(id));
    }

    /**
     * Update specified string field implemented in updatedField method implemented from Entity
     * @param id Unique identifier of the object to delete
     * @param value new value to change specified field to
     * @throws IllegalArgumentException if object does not exist or field string is invalid
     */
    public void updateEntityField(String id, String fieldName, String value) {
        T entity = entityMap.get(id);

        if (entity != null) {
            entity.updateField(fieldName, value);
        } else {
            throw new IllegalArgumentException("Object with ID [" + id + "] does not exist");
        }
    }

    // for testing, return an arraylist containing all entities in service map.
    public ArrayList<T> getEntities() {
        return new ArrayList<>(entityMap.values());
    }

}
