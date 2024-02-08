import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBook {
    private static Map<String, String> contacts = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Address Book");

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Add a new contact");
            System.out.println("2. Search for a contact");
            System.out.println("3. Display all contacts");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addContact(scanner);
                    break;
                case 2:
                    searchContact(scanner);
                    break;
                case 3:
                    displayContacts();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please select again.");
            }
        }
    }

    private static void addContact(Scanner scanner) {
        System.out.print("Enter the name: ");
        String name = scanner.next();
        System.out.print("Enter the phone number: ");
        String phoneNumber = scanner.next();
        System.out.print("Enter the email address: ");
        String emailAddress = scanner.next();

        contacts.put(name, "Phone: " + phoneNumber + ", Email: " + emailAddress);
        System.out.println("Contact added successfully!");
    }

    private static void searchContact(Scanner scanner) {
        System.out.print("Enter the name to search: ");
        String name = scanner.next();

        if (contacts.containsKey(name)) {
            System.out.println("Contact details: " + contacts.get(name));
        } else {
            System.out.println("Contact not found!");
        }
    }

    private static void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Address book is empty.");
        } else {
            System.out.println("Contacts:");
            for (String name : contacts.keySet()) {
                System.out.println(name + " - " + contacts.get(name));
            }
        }
    }
}

