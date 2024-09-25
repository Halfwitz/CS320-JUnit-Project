/******************************************************************************
 * Module Three Milestone
 * [Service.java]
 * Author: Michael Lorenz
 * - CS320 - Software Test, Automation QA
 * - Southern New Hampshire University
 *
 * Description:
 * This abstract class provides common functionality to use or implement in
 * each service class.
 *
 * Date: Due 9/29/2024
 *****************************************************************************/
package Service;

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
     * Adds an entity to the service storage, mapped to its id.
     * @param entity entity to add to storage. must have a unique id (from createUniqueId();
     */
    public abstract void add(T entity);

    /**
     * Removes object of type T with given id from contacts map
     * @param entity Entity to be removed from lsit
     * @throws IllegalArgumentException if contact does not exist
     * @return entity that was removed
     */
    public T delete(T entity) {
        return entityMap.remove(entity.getId());

    }
    /**
     * Removes object of type T with given id from storage map
     * @param id identifier of object to be removed from storage map
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

}
