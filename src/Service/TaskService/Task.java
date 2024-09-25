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
 * - id must be non-null, unchangeable, and <= 10 chars
 * - name must be non-null, and <= 20 characters
 * - description must be non-null and <= 50 characters
 *
 * Date: Due 9/29/2024
 *****************************************************************************/
package Service.TaskService;

import Service.Entity;

public class Task extends Entity
{
    private String name, description;
    private final int NAME_CHAR_LIMIT = 10;
    private final int DESC_CHAR_LIMIT = 50;

    public Task(String name, String description) throws Exception {
        super();
        this.name = verifyNonNullWithinChars(name, NAME_CHAR_LIMIT);
        this.description = verifyNonNullWithinChars(description, DESC_CHAR_LIMIT);
    }

    @Override
    public void updateField(String fieldName, String value) {
        switch (fieldName.toLowerCase()) {
            case "name":
                setTaskName(value);
                break;
            case "description":
                setTaskDescription(value);
                break;
        }
    }

    private void setTaskName(String taskName) {
        this.name = verifyNonNullWithinChars(taskName, NAME_CHAR_LIMIT);
    }
    private void setTaskDescription(String description) {
        this.description = verifyNonNullWithinChars(description, DESC_CHAR_LIMIT);
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }

    public String toString() {
        return "[id:"+getId()+"];"+"[name:" + getName() + "];[description:" + getDescription() + "]";

    }
}
