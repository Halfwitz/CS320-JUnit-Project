package Service;
/******************************************************************************
 * Module Three Milestone
 * [Entity.java]
 * Author: Michael Lorenz
 * - CS320 - Software Test, Automation QA
 * - Southern New Hampshire University
 *
 * Description:
 * This abstract class provides common functionality to use or implement in
 * each class stored in a service class.
 *
 * Date: Due 9/29/2024
 *****************************************************************************/
public abstract class Entity {
    protected final String id;

    // initialize this object with a unique id
    protected Entity() throws Exception {
        this.id = IdGenerator.generateId(this.getClass());
    }

    protected String verifyNonNullWithinChars(String str, int charLimit) {
        if (str == null) {
            throw new IllegalArgumentException("Invalid string, must be non-null value.");
        }
        if (str.length() > charLimit) {
            throw new IllegalArgumentException("Invalid string, " + str + ", must be less than " + charLimit + " characters.");
        }

        return str;
    }

    public abstract void updateField(String fieldName, String value);

    public String getId() {
        return id;
    }

}
