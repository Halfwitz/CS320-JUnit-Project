import ContactService.ContactService;
import ContactService.Contact;

public class Main
{
    public static void main(String[] args) {
        ContactService contacts = new ContactService();
        contacts.addContact("First", "Last", "12345678900", "Home");
        contacts.addContact("Sheldon", "Cooper", "12345678900", "Space");

        contacts.addContact("Song", "Bob", "12345678900", "Ocean");
        contacts.deleteContact("1");

        contacts.updatePhoneNumber("0", "12345");


    }
}