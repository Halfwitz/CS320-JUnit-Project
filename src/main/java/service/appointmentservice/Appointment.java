/******************************************************************************
 * Module Five Milestone
 * [Appointment.java]
 * Author: Michael Lorenz
 * - CS320 - Software Test, Automation QA
 * - Southern New Hampshire University
 *
 * Description:
 * This class represents an appointment object with fields for date and description.
 * Parent class gives this a unique id when initialized. It enforces constraints:
 * - date must be required, non-null, and not in the past
 * - description must be required, non-null and <= 50 characters
 * Date: Due 10/06/2024
 *****************************************************************************/
package service.appointmentservice;

import service.Entity;
import java.util.Date;

public class Appointment extends Entity {
    private Date appointmentDate;
    private String description;
    private final int DESC_CHAR_LIMIT = 50;

    public Appointment(Date date, String description) {
        super();
        this.appointmentDate = verifyDateNotInPast(date);
        this.description = verifyNonNullWithinChars(description, 1, DESC_CHAR_LIMIT);
    }

    @Override
    public void updateField(String fieldName, String value) {
        switch (fieldName.toLowerCase()) {
            case "date" -> setAppointmentDate(new Date(Long.parseLong(value)));
            case "description" -> setAppointmentDescription(value);
            default -> throw new IllegalArgumentException("Unknown field name");
        }
    }

    private void setAppointmentDate(Date date) {
        this.appointmentDate = verifyDateNotInPast(date);
    }

    /**
     * Verify the given date is not in the past, throws exception if it is.
     * @param date The date to verify is not before current system time
     * @return the original date if no exception.
     * @throws IllegalArgumentException if date is null or before current system time.
     */
    private Date verifyDateNotInPast(Date date) {
        Date current = new Date(); // initialze to current system time
        if (date == null) { // edge case: throw exception if date is null
            throw new IllegalArgumentException("Illegal date. Date must not be null.");
        } else if (date.before(current)) { // throw exception if date is before current time
            throw new IllegalArgumentException("Illegal date-(" + date + "ms.) Date must be not be before current time-(" + current + "ms.)" );
        }

        // return original date if no exceptions thrown
        return date;
    }

    private void setAppointmentDescription(String description) {
        this.description = verifyNonNullWithinChars(description, 1, DESC_CHAR_LIMIT);
    }

    public Date getDate() {
        return appointmentDate;
    }

    public String getDescription() {
        return description;
    }

    /*public String toString() {
        return "[id:"+getId()+"];"+"[name:" + getName() + "];[description:" + getDescription() + "]";

    }*/

}
