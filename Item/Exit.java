package Item;

import GUI.GUIUtility;

public class Exit extends Item{
    private Boolean locked = true;

    // Constructor for Item.Exit that calls the Item.Item constructor
    public Exit(String name, String description, String floorDescription, int damage) {
        // Call the constructor of Item.Item class with parameters
        super(name, name, description, floorDescription, damage, "Item.Exit"); // Pass values to the superclass constructor
    }

    @Override
    public void Interact(Item location) {
        // TODO: we can use this code once we have a game with current player as a global variable
        if (this.locked) {
            GUIUtility.displayOutput("you tried to pick the lock with {} but it didn't work");
        }
        else {
            GUIUtility.displayOutput("the door is already opened, there is no point to pick the lock");
        }
    }

    // it is possible that player interacts sth with no other items
    public void Interact() {
        // TODO: we can use this code once we have a game with current player as a global variable
        if (this.locked) {
            GUIUtility.displayOutput("the door is still locked and you cannot pass");
        }
        else {
            GUIUtility.displayOutput("You walk into the door and leave the room.");
        }
    }

    public boolean isLocked() {
        return locked;
    }
    public void setLocked(boolean lock) {
        this.locked = lock;
    }

    @Override
    public Item pickup() {
        GUIUtility.displayOutput("You can't just lift the exit, silly!");
        return null;
    }
}
