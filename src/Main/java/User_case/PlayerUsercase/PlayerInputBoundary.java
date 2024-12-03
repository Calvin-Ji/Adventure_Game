package User_case.PlayerUsercase;

import Entity.Player;
import Entity.Item;
import User_case.GameLevelsUserCase.LevelInteractor;
import User_case.InventoryUseCase.InventoryManagementInteractor;
import User_case.InventoryUseCase.InventoryOutputBoundary;
import User_case.Items_Usercase.ItemInputBoundary;
import User_case.Items_Usercase.ItemOutputBoundary;
import User_case.RoomUserCase.RoomInteraction;

import java.util.List;

/**
 * The inputBoundary class implements player actions and interactions in the game.
 * It processes user commands and delegates display messages to the outputBoundary.
 */
public class PlayerInputBoundary implements inputBoundaryInterface {
    private Player player;
    private outputBoundaryInterface outputBoundary;

    /**
     * Constructs an inputBoundary with the specified player and outputBoundary interface.
     * @param player The Player object representing the user in the game.
     * @param outputBoundary The interface responsible for displaying messages to the user.
     */
    public PlayerInputBoundary(Player player, outputBoundaryInterface outputBoundary) {
        this.player = player;
        this.outputBoundary = outputBoundary;
    }

    /**
     * Moves the player to the specified item's location within the current room.
     * @param itemName The name of the item the player wishes to walk to.
     */
    @Override
    public void walkTo(String itemName) {
        RoomInteraction roomInteractor = new RoomInteraction(this.player.getCurrRoom());
        LevelInteractor levelInteractor = new LevelInteractor(this.player.getCurrRoom().getGameLevel());
        if ( roomInteractor.findItem(itemName) == null) {
             outputBoundary.displayMessage("You can't walk to that destination as it doesn't exist.");
             return;
        }
        outputBoundary.displayMessage("You walked to " + itemName);
        player.setLocation(roomInteractor.findItem(itemName));
        if (roomInteractor.checkBattle(player.getLocation())) {
            levelInteractor.launchBattle(roomInteractor.removeBattle(player.getLocation()));
        }
    }

    /**
     * Picks up the specified item if the player's hands are free and the item is nearby.
     * @param itemName The name of the item the player wishes to pick up.
     */
    @Override
    public void pickUp(String itemName) {
        if (player.getHolding() != null) {
            outputBoundary.displayMessage("You can't pick up an item when you are holding something.");
            return;
        }
        // if (player.getLocation() == null) {
            // outputBoundary.displayMessage("There is nothing around you to pick up!");
            // return;
        //}
        if (player.getLocation().getName().equals(itemName)) {
            player.setHolding(new RoomInteraction(player.getCurrRoom()).pickUp(itemName));
            player.setLocation(null);
        } else {
            outputBoundary.displayMessage("You did not find " + itemName + " around you.");
        }
    }

    /**
     * Interacts with an item either in the player's hand or nearby.
     * @param whatItem The name of the item to interact with.
     */
    @Override
    public void interact(String whatItem) {
        if (player.getHolding() == null && player.getLocation() == null) {
            outputBoundary.displayMessage("You have nothing in your hand or standing beside anything to interact with.");
            return;
        }

        if (player.getHolding() != null && player.getHolding().getName().equals(whatItem)) {
            outputBoundary.displayMessage("Looking at the " + whatItem + ", you decide to take a bite.");
            outputBoundary.displayMessage("This is a bad decision.");
            outputBoundary.displayMessage("You lost " + player.getHolding().getDamage() + " health.");
            player.setHealth(player.getHealth() - player.getHolding().getDamage());
            return;
        }

        if (player.getLocation() != null && player.getLocation().getName().equals(whatItem)) {
            outputBoundary.displayMessage("you are not standing next to anything to interact with");
            return;
        }

        outputBoundary.displayMessage("You are not holding " + whatItem + " or standing next to it.");
    }

    /**
     * Inspects the player's bag and lists the contents.
     */
    @Override
    public void inspectBag() {
        List<Item> items = player.getInventory().getItemsInside();
        if (items.isEmpty()) {
            outputBoundary.displayMessage("Your bag is empty.");
        } else {
            outputBoundary.displayBagContents(items);
        }
    }

    /**
     * Retrieves an item from the player's bag and places it in their hand.
     * @param itemName The name of the item to retrieve from the bag.
     */
    @Override
    public void getFromBag(String itemName) {
        if (player.getHolding() != null) {
            outputBoundary.displayMessage("You are already holding something. Put it in your bag or drop it first.");
            return;
        }
        Item retrievedItem = new InventoryManagementInteractor(player.getInventory(), new InventoryOutputBoundary()).removeItem(itemName);
        if (retrievedItem != null) {
            outputBoundary.displayMessage("You took " + itemName + " out of your bag.");
            player.setHolding(retrievedItem);
        } else {
            outputBoundary.displayMessage("The item " + itemName + " is not in your bag.");
        }
    }

    /**
     * Puts the currently held item into the player's bag.
     */
    @Override
    public void putInBag() {
        if (player.getHolding() == null) {
            outputBoundary.displayMessage("You have nothing to put in the inventory.");
        } else {
            if (player.getInventory().getNumItemsInside() < player.getInventory().getBagSize()) {
                new InventoryManagementInteractor(player.getInventory(), new InventoryOutputBoundary()).addItem(player.getHolding());
                outputBoundary.displayMessage("You put " + player.getHolding().getName() + " in your bag.");
                player.setHolding(null);
            } else {
                outputBoundary.displayMessage("Your inventory is full.");
            }
        }
    }

    /**
     * Interacts with an item in the player's hand and an item at the current location.
     * @param holdingWhat The name of the item the player is holding.
     * @param itemAtLocation The name of the item at the player's location.
     */
    @Override
    public void interact(String holdingWhat, String itemAtLocation) {
        if (player.getHolding() == null) {
            outputBoundary.displayMessage("You have nothing in your hand to interact with.");
            return;
        }

        if (!player.getHolding().getName().equals(holdingWhat)) {
            outputBoundary.displayMessage("You are holding " + player.getHolding().getName() + " instead of " + holdingWhat + ".");
            return;
        }

        if (player.getLocation() == null) {
            outputBoundary.displayMessage("You have nothing to interact with.");
            return;
        }

        if (!player.getLocation().getName().equals(itemAtLocation)) {
            outputBoundary.displayMessage("You are not next to " + itemAtLocation + ".");
            return;
        }

        outputBoundary.displayMessage("You tried to interact " + holdingWhat + " with " + itemAtLocation + ".");
        new ItemInputBoundary(player.getHolding(), new ItemOutputBoundary()).interact(player.getLocation());
        // new ItemInputBoundary(player.getLocation(), new ItemOutputBoundary()).interact(player.getHolding());
    }


    public void interact_spiderweb(){
        outputBoundary.displayMessage("You push open the door through the thick, poisonous spiderweb. The venom in the web seeps " +
                "into your skin, and you feel a sharp pain coursing through your body. Your health decreases by 2.");
        player.setHealth(player.getHealth() - 2);
    }

}

