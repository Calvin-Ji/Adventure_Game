package Player;

import DungenKeeper.Room;
import Item.Item;

import java.util.List;

public class Player {
    private Item location; // The name of the location/item in the Room.room
    private Room currRoom; // The current Room.room number
    private Item holding; // The item currently being held
    private int health; // Health of the player
    private int damage; // Damage the player can deal
    private Inventory inventory;

    // Constructor
    public Player(int bagSize, int health, int damage, Room room) {
        this.inventory = new Inventory(bagSize);
        this.health = health;
        this.damage = damage;
        this.location = null; // Start with no specific location
        this.currRoom = room; // Default starting Room.room
        this.holding = null; // Start with no item in hand
    }

    // Location-related methods
    public Item getLocation() {
        return location;
    }

    public void setLocation(Item location) {
        this.location = location;
    }

    // Room-related methods
    public Room getCurrRoom() {
        return currRoom;
    }

    public void setCurrRoom(Room currRoom) {
        this.currRoom = currRoom;
    }

    // Holding item methods
    public Item getHolding() {
        return holding;
    }

    public void setHolding(Item holding) {
        this.holding = holding;
    }

    // Player status methods
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Inventory getInventory() {
        return inventory;
    }

    // these method might need to be put somewhere else

    public void walkTo(String itemName){
        if (this.currRoom.hasItem(itemName) == null){
            System.out.println("you cant walk to that destination as it doesnt exist");
            return;
        }else{
            System.out.println("you walked to " + itemName);
            this.location = this.currRoom.hasItem(itemName);
            return;
        }
    }

//this requires fixing: can pick up unpickable items such as exit and npc
    public void pickUp(String itemName){
        // you can only pick up the item when your hands are empty
        if (this.holding != null){
            System.out.println("you cant pickup item when you are holding stuff");
            return;
        }
        // you can only pick up the item if you are standing next to it
        if (this.location == null){
            System.out.println("there is nothing around you to pickup!");
            return;
        }
        this.holding = this.location;
        this.location = null;
        System.out.println("you pick up " + this.holding);
        }

    // Puts the currently held item into the inventory if there is space. If the player is not holding anything,
    // or if the inventory is full, it displays an appropriate message.
    public void putInBag(){
        if(this.holding == null) {
            System.out.println("You have nothing to put in the inventory");
        }
        else{
            if(inventory.getNumItemsInside() < inventory.getBagSize()){
                inventory.addItem(holding);
                holding = null;
            }
            else{
                System.out.println("Your inventory is full");
            }
        }
    }

    // Drops the currently held item, making the player no longer hold any item.
    public void drop(){
        if (this.holding == null){
            System.out.println("You have nothing to drop");
        }
        else {
            this.location = holding;
            holding = null;
        }
    }

    // Retrieves an item from the player's bag and places it into their hand.
    public void retrieveFromBag(String itemName) {
        // Check if the player is already holding an item
        if (holding != null) {
            System.out.println("You are already holding something. You need to drop it first.");
            return;
        }

        // Attempt to remove the specified item from the inventory
        Item retrievedItem = inventory.removeItem(itemName); // Assuming Inventory has a removeItem method

        // If the item exists in the bag, set it as the player's held item
        if (retrievedItem != null) {
            System.out.println("You took " + itemName + " out of your bag.");
            holding = retrievedItem;
        } else {
            // Item not found in the bag
            System.out.println("The item " + itemName + " is not in your bag.");
        }
    }

    public void inspectBag() {
        // Get the list of items from the inventory
        List<Item> items = this.inventory.getItemsInside(); // Assuming inventory has getItemsInside method

        // Check if the bag is empty
        if (items.isEmpty()) {
            System.out.println("Your bag is empty.");
        } else {
            System.out.println("Items in your bag:");
            // Loop through the list of items and print their details
            for (Item item : items) {
                System.out.println("- " + item.getName() + ": " + item.getDescription()); // Assuming Item has getName and getDescription methods
            }
        }
    }
}

