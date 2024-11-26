package Item;

import java.util.Scanner;

public class NPC extends Item {
    String Riddle;
    String Speech;

    // Constructor for Item.NPC that calls the Item.Item constructor
    public NPC(String name, String description, String floorDescription, String Riddle, String Speech) {
        // Call the constructor of Item.Item class with parameters
        super(name, description, floorDescription,"NPC"); // Pass values to the superclass constructor
        this.Riddle = Riddle;
        this.Speech = Speech;
    }

    @Override
    public void interact(Item location) {
        // Create a Scanner object to read input from the terminal
        Scanner scanner = new Scanner(System.in);

        // Print the options for the user
        System.out.println("Would you like a riddle or my speech dialogue? Enter 'riddle' for my riddle or 'speech' for my speech dialogue.");
        System.out.println("Enter 'exit' to exit.");

        // Read the user's input
        String userInput = scanner.nextLine().trim().toLowerCase();  // Read input, trim whitespace, and convert to lowercase

        // Handle different options based on the input
        switch (userInput) {
            case "riddle":
                // Call a method to give the riddle (this would be a placeholder)
                System.out.println("Here is your riddle: " + Riddle);
                break;

            case "speech":
                // Call a method to give the speech dialogue (this would be a placeholder)
                System.out.println("Here is my speech dialogue: " + Speech);
                break;

            case "exit":
                // Item.Exit the interaction
                System.out.println("Goodbye!");
                break;

            default:
                // If the input doesn't match any valid option, prompt again
                System.out.println("Invalid option. Please enter 'riddle', 'speech', or 'exit'.");
                break;
        }

        // Close the scanner
        scanner.close();
    }

    @Override
    public Item pickup() {
        System.out.println("What are you doing? Put me down at once!");
        return null;
    }
}