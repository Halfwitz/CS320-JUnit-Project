package service.contactservice;

/******************************************************************************
 * Module Three Milestone
 * [BasicEntity.java]
 * Author: Michael Lorenz
 * - CS320 - Software Test, Automation QA
 * - Southern New Hampshire University
 *
 * Description:
 * This abstract class provides common functionality to use or implement in
 * Appointment. Each instance has an id unique within
 * its type, can update variables with updateField, and throw exceptions for
 * invalid strings with verifyNonNullWithinChars().
 *****************************************************************************/
public abstract class BasicEntity
{
    protected final String id;
    protected final int ID_CHAR_LIMIT = 10;
    // initialize this object with a unique id (no more than 10 chars, required, non-null
    protected BasicEntity() {

        this.id = verifyNonNullWithinChars(BasicIdGenerator.generateId(this.getClass()), 1, ID_CHAR_LIMIT);
    }

    /**
     * Verifies and returns a string if it is a valid format, throws an exception if it isn't
     * @param str string to verify
     * @param minCharNum minimum allowed number of characters (inclusive)
     * @param maxCharNum maximum allowed number of characters (inclusive)
     * @return the original str string
     * @throws IllegalArgumentException if str is null, contains leading or trailing whitespace, or not within
     * allowed number of chars (inclusive)
     */
    protected String verifyNonNullWithinChars(String str, int minCharNum, int maxCharNum) {
        // CHECK EDGE CASES
        if (str == null) {
            throw new IllegalArgumentException("Invalid string, must be non-null value.");
        }
        // no leading/trailing whitespace
        String trueStr = str.strip();
        // if str and str.strip() lengths are different, contains invalid leading/trailing characters
        if (str.length() != str.strip().length()) { // (strip() removes leading/trailing whitespace
            throw new IllegalArgumentException("Invalid string, be sure to remove leading or trailing spaces.");
        }
        // if str has too little or too many characters, throw exception
        if (trueStr.length() > maxCharNum || trueStr.length() < minCharNum) {
            throw new IllegalArgumentException("Invalid string, " + str + ", must be within" + minCharNum + "-" + maxCharNum + " characters.");
        }
        // Return data if no exceptions thrown
        return str;
    }

    /** UNNECESSARY unless string to be verified can be 0 chars
     * Verifies and returns a string if it is a valid format, throws an exception if it isn't
     * @param str string to verify
     * @param maxCharNum maximum allowed number of characters (inclusive)
     * @return the original str string
     * @throws IllegalArgumentException if str is null, has leading/trailing whitespace, or too many chars.
     */
    /*protected String verifyNonNullWithinChars(String str, int maxCharNum) {
        return verifyNonNullWithinChars(str, 0, maxCharNum);
    }*/

    /**
     * Updates a specific field of the object with the provided value.
     * (could implement using switch cases for each fieldName in an entity)
     * @param fieldName the name of the field to update.
     * @param value the new value to set for the specified field.
     * @throws IllegalArgumentException if the fieldName is invalid or does not exist.
     */
    protected abstract void updateField(String fieldName, String value);

    public String getId() {
        return id;
    }

}
