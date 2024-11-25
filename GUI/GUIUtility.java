package GUI;

import javax.swing.*;
import java.util.Set;

public class GUIUtility {

    /**
     * Displays a message in a pop-up window, mimicking System.out.println.
     * @param message The message to display.
     */
    public static void displayOutput(String message) {
        JOptionPane.showMessageDialog(null, message, "Output", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Displays a pop-up input dialog to get user input, mimicking Scanner input.
     *
     * @param prompt  The prompt message to display.
     * @param options
     * @return The user's input as a String.
     */
    public static String getInput(String prompt, String[] options) {
        return JOptionPane.showInputDialog(null, prompt, "Input", JOptionPane.QUESTION_MESSAGE);
    }

    /**
     * Prompts the user for input, validates it against a set of valid options,
     * and asks again if the input is invalid.
     *
     * @param prompt       The message to display for input.
     * @param validOptions A set of valid input options.
     * @return A valid input string.
     */
    public static String getValidInput(String prompt, Set<String> validOptions) {
        String input;
        do {
            input = JOptionPane.showInputDialog(null, prompt, "Input", JOptionPane.QUESTION_MESSAGE);

            // Handle the case where the user cancels or closes the input dialog
            if (input == null) {
                JOptionPane.showMessageDialog(null, "Action canceled.", "Canceled", JOptionPane.WARNING_MESSAGE);
                return null; // Return null to indicate no valid action
            }

            input = input.trim().toLowerCase(); // Normalize input
            if (!validOptions.contains(input)) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } while (!validOptions.contains(input));

        return input;
    }
}
