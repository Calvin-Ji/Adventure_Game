package User_case.PlayerUsercase;

import java.util.List;
import Entity.Item;

/**
 * The outBoundary class implements the outputBoundaryInterface.
 * It handles the display of messages and inventory contents to the player.
 */
public class PlayerOutBoundary implements outputBoundaryInterface {

    /**
     * Displays a general message to the player.
     * @param message The message to be displayed.
     */
    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    /**
     * Displays the contents of the player's bag, listing each item with its name and description.
     * @param items The list of items in the player's bag.
     */
    @Override
    public void displayBagContents(List<Item> items) {
        System.out.println("Items in your bag:");
        for (Item item : items) {
            System.out.println("- " + item.getName() + ": " + item.getDescription());
        }
    }
}
