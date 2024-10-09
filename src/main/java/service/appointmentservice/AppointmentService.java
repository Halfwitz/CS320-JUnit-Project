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
 * - delete appointments per appointment ID
 *
 * Date: Due 10/06/2024
 *****************************************************************************/
package service.appointmentservice;

import java.util.Date;

public class AppointmentService extends BasicService<Appointment> {

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

    /**
     * Adds an appointment object mapped to its unique id in storage.
     * appointment date is set to the current system time
     * @param description - Description of the appointment (Must be non-null, no more than 50 characters)
     * @throws IllegalArgumentException in Appointment object if parameters are invalid format
     */
    public void add(String description) {
        Appointment appointment = new Appointment(description); // create object with specified parameters
        add(appointment); // super method. Adds to entityMap HashMap using unique ID
    }

    // super class contains method for delete appointments per ID

    // UPDATE APPOINTMENT FIELDS
    /**
     * Updates date of appointment with given id to given future date (Date class)
     * @param id Unique identifier of the appointment to update
     * @param date new appointment date (non-null, must be after current system time). Chance of exception if date is
     *             set to actual system time, such as with 'new Date()', use updateDate(String id) instead for setting
     *             to current time.
     * @throws IllegalArgumentException if appointment does not exist or date is invalid.
     */
    public void updateDate(String id, Date date) {
        if (date == null) {
            getEntityById(id).updateField("date", null);
        } else {
            getEntityById(id).updateField("date", String.valueOf(date.getTime()));
        }
    }

    /**
     * Updates date of appointment with given id to current system time
     * @param id Unique identifier of the appointment to update
     * @throws IllegalArgumentException if appointment does not exist or date is invalid
     */
    public Date updateDate(String id) {
        Date current = new Date();
        // sets date to current system time and specifies it can't be before this time
        getEntityById(id).setAppointmentDate(current, current);
        return current; // returns current (helpful in testing)
    }

    /**
     * Updates name of appointment with given id to firstName
     * @param id Unique identifier of the appointment to update
     * @param description new appointment description (non-null, <= 50 chars)
     * @throws IllegalArgumentException if appointment does not exist or date is invalid
     */
    public void updateDescription(String id, String description) {
        getEntityById(id).updateField("description", description);
    }


}
