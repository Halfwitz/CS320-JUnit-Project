/****************************************************************
 * Module Three Milestone
 * [TaskTest.java]
 * Author: Michael Lorenz
 * - CS320 - Software Test, Automation QA
 * - Southern New Hampshire University
 *
 * Description:
 * This class contains unit tests for Task class. Verifies the
 * requirements of acceptable variables.
 *
 * Date: Due 9/29/2024
 * Modified: 10/9/2024 - remove outer package dependencies
 ****************************************************************/
package taskservice;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import service.taskservice.BasicIdGenerator;
import service.taskservice.Task;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest
{
    // Reset the unique id incrementer to 0 after each test
    @AfterEach
    void tearDown() {
        BasicIdGenerator.resetCounters();
    }

    // Test creating a task object
    @DisplayName("Test initializing Task and match parameters to variables")
    @Test
    void testInitializeTask() {
        Task task = new Task( "do the dishes", "rinse your plates and dry your cups");
        assertEquals("0", task.getId());
        assertEquals("do the dishes", task.getName());
        assertEquals("rinse your plates and dry your cups", task.getDescription());
    }

    // Requirement 1: task ID string cannot be longer than 10 characters, shall not be null, and shall not be updatable
    @Nested
    @DisplayName("Task ID requirements testing")
    class testTaskId
    {
        @DisplayName("Test when task ID is 10 characters, should throw exception")
        @Test
        void testTaskId10Chars() {
            Task task = new Task("do the dishes", "rinse your plates and dry your cups");
            BasicIdGenerator.setCounter(task.getClass(), 9999999999L);
            Task test = new Task("my id is 10 chars", "description");
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                new Task("do the dishes", "rinse your plates and dry your cups");
            });
        }

        @DisplayName("Test when task ID is 11 characters, should throw exception")
        @Test
        void testTaskIdTooLong() {
            Task task = new Task("do the dishes", "rinse your plates and dry your cups");
            // set value of next id, should throw exception in construction
            BasicIdGenerator.setCounter(task.getClass(), 99999999999L);
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                new Task("do the dishes", "rinse your plates and dry your cups");
            });
        }

        @DisplayName("Test when task ID is null, should throw exception")
        @Test
        void testTaskIdIsNull() {
            // id physically cannot be set to null
            Task task = new Task("do the dishes", "rinse your plates and dry your cups");
            Assertions.assertNotEquals(task.getId(), null);
        }

        @DisplayName("Test if Task id is not updatable")
        @Test
        void testTaskIdIsNotUpdatable() {
            // taskID is a final variable and does not have an associated setter,
            // cannot be modified
        }
    }

    // Requirement 2: required name string cannot be longer than 20 chars and shall not be null
    @Nested
    @DisplayName("Task name requirements testing")
    class testTaskName
    {
        @DisplayName("Test when task name is - characters, should throw exception")
        @Test
        void testTaskNameEmpty() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                new Task("", "there are bears");
            });
        }

        @DisplayName("Test when task name is 20 characters, should not throw exception")
        @Test
        void testTaskName20Chars() {
            Task task = new Task("watch out for a bear", "there are bears");
            Assertions.assertEquals("watch out for a bear", task.getName());
        }

        @DisplayName("Test when task name is 21 characters, should throw exception")
        @Test
        void testTaskNameTooLong() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                new Task("watch out for a bears", "there are bears");
            });
        }

        @DisplayName("Test when task name is whitespace characters, should throw exception")
        @Test
        void testTaskNameWhitespace() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                new Task("                    ", "there are bears");
            });
        }

        @DisplayName("Test when task name is null, should throw exception")
        @Test
        void testTaskNameIsNull() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                new Task(null, "my name is null");
            });
        }
    }
    // Requirement 3: required description string cannot be longer than 50 chars and shall not be null
    @Nested
    @DisplayName("Task description requirements testing")
    class testTaskDescription
    {
        @DisplayName("Test when task description is 0 characters, should throw exception")
        @Test
        void testTaskDescriptionEmpty() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                new Task("Stay Hydrated", "");
            });
        }

        @DisplayName("Test when task description is 50 characters, should not throw exception")
        @Test
        void testTaskDescription50Chars() {
            Task task = new Task("Stay Hydrated", "You need to drink at least 8 cups of water a day..");
            Assertions.assertEquals("You need to drink at least 8 cups of water a day..", task.getDescription());
        }

        @DisplayName("Test when task description is 51 characters, should throw exception")
        @Test
        void testTaskDescriptionTooLong() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                new Task("Stay Hydrated", "You need to drink at least 80 cups of water a day..");
            });
        }

        @DisplayName("Test when task description is whitespace characters, should throw exception")
        @Test
        void testTaskDescriptionWhitespace() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                new Task("Stay Hydrated", "                                                  ");
            });
        }

        @DisplayName("Test when task description is null, should throw exception")
        @Test
        void testTaskDescriptionIsNull() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                new Task("Stay Hydrated", null);
            });
        }
    }
}