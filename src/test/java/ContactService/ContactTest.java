/****************************************************************
 * Module Three Milestone
 * [ContactTest.java]
 * Author: Michael Lorenz
 * - CS320 - Software Test, Automation QA
 * - Southern New Hampshire University
 *
 * Description:
 * This class contains unit tests for Contact class. Verifies the
 * requirements of acceptable variables.
 *
 * Data: Due 9/22/2024
 ****************************************************************/
package ContactService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactTest
{
    // Test creating a contact object
    @DisplayName("Test initializing Contact and match parameters to variables")
    @Test
    void testInitializeContact() {
        Contact contact = new Contact("001", "John", "Marston", "7034224806", "Phoenix, Arizona");
        assertEquals("001", contact.getId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Marston", contact.getLastName());
        assertEquals("7034224806", contact.getPhone());
        assertEquals("Phoenix, Arizona", contact.getAddress());
    }

    // Requirement 1: contact ID string cannot be longer than 10 characters, shall not be null, and shall not be updatable
    @DisplayName("Test when contact ID is 11 characters, should throw exception")
    @Test
    void testContactIdTooLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678910", "John", "Marston", "1002003000", "Phoenix, Arizona");
        });
    }
    @DisplayName("Test when contact ID is null, should throw exception")
    @Test
    void testContactIdIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Marston", "1002003000", "Phoenix, Arizona");
        });
    }
    @DisplayName("Test if Contact id is not updatable")
    @Test
    void testContactIdIsNotUpdatable() {
        // contactID is a final variable and does not have an associated setter,
        // cannot be modified
    }

    // Requirement 2: required firstName string cannot be longer than 10 chars and shall not be null
    @DisplayName("Test when contact firstName is 11 characters, should throw exception")
    @Test
    void testContactFirstNameTooLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0", "Johnathoonn", "Marston", "1002003000", "Phoenix, Arizona");
        });
    }
    @DisplayName("Test when contact firstName is null, should throw exception")
    @Test
    void testContactFirstNameIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0", null, "Marston", "1002003000", "Phoenix, Arizona");
        });
    }

    // Requirement 3: required lastName string cannot be longer than 10 chars and shall not be null
    @DisplayName("Test when contact lastName is 11 characters, should throw exception")
    @Test
    void testContactLastNameTooLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0", "John", "NameIsLongs", "1002003000", "Phoenix, Arizona");
        });
    }
    @DisplayName("Test when contact lastName is null, should throw exception")
    @Test
    void testContactLastNameIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0", "John", null, "1002003000", "Phoenix, Arizona");
        });
    }

    // Requirement 4: required phone string must be 10 chars and shall not be null
    @DisplayName("Test when contact phone number is 9 characters, should throw exception")
    @Test
    void testContactPhoneNumberTooShort() {
        // < 10 chars
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0", "John", "Marston", "123456789", "Phoenix, Arizona");
        });
    }
    @DisplayName("Test when contact phone number is 11 characters, should throw exception")
    @Test
    void testContactPhoneNumberTooLong() {
        // > 10 chars
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0", "John", "Marston", "12345678910", "Phoenix, Arizona");
        });
    }
    @DisplayName("Test when contact phone number is null, should throw exception")
    @Test
    void testContactPhoneNumberIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0", "John", "Marston", null, "Phoenix, Arizona");
        });
    }

    // Requirement 5: required address string cannot be longer than 30 chars and shall not be null
    @DisplayName("Test when contact address is 31 characters, should throw exception")
    @Test
    void testContactAddressTooLong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0", "John", "Marston", "0123456789", "19 Some Street Phoenix, Arizona");
        });
    }
    @DisplayName("Test when contact address is null, should throw exception")
    @Test
    void testContactAddressIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0", "John", "Marston", "0123456789", null);
        });
    }
}