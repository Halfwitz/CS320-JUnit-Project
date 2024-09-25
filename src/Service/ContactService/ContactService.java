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
 *****************************************************************************/
package Service.ContactService;
import java.util.HashMap;
import java.util.Map;

public class ContactService {
    /**
     * Used to identify a unique id for each new contact. This number
     * is unique no matter which ContactService instance.
     * - Incremented by createUniqueId()
     */
    private static int idCounter = 0;
    /**
     * Container for set of contacts, maps contact id to contact object.
     */
    private final Map<String, Contact> contacts = new HashMap<>();

    /**
     * generates unique id using static int idCounter
     * @return idCounter String and then increments by 1.
     */
    private static String createUniqueId() {
        return String.valueOf(idCounter++);
    }
    // Used for testing purposes--this method resets unique id counter to 0 (for isolated testing)
    public static void resetIdCounter() {
        idCounter = 0;
    }

    /**
     * Return a contact from contacts
     * @param id the unique id used to identify a Contact in contacts map
     * @return contact associated with given id key from contacts map
     * @throws IllegalArgumentException if contact with id can't be found
     */
    public Contact getContactById(String id) {
        Contact contact = contacts.get(id);
        if (contact == null) {
            throw new IllegalArgumentException("Contact with ID " + id + " does not exist");
        }
        return contact;
    }

    // add contact by mapping unique id to contact object in contacts map.

    /**
     * Adds a contact object mapped to its unique id in contacts map.
     * @param firstName - Contact's first name
     * @param lastName Contact's last name
     * @param phoneNumber Contacts phone number
     * @param address Contacts address
     * @throws IllegalArgumentException in Contact object if parameters are invalid format
     */
    public void addContact(String firstName, String lastName, String phoneNumber, String address) {
        String uniqueId = createUniqueId();
        contacts.put(uniqueId, new Contact(uniqueId, firstName, lastName, phoneNumber, address));
    }

    /**
     * Removes a contact object with given id from contacts map
     * @param id Unique identifier of the contact to delete
     * @throws IllegalArgumentException if contact does not exist
     */
    public void deleteContact(String id) {
        contacts.remove(id);
    }

    // UPDATE CONTACT FIELDS
    /**
     * Updates first name of contact with given id to firstName
     * @param id Unique identifier of the contact to update
     * @param firstName new first name (non-null, <= 10 chars)
     * @throws IllegalArgumentException if contact does not exist or firstName is invalid
     */
    public void updateFirstName(String id, String firstName) {
        getContactById(id).setFirstName(firstName);
    }
    /**
     * Updates last name of contact with given id to lastName
     * @param id Unique identifier of the contact to update
     * @param lastName new last name (non-null, <= 10 chars)
     * @throws IllegalArgumentException if contact does not exist or lastName is invalid
     */
    public void updateLastName(String id, String lastName) {
        getContactById(id).setLastName(lastName);
    }
    /**
     * Updates phone number of contact with given id to phoneNumber
     * @param id Unique identifier of the contact to update
     * @param phoneNumber new phone number (non-null, must be 10 chars)
     * @throws IllegalArgumentException if contact does not exist or phoneNumber is invalid
     */
    public void updatePhoneNumber(String id, String phoneNumber) {
        getContactById(id).setPhoneNumber(phoneNumber);
    }
    /**
     * Updates address of contact with given id to address
     * @param id Unique identifier of the contact to update
     * @param address new address (non-null, <= 30 chars)
     * @throws IllegalArgumentException if contact does not exist or address is invalid
     */
    public void updateAddress(String id, String address) {
        getContactById(id).setAddress(address);
    }

    /*public void printContacts() {
        for (Contact contact : contacts.values()) {
            System.out.println(contact);
        }
    }*/
}
