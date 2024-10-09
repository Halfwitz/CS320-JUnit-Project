/******************************************************************************
 * Module Four Milestone
 * [TaskService.java]
 * Author: Michael Lorenz
 * - CS320 - Software Test, Automation QA
 * - Southern New Hampshire University
 *
 * Description:
 * This class supports storing tasks. Allows functionalities to:
 * - add tasks with a unique ID, name, and description
 * - delete tasks per task ID
 * - update task fields per task ID (Name, Description)
 *
 * Date: Due 9/29/2024
 * Modified: 10/09/2024 to remove outer package dependencies
 *****************************************************************************/
package service.taskservice;
import service.Service;

public class TaskService extends BasicService<Task> {
    /**
     * Adds a task object mapped to its unique id in storage.
     * @param name - Name of task
     * @param description - Description of task
     * @throws IllegalArgumentException in Task object if parameters are invalid format
     */
    public void add(String name, String description) {
        Task entity = new Task(name, description);
        add(entity);
    }

    // UPDATE TASK FIELDS
    /**
     * Updates name of task with given id to firstName
     * @param id Unique identifier of the task to update
     * @param name new task name (non-null, <= 10 chars)
     * @throws IllegalArgumentException if task does not exist or firstName is invalid
     */
    public void updateName(String id, String name) {
        updateEntityField(id, "name", name);
    }

    /**
     * Updates name of task with given id to firstName
     * @param id Unique identifier of the task to update
     * @param description new task description (non-null, <= 50 chars)
     * @throws IllegalArgumentException if task does not exist or firstName is invalid
     */
    public void updateDescription(String id, String description) {
        updateEntityField(id, "description", description);
    }

    /*public void printTasks() {
        for (Task task : getEntities()) {
            System.out.println(task);
        }
    }*/
}
