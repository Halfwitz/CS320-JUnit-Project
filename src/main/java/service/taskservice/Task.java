/******************************************************************************
 * Module Three Milestone
 * [Task.java]
 * Author: Michael Lorenz
 * - CS320 - Software Test, Automation QA
 * - Southern New Hampshire University
 *
 * Description:
 * This class represents a task object with fields for task name, and description.
 * Parent class gives this a unique id when initialized. It enforces constraints:
 * - name must be non-null, and <= 20 characters
 * - description must be non-null and <= 50 characters
 * Date: Due 9/29/2024
 *****************************************************************************/
package service.taskservice;

import service.Entity;

public class Task extends Entity
{
    private String name, description;
    private final int NAME_CHAR_LIMIT = 20;
    private final int DESC_CHAR_LIMIT = 50;

    public Task(String name, String description) {
        super();
        this.name = verifyNonNullWithinChars(name, 1, NAME_CHAR_LIMIT);
        this.description = verifyNonNullWithinChars(description, 1, DESC_CHAR_LIMIT);
    }

    @Override
    public void updateField(String fieldName, String value) {
        switch (fieldName.toLowerCase()) {
            case "name" -> setTaskName(value);
            case "description" -> setTaskDescription(value);
            default -> throw new IllegalArgumentException("Unknown field name");
        }
    }

    private void setTaskName(String taskName) {
        this.name = verifyNonNullWithinChars(taskName, 1, NAME_CHAR_LIMIT);
    }

    private void setTaskDescription(String description) {
        this.description = verifyNonNullWithinChars(description, 1, DESC_CHAR_LIMIT);
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }

    /*public String toString() {
        return "[id:"+getId()+"];"+"[name:" + getName() + "];[description:" + getDescription() + "]";

    }*/
}
