/******************************************************************************
 * Module Three Milestone
 * [Task.java]
 * Author: Michael Lorenz
 * - CS320 - Software Test, Automation QA
 * - Southern New Hampshire University
 * Description:
 * This class represents a task object with fields for task name, and description.
 * Parent class gives this a unique id when initialized. It enforces constraints:
 * - name must be non-null, and <= 20 characters
 * - description must be non-null and <= 50 characters
 * Date: Due 9/29/2024
 * Modified: 10/09/2024 to remove outer package dependencies
 *****************************************************************************/
package service.taskservice;

public class Task extends BasicEntity
{
    private String name, description;
    private final int NAME_CHAR_LIMIT = 20;
    private final int DESC_CHAR_LIMIT = 50;

    /**
     * Initializes a new Task object
     * @param name task name (non-null, <= 20 chars)
     * @param description task description (non-null, <= 50 chars)
     * @throws IllegalArgumentException if parameters are invalid.
     */
    public Task(String name, String description) {
        super();
        this.name = verifyNonNullWithinChars(name, 1, NAME_CHAR_LIMIT);
        this.description = verifyNonNullWithinChars(description, 1, DESC_CHAR_LIMIT);
    }

    // SET TASK FIELDS
    /**
     * Sets specified field name to new specified value. Allowed field names are
     * "name", and "description".
     * @param fieldName field name to modify.
     * @throws IllegalArgumentException if parameter value is invalid
     */
    @Override
    protected void updateField(String fieldName, String value) {
        switch (fieldName.toLowerCase()) {
            case "name" -> setTaskName(value);
            case "description" -> setTaskDescription(value);
            default -> throw new IllegalArgumentException("Unknown field name");
        }
    }

    /**
     * Updates task name
     * @param taskName new name (non-null, <= 20 chars)
     * @throws IllegalArgumentException if parameter is invalid
     */
    private void setTaskName(String taskName) {
        this.name = verifyNonNullWithinChars(taskName, 1, NAME_CHAR_LIMIT);
    }

    /**
     * Updates task description
     * @param description new task description (non-null, <= 50 chars)
     * @throws IllegalArgumentException if parameter is invalid
     */
    private void setTaskDescription(String description) {
        this.description = verifyNonNullWithinChars(description, 1, DESC_CHAR_LIMIT);
    }

    // GETTERS
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
