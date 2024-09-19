/******************************************************************************
 * Module Three Milestone
 * [Contact.java]
 * Author: Michael Lorenz
 * - CS320 - Software Test, Automation QA
 * - Southern New Hampshire University
 *
 * Description:
 * This class represents a contact object with fields for unique contact id,
 * first name, last name, phone number, and address. It enforces constraints:
 * - contactId, firstName, lastName must be non-null and <= 10 chars
 * - phone must be 10 chars and non-null
 * - address must be <= 30 chars and non-null
 *
 * Date: Due 9/22/2024
 *****************************************************************************/
package ContactService;

public class Contact {
    private final String contactId;    // unique up to 10 chars
    private String firstName;   // required, up to 10 chars
    private String lastName;    // required, up to 10 chars
    private String phone;       // required, up to 10 digits
    private String address;     // required, up to 30 chars

    /**
     * Initializes a new Contact object
     * @param id The unique ID for the contact (non null, <= 10 chars)
     * @param firstName first name (non-null, <= 10 chars)
     * @param lastName last name (non-null, <= 10 chars)
     * @param phone phone number (exactly 10 chars)
     * @param address address (non-null, <= 30 chars)
     * @throws IllegalArgumentException if parameters are invalid.
     */
    protected Contact(String id, String firstName, String lastName, String phone, String address) {
        // check null and length requirements & throw exceptions
        if (id == null || id.length() > 10) {
            throw new IllegalArgumentException("Invalid id");
        }
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }
        this.contactId = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    /**
     * Updates firstName
     * @param firstName new first name (non-null, <= 10 chars)
     * @throws IllegalArgumentException if parameter is invalid
     */
    protected void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
        this.firstName = firstName;
    }
    /**
     * Updates lastName
     * @param lastName new first name (non-null, <= 10 chars)
     * @throws IllegalArgumentException if parameter is invalid
     */
    protected  void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
        this.lastName = lastName;
    }
    /**
     * Updates phone
     * @param phoneNumber new phone number (non-null, exactly 10 chars)
     * @throws IllegalArgumentException if parameter is invalid
     */
    protected void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.length() != 10) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        this.phone = phoneNumber;
    }
    /**
     * Updates address
     * @param address new address (non-null, <= 30 chars)
     * @throws IllegalArgumentException if parameter is invalid
     */
    protected void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }
        this.address = address;
    }

    protected String getId() {
        return contactId;
    }
    protected String getFirstName() {
        return firstName;
    }
    protected String getLastName() {
        return lastName;
    }
    protected String getPhone() {
        return phone;
    }
    protected String getAddress() {
        return address;
    }

    /*public String toString() {
        return "["+getId()+"] "+"Name:[" + firstName + " " + lastName + "]; Number:[" + phone + "]; Address:[" + address + "];";
    }*/
}
