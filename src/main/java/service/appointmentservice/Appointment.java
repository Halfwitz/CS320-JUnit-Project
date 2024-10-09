/******************************************************************************
 * <h1>Module Five Milestone</h1>
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
import java.util.Date;

public class Appointment extends BasicEntity {
    private Date appointmentDate;
    private String description;
    private final int DESC_CHAR_LIMIT = 50;

    public Appointment(Date date, String description) {
        super();
        this.appointmentDate = verifyDateNotInPast(date);
        this.description = verifyNonNullWithinChars(description, 1, DESC_CHAR_LIMIT);
    }

    /**
     * Construct's an Appointment object
     * @param date - date of the appointment, can't be null or before minDate
     * @param description - description of the appointment (non-null and <= 50 chars)
     * @param minDate - minimum date initially allowed
     * @throws IllegalArgumentException if date is before minDate or parameters are invalid
     */
    public Appointment(Date date, String description, Date minDate) {
        super();
        this.appointmentDate = verifyDateNotBeforeOther(date, minDate);

    }

    /**
     * Used publicly to update various fields depending on fieldName
     * @param fieldName the name of the field to update.
     *                  <p>case "date" -> updates appointmentDate. Value should be string representation of a
     *                                  Date object's time. (String.valueOf(Date object.getTime()))  non-null.</p>
     *                  <p>case "description" -> updates description field to specified value field.
     *                                            Value Should be non-null and <= 50 chars.</p>
     * @param value the new value to set for the specified field.
     * @throws IllegalArgumentException if fieldName does not match expected strings
     */
    @Override
    public void updateField(String fieldName, String value) {
        switch (fieldName.toLowerCase()) {
            case "date" -> setAppointmentDate(new Date(Long.parseLong(value)));
            case "description" -> setAppointmentDescription(value);
            default -> throw new IllegalArgumentException("Unknown field name");
        }
    }

    /**
     * Set's an appointment date to the new date. Verifies that date is not before the current system time.
     * @param date new date to set
     * @throws IllegalArgumentException if date is invalid or comes before current system time
     */
    private void setAppointmentDate(Date date) {
        appointmentDate = verifyDateNotInPast(date);
    }

    /**
     * Set's an appointment date to the new date. Verifies that date is not before a given minimum date.
     * @param date new date to set
     * @param minDate minimum allowed date
     * @throws IllegalArgumentException if date is invalid or comes before minDate
     */
    public void setAppointmentDate(Date date, Date minDate) {
        appointmentDate = verifyDateNotBeforeOther(date, minDate);
    }

    /**
     * Verify the given date is not before current system time, throws exception if it is.
     * @param date The date to verify is not before current system time
     * @return the original date if no exception.
     * @throws IllegalArgumentException if date is null or before current system time.
     */
    private Date verifyDateNotInPast(Date date) {
        return verifyDateNotBeforeOther(date, new Date());
    }

    /**
     * Verify the given date does not come before other date, throws exception if it is.
     * @param date The date to verify is not null or before other date
     * @return the original date if no exception thrown
     * @throws IllegalArgumentException if date is null or before other time.
     */
    private Date verifyDateNotBeforeOther(Date date, Date other) {
        if (date == null) { // edge case: throw exception if date is null
            throw new IllegalArgumentException("Illegal date. Date must not be null.");
        } else if (date.before(other)) { // throw exception if date is before current time
            throw new IllegalArgumentException("Illegal date-(" + date.getTime() + "ms.) Date must be not be before date-(" + other.getTime() + "ms.)" );
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
