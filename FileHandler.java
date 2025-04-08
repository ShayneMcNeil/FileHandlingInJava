import java.io.*;
import java.util.*;

class FileHandler {
    public static void main(String[] args) {
        System.out.println("===== USER CREATION SYSTEM =====\n");
        System.out.println("Welcome to the User Creation System, which allows you to create user profiles and save that info to a local file.\n");

        int userID;
        String name;
        String email;
        String phoneNumber;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the User ID: ");
        userID = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter user name: ");
        name = scanner.nextLine();
        System.out.println("Enter user's email address: ");
        email = scanner.nextLine();
        System.out.println("Enter user's phone number: ");
        phoneNumber = scanner.nextLine();

        User newUser = new User(name, email, phoneNumber, userID);
        newUser.saveUserDetails();

        // Display information that was written to the file

        try {
            String fileName = name + userID + ".txt";
            File newFile = new File(fileName);

            Scanner reader = new Scanner(newFile);

            while(reader.hasNextLine()) {
                String line = reader.nextLine();
                System.out.println(line);
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Could not read contents of the file.");
        }

    }
}