package User_case.Items_Usercase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import Entity.Exit;
import Entity.Key;
import Entity.NPC;
import Entity.Item;
import User_case.Items_Usercase.ItemOutputBoundaryInterface;
import User_case.Items_Usercase.ItemInputBoundary;

class ItemInputBoundaryTest {

    private ItemInputBoundary itemInputBoundary;
    private ItemOutputBoundaryInterface outputBoundary;
    private Item mockItem;
    private Item playerLocation;

    @BeforeEach
    void setUp() {
        // Initialize the output boundary to check output during tests
        outputBoundary = new ItemOutputBoundary();  // Assuming ItemOutputBoundary implements ItemOutputBoundaryInterface

        // Create instances of the actual items used in the tests
        mockItem = new Key("Golden Key", "A shiny golden key", "floor", 1, "regular"); // Creating a Key instance
        playerLocation = new Exit("Locked Door", "A locked exit door", "on floor", "regular");  // Creating an Exit instance (locked)
    }

    @Test
    void testPickup() {
        // Test for picking up a Key item
        itemInputBoundary = new ItemInputBoundary(mockItem, outputBoundary);

        Item pickedUpItem = itemInputBoundary.pickup();

        // Verify that the Key was picked up correctly
        assertNotNull(pickedUpItem);  // It should return the Key item
        assertEquals(mockItem, pickedUpItem);  // The returned item should be the Key
    }

    @Test
    void testInteractWithExitAndNoKey() {
        // Create an Exit item (locked)
        Exit exit = new Exit("Locked Door", "A locked exit door", "on floor", "regular");

        // Create an Equipment item (which isn't a Key)
        Item equipment = new Key("Golden Key", "A shiny golden key", "on floor", 1, "regular");

        // Create ItemInputBoundary instance with the Exit
        itemInputBoundary = new ItemInputBoundary(exit, outputBoundary);

        // Simulate the interaction (player does not have a key)
        itemInputBoundary.interact(equipment);  // Should print a message about the failed attempt to unlock the exit

        // Check if the correct message was displayed
        assertEquals(outputBoundary.getMessage(), "you tried to pick the lock but it didn't work");
    }

    @Test
    void testInteractWithExitAndKey() {
        // Create an Exit item (locked)
        Exit exit = new Exit("Locked Door", "A locked exit door", "on floor", "regular");

        // Create a Key item that will be used to unlock the exit
        Key key = new Key("Golden Key", "A shiny golden key", "on floor", 1, "regular");

        // Create ItemInputBoundary instance with the Exit
        itemInputBoundary = new ItemInputBoundary(exit, outputBoundary);

        // Simulate the interaction (player has the correct key)
        itemInputBoundary.interact(key);  // Should unlock the exit

        // Check if the correct output was displayed
        assertEquals(outputBoundary.getMessage(), "You unlocked the door! You walk through the doorway.");
    }

    @Test
    void testInspect() {
        // Create an Item instance to inspect
        Item itemToInspect = new Key("Golden Key", "A shiny golden key", "on floor", 1, "regular");

        // Create ItemInputBoundary instance with the Key item
        itemInputBoundary = new ItemInputBoundary(itemToInspect, outputBoundary);

        // Simulate the Inspect action
        itemInputBoundary.Inspect();

        // Verify if the inspect output contains correct information
        assertEquals(outputBoundary.getMessage(), "Inspecting the item: Golden Key: A shiny golden key.");
    }

    @Test
    void testInteractWithNPCForRiddle() {
        // Create an NPC instance
        NPC npc = new NPC("Bob", "First NPC", "Wearing a green hat and has a big nose", "Hi!");

        // Create ItemInputBoundary instance with the NPC
        itemInputBoundary = new ItemInputBoundary(npc, outputBoundary);

        // Simulate interacting with the NPC and choosing the riddle option
        itemInputBoundary.interact(playerLocation);

        // Verify if the interaction prompted a riddle or speech
        // Assuming outputBoundary will store the results
        assertEquals(outputBoundary.getMessage(), "Would you like a riddle or my speech dialogue?");
    }
}

