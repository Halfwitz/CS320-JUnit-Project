/******************************************************************************
 * Module Three Milestone
 * [ContactService.java]
 * Author: Michael Lorenz
 * - CS320 - Software Test, Automation QA
 * - Southern New Hampshire University
 *
 * Description:
 * This class supports managing Contact objects, supports functionality:
 * - Add new contacts with unique id
 * - Update fields of a contact by its id (first name, last name, phone number, address)
 * - Delete contacts by their id
 *
 * Date: Due 9/22/2024
 * Modified: 9/25/2024 to extend Service
 * Modified: 10/09/2024 to remove outer package dependencies
 *****************************************************************************/
package service.contactservice;
import service.Service;

public class ContactService extends BasicService<Contact>
{

    /**
     * Adds a contact object mapped to its unique id storage.
     * @param firstName - Contact's first name
     * @param lastName Contact's last name
     * @param phoneNumber Contacts phone number
     * @param address Contacts address
     * @throws IllegalArgumentException in Contact object if parameters are invalid format
     */
    public void add(String firstName, String lastName, String phoneNumber, String address) {
        Contact entity = new Contact(firstName, lastName, phoneNumber, address);
        add(entity);
    }

    // UPDATE CONTACT FIELDS
    /**
     * Updates first name of contact with given id to firstName
     * @param id Unique identifier of the contact to update
     * @param firstName new first name (non-null, <= 10 chars)
     * @throws IllegalArgumentException if contact does not exist or firstName is invalid
     */
    public void updateFirstName(String id, String firstName) {
        updateEntityField(id, "firstName", firstName);
    }
    /**
     * Updates last name of contact with given id to lastName
     * @param id Unique identifier of the contact to update
     * @param lastName new last name (non-null, <= 10 chars)
     * @throws IllegalArgumentException if contact does not exist or lastName is invalid
     */
    public void updateLastName(String id, String lastName) {
        updateEntityField(id, "lastName", lastName);
    }
    /**
     * Updates phone number of contact with given id to phoneNumber
     * @param id Unique identifier of the contact to update
     * @param phoneNumber new phone number (non-null, must be 10 chars)
     * @throws IllegalArgumentException if contact does not exist or phoneNumber is invalid
     */
    public void updatePhoneNumber(String id, String phoneNumber) {
        updateEntityField(id, "phone", phoneNumber);
    }
    /**
     * Updates address of contact with given id to address
     * @param id Unique identifier of the contact to update
     * @param address new address (non-null, <= 30 chars)
     * @throws IllegalArgumentException if contact does not exist or address is invalid
     */
    public void updateAddress(String id, String address) {
        updateEntityField(id, "address", address);

    }

    /*public void printContacts() {
        for (Contact contact : getEntities()) {
            System.out.println(contact);
        }
    }*/
}
