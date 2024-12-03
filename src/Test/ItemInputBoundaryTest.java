import User_case.Items_Usercase.ItemOutputBoundary;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import Entity.Exit;
import Entity.Key;
import Entity.Item;
import User_case.Items_Usercase.ItemInputBoundary;

class ItemInputBoundaryTest {

    private ItemInputBoundary itemInputBoundary;
    private ItemOutputBoundary outputBoundary;
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

}

