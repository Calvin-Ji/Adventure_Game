package Item;

public abstract class Item {
    private String name;
    private String description;
    private String floorDescription;
    private String type;
    private boolean locked;
    private int damage;

    // This is a constructor for Item; it cannot be directly instantiated but can be used by concrete subclasses.
    public Item(String name, String description, String floorDescription, String type) {
        this.name = name;
        this.description = description;
        this.floorDescription = floorDescription;
        // item on ground should have different discription compared with item picked up & in inventory
        this.type = type;
    }

    // Abstract method to interact with the item
    public abstract void interact(Item location);

    public void interact(){
        System.out.println("you stare at " + name + " blankly. Nothing happens");
    }

    // Regular method to pick up the item
    // this method should to regularly overrided such that awkward moment of you picked up exit will not happen
    public abstract Item pickup();

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getFloorDescription() {
        return floorDescription;
    }

    public boolean getLocked(){
        return locked;
    }

    public String getType() {
        return type;
    }

    public int getDamage() {return damage;}

    public void setLocked(boolean key) {
        this.locked = key;
    }
}