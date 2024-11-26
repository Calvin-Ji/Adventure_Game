package Item;

import DungenKeeper.Room;

public class Exit extends Item{
    private Boolean locked = true;
    private Room whichRoom;
    // I would love to get rid of this attribute

    // Constructor for Item.Exit that calls the Item.Item constructor
    public Exit(String name, String description, String floorDescription) {
        // Call the constructor of Item.Item class with parameters
        super(name, description, floorDescription, "Exit"); // Pass values to the superclass constructor
        this.whichRoom = null;
    }

    @Override
    public void interact(Item location) {
        if (this.locked && location.getType() != "Key") {
            System.out.println("you tried to pick the lock but it didn't work");
        }
        else {
            System.out.println("the door is already opened");
        }
    }

    @Override
    public void interact() {
        if (this.locked) {
            System.out.println("the door is still blocked and you cannot pass");
        }
        else {
            System.out.println("You walk into the door and leave the room.");
            whichRoom.leave();
        }
    }

    public void setRoom(Room room) {
        this.whichRoom = room;
    }

    // it is possible that player interacts sth with no other items

    public boolean getLocked() {
        return locked;
    }
    public void setLocked(boolean lock) {
        this.locked = lock;
    }

    @Override
    public Item pickup() {
        System.out.println("You can't just lift the exit, silly!");
        return null;
    }
}