package src.Test.UNITest;

import Entity.Item;
import Entity.Exit;
import Entity.Equipment;
import Entity.Key;
import User_case.Items_Usercase.ItemInputBoundary;
import User_case.Items_Usercase.ItemOutputBoundaryInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    private TestGameGUIOutputBoundary testOutputBoundary;
    private ItemInputBoundary itemInputBoundary;

    private Key key;
    private Exit exit;
    private Equipment sword;
    private Item dummyItem;

    @BeforeEach
    void setUp() {
        // Initialize test components
        key = new Key("mail_box", "There is a key in the mail_box!", "a key lies on the floor", 1, "regular");
        exit = new Exit("gate", "The exit, but it is covered by a thick spider web", "there is a heavy gate in front of you");
        sword = new Equipment("Dragonfang Sword", "a weapon bestowed only upon warriors chosen by the Dragon Clan. Forged from the indestructible fangs of dragons, it holds the power of the dragon!", 
                               "a sword is stuck on the wall", 4, null);
        dummyItem = new Equipment("Dummy", "A test item", "A test item description", 1, "test");

        testOutputBoundary = new TestGameGUIOutputBoundary();
    }

    @Test
    void testInspect() {
        // Test inspecting different types of items
        itemInputBoundary = new ItemInputBoundary(key, testOutputBoundary);
        itemInputBoundary.Inspect();
        assertEquals("Inspecting the item: mail_box: There is a key in the mail_box!", testOutputBoundary.getLastMessage());

        itemInputBoundary = new ItemInputBoundary(sword, testOutputBoundary);
        itemInputBoundary.Inspect();
        assertEquals("Inspecting the item: Dragonfang Sword: a weapon bestowed only upon warriors chosen by the Dragon Clan. Forged from the indestructible fangs of dragons, it holds the power of the dragon!", testOutputBoundary.getLastMessage());
    }

    @Test
    void testInteractWithExit() {
        // Test interacting with an Exit and a Key

        // Case 1: Interacting with a locked Exit without the key
        itemInputBoundary = new ItemInputBoundary(exit, testOutputBoundary);
        itemInputBoundary.interact(key);  // player_location is a Key
        assertEquals("you tried to pick the lock but it didn't work", testOutputBoundary.getLastMessage());

        // Case 2: Interacting with an Exit with the Key
        itemInputBoundary = new ItemInputBoundary(exit, testOutputBoundary);
        itemInputBoundary.interact(key);  // Interact with Key, assume it's the correct key
        assertEquals("You unlocked the door! You walk through the doorway.", testOutputBoundary.getLastMessage());
    }

    @Test
    void testInteractWithNPC() {
        // Test interacting with an NPC
        NPC npc = new NPC("NPC", "I am an NPC", "I offer a riddle", "What is 2 + 2?", "4");

        itemInputBoundary = new ItemInputBoundary(npc, testOutputBoundary);

        // Case 1: NPC offers a riddle
        itemInputBoundary.interact(dummyItem); // dummyItem triggers interaction
        assertTrue(testOutputBoundary.getLastMessage().contains("Would you like a riddle or my speech dialogue?"));

        // Case 2: NPC gives a speech
        itemInputBoundary.interact(dummyItem); // dummyItem triggers interaction
        assertTrue(testOutputBoundary.getLastMessage().contains("Here is my speech dialogue: I offer a riddle"));
    }

    @Test
    void testPickup() {
        // Test picking up different types of items

        // Case 1: Picking up a Key
        itemInputBoundary = new ItemInputBoundary(key, testOutputBoundary);
        Item pickedUpItem = itemInputBoundary.pickup();
        assertNotNull(pickedUpItem);  // The item picked up should not be null
        assertEquals(key, pickedUpItem);  // The item picked up should be the key
        assertEquals("You pickup mail_box", testOutputBoundary.getLastMessage());

        // Case 2: Picking up Equipment
        itemInputBoundary = new ItemInputBoundary(sword, testOutputBoundary);
        pickedUpItem = itemInputBoundary.pickup();
        assertNotNull(pickedUpItem);  // The item picked up should not be null
        assertEquals(sword, pickedUpItem);  // The item picked up should be the sword
        assertEquals("You pickup Dragonfang Sword", testOutputBoundary.getLastMessage());

        // Case 3: Attempting to pick up an Exit
        itemInputBoundary = new ItemInputBoundary(exit, testOutputBoundary);
        pickedUpItem = itemInputBoundary.pickup();
        assertNull(pickedUpItem);  // Picking up an Exit should return null
        assertEquals("You can't just lift the exit, silly!", testOutputBoundary.getLastMessage());
    }

}


