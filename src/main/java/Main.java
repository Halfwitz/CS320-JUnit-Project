import Service.ContactService.ContactService;
import Service.IdGenerator;
import Service.TaskService.Task;

public class Main
{
    public static void main(String[] args) throws Exception {
        ContactService contacts = new ContactService();
        contacts.addContact("First", "Last", "1234567890", "Home");
        contacts.addContact("Sheldon", "Cooper", "1234567890", "Space");

        contacts.addContact("Song", "Bob", "1234567890", "Ocean");
        contacts.deleteContact("1");

       // contacts.updatePhoneNumber("0", "12345");
        IdGenerator.printCounters();
        Task t = new Task("do laundry", "put laundry in washer then dryer");
        IdGenerator.printCounters();
        Task t2 = new Task("do stuff", "put laundry in washer then dryer");

        System.out.println(t);
        System.out.println(t2);

        t.updateField("name", "new name");
        System.out.println(t);
        IdGenerator.printCounters();




    }
}