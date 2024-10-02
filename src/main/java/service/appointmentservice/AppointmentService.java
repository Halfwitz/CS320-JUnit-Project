/******************************************************************************
 * Module Five Milestone
 * [AppointmentService.java]
 * Author: Michael Lorenz
 * - CS320 - Software Test, Automation QA
 * - Southern New Hampshire University
 *
 * Description:
 * This class supports storing appointments. Allows functionalities to:
 * - add appointments with a unique ID, date, and description
 * - delete appointments per task ID
 *
 * Date: Due 10/06/2024
 *****************************************************************************/
package service.appointmentservice;

import service.Service;
import java.util.Date;

public class AppointmentService extends Service<Appointment> {

    /**
     * Adds an appointment object mapped to its unique id in storage.
     * @param date - Scheduled date of the appointment (Must not be non-null, in the past)
     * @param description - Description of the appointment (Must be non-null, no more than 50 characters)
     * @throws IllegalArgumentException in Appointment object if parameters are invalid format
     */
    public void add(Date date, String description) {
        Appointment appointment = new Appointment(date, description); // create object with specified parameters
        add(appointment); // super method. Adds to entityMap HashMap using unique ID
    }

    // super class contains method for delete appointments per ID

    /* UPDATE APPOINTMENT FIELDS ***Disabled for now due to ambiguity in requirements
    /**
     * Updates name of task with given id to firstName
     * @param id Unique identifier of the task to update
     * @param name new task name (non-null, <= 10 chars)
     * @throws IllegalArgumentException if task does not exist or firstName is invalid
     */
    /*public void updateName(String id, String name) {
        getEntityById(id).updateField("name", name);
    }

    /**
     * Updates name of task with given id to firstName
     * @param id Unique identifier of the task to update
     * @param description new task description (non-null, <= 50 chars)
     * @throws IllegalArgumentException if task does not exist or firstName is invalid
     */
    /*public void updateDescription(String id, String description) {
        getEntityById(id).updateField("description", description);
    } */


}
