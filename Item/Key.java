package Item;

import GUI.GUIUtility;

public class Key extends Item{
    int damage = 1;
    String element = "Regular";
    boolean used = false; // yeah we need this

    // Constructor for Item.Key that calls the Item.Item constructor
    public Key(String name, String description, String floorDescription, int damage, String element) {
        // Call the constructor of Item.Item class with parameters
        super(name, description, floorDescription,"Key"); // Pass values to the superclass constructor
        this.damage = damage;
        this.element = element;
    }

    @Override

    public void interact(Item player_location) {
        if (player_location.getType() == "Exit" && used) {
            System.out.println(this.getName() + " does not match the" + player_location.getName());
        } else if (player_location.getType() == "Exit" && used == false) {
            System.out.println("You have cleared the " + player_location.getName() + " you can leave the room at anytime" );
            player_location.setLocked(false);
            used = true;
        } else {
            System.out.println("you poked the" + this.getName() + " onto " + player_location.getName()+ " nothing happens");
        }
        return;
    }

    @Override
    public Item pickup(){
        System.out.println("You have picked up the " + this.getName());
        return this;
    }

    public String getElement() {
        return element;
    }

}
