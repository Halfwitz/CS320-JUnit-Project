/******************************************************************************
 * Module Three Milestone
 * [Contact.java]
 * Author: Michael Lorenz
 * - CS320 - Software Test, Automation QA
 * - Southern New Hampshire University
 *
 * Description:
 * This class represents a contact object with fields for first name,
 * last name, phone number, and address. Parent class gives this unique id
 * when initialized. It enforces constraints:
 * - firstName, lastName must be non-null and <= 10 chars
 * - phone must be 10 chars and non-null
 * - address must be <= 30 chars and non-null
 *
 * Date: Due 9/22/2024
 * Modified: 9/29/2024 to extend Entity
 *****************************************************************************/
package service.contactservice;

import service.Entity;

public class Contact extends Entity
{
    private String firstName;   // required, up to 10 chars
    private String lastName;    // required, up to 10 chars
    private String phone;       // required, up to 10 digits
    private String address;     // required, up to 30 chars

    // maximum allowed number of characters for each field
    private final int NAME_CHAR_LIMIT = 10;
    private final int PHONE_CHAR_LIMIT = 10;
    private final int ADDRESS_CHAR_LIMIT = 30;

    /**
     * Initializes a new Contact object
     * @param firstName first name (non-null, <= 10 chars)
     * @param lastName last name (non-null, <= 10 chars)
     * @param phone phone number (exactly 10 chars)
     * @param address address (non-null, <= 30 chars)
     * @throws IllegalArgumentException if parameters are invalid.
     */
    public Contact(String firstName, String lastName, String phone, String address) {
        // initialize with unique id
        super();
        // check null and length requirements & throw exceptions
        this.firstName = verifyNonNullWithinChars(firstName, 1, NAME_CHAR_LIMIT);
        this.lastName = verifyNonNullWithinChars(lastName, 1, NAME_CHAR_LIMIT);
        this.phone = verifyNonNullWithinChars(phone, PHONE_CHAR_LIMIT, PHONE_CHAR_LIMIT);
        this.address = verifyNonNullWithinChars(address, 1, ADDRESS_CHAR_LIMIT);
    }

    /**
     * Updates firstName
     * @param firstName new first name (non-null, <= 10 chars)
     * @throws IllegalArgumentException if parameter is invalid
     */
    private void setFirstName(String firstName) {
        this.firstName = verifyNonNullWithinChars(firstName, 1, NAME_CHAR_LIMIT);
    }
    /**
     * Updates lastName
     * @param lastName new first name (non-null, <= 10 chars)
     * @throws IllegalArgumentException if parameter is invalid
     */
    private  void setLastName(String lastName) {
        this.lastName = verifyNonNullWithinChars(lastName, 1, NAME_CHAR_LIMIT);
    }
    /**
     * Updates phone
     * @param phoneNumber new phone number (non-null, exactly 10 chars)
     * @throws IllegalArgumentException if parameter is invalid
     */
    private void setPhoneNumber(String phoneNumber) {
        this.phone = verifyNonNullWithinChars(phoneNumber, PHONE_CHAR_LIMIT, PHONE_CHAR_LIMIT);
    }
    /**
     * Updates address
     * @param address new address (non-null, <= 30 chars)
     * @throws IllegalArgumentException if parameter is invalid
     */
    private void setAddress(String address) {
        this.address = verifyNonNullWithinChars(address, 1, ADDRESS_CHAR_LIMIT);
    }

    /**
     * Sets specified field name to new specified value. Allowed field names are
     * "firstname", "lastname", "phone", and "address".
     * @param fieldName field to modify.
     * @throws IllegalArgumentException if parameter value is invalid
     */
    @Override
    protected void updateField(String fieldName, String value) {
        switch (fieldName.toLowerCase()) {
            case "firstname" -> setFirstName(value);
            case "lastname" -> setLastName(value);
            case "phone" -> setPhoneNumber(value);
            case "address" -> setAddress(value);
            default -> throw new IllegalArgumentException("Unknown field name");
        }
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getPhone() {
        return phone;
    }
    public String getAddress() {
        return address;
    }

    /*public String toString() {
        return "[id:"+getId()+"];"+"[name:" + firstName + " " + lastName + "];[number:" + phone + "];[address:" + address + "];";
    }*/
}
