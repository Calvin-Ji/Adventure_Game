package User_case.PlayerUsercase;

/**
 * The inputBoundaryInterface defines the player's actions and interactions in the game.
 * It acts as the boundary between the game's input logic and the core business rules.
 */
public interface inputBoundaryInterface {

    /**
     * Moves the player to the specified item's location in the current room.
     *
     * @param itemName The name of the item the player wants to walk to.
     */
    void walkTo(String itemName);

    /**
     * Picks up the specified item if the player is able to do so.
     *
     * @param itemName The name of the item the player wants to pick up.
     */
    void pickUp(String itemName);

    /**
     * Interacts with a specified item that the player is holding or near.
     * @param itemName The name of the item the player wants to interact with.
     */
    void interact(String itemName);

    /**
     * Inspects the contents of the player's bag and lists the items inside.
     */
     void inspectBag();

    /**
     * Retrieves an item from the player's bag and places it into their hand.
     *
     * @param itemName The name of the item the player wants to take out of the bag.
     */
    void getFromBag(String itemName);


    /**
     * Places the currently held item into the player's bag if there is space.
     */
    void putInBag();

    /**
     * Interacts with an item the player is holding and another item at the player's location.
     *
     * @param holdingWhat    The name of the item the player is holding.
     * @param itemAtLocation The name of the item at the player's location.
     */
    void interact(String holdingWhat, String itemAtLocation);

    void interact_spiderweb();

}

