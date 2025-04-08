import java.io.*;

public class User {
    // Attributes

    private final String name;
    private final int userID;
    private final String email;
    private final String phoneNumber;

    // Methods

    public User(String name, String email, String phoneNumber, int userID) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userID = userID;
    }

    // Save to file

    public void saveUserDetails() {
        try {
            String fileName = this.name + this.userID + ".txt";
            File userFile = new File(fileName);

            if(userFile.exists()) {
                System.out.println("File for this user already exists.");
            } else {
                if(userFile.createNewFile()) {
                    System.out.println("File created successfully.");
                    System.out.println("File location: " + userFile.getAbsolutePath());
                }

                FileWriter myWriter = new FileWriter(fileName);
                myWriter.write("User ID: " + this.userID + "\n");
                myWriter.write("User Name: " + this.name + "\n");
                myWriter.write("Email: " + this.email + "\n");
                myWriter.write("Phone Number: " + this.phoneNumber + "\n");
                myWriter.close();
            }
        } catch (IOException e) {
            System.out.println("File creation unsuccessful.");
        }
    }
}