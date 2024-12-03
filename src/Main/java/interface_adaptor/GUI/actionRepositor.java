package interface_adaptor.GUI;

import User_case.PlayerUsercase.PlayerInputBoundary;

import java.util.HashSet;
import java.util.Set;

public class actionRepositor {

    // Store valid actions as an instance variable
    private static Set<String> validActions = Set.of();
    private final PlayerInputBoundary playerInputBoundary;

    public actionRepositor(PlayerInputBoundary playerInputBoundary) {
        this.playerInputBoundary = playerInputBoundary;
        validActions = new HashSet<>();
        //validActions.add("walkto");
        validActions.add("walk to the mailbox");
        //validActions.add("pickup");
        validActions.add("pick up key");
        validActions.add("speech");
        validActions.add("exit");
        validActions.add("drop");
        //validActions.add("putinbag");
        validActions.add("put it in bag");
        validActions.add("getfrombag");
        validActions.add("inspectbag");
        validActions.add("interact");
        validActions.add("exist");
        validActions.add("open");
        validActions.add("key");
        validActions.add("sword");
        validActions.add("torch");
        validActions.add("dragon fang sword");
        validActions.add("use the key in your hand");
        validActions.add("walk to the spiderweb");
        validActions.add("walk to the old man");
        validActions.add("interact the old man");
        validActions.add("walk to wand of water");
        validActions.add("attack it with your sword");
        validActions.add("clean the spiderweb");
        validActions.add("pick up key");
        validActions.add("use key to open the door");
    }

    // Instance method to return all valid actions
    public static Set<String> getValidActions() {
        return validActions;
    }

    // Instance method to handle each valid action and return a corresponding string
    public void handleAction(String action) {
        String in = action.toLowerCase();
        switch (in) {
            // case "walk to":
                // playerInputBoundary.walkTo(in);
                // break;
            case "interact the old man":
                break;

            case "walk to the mailbox":
                playerInputBoundary.walkTo("key");
                break;
            case "walk to the spiderweb":
                playerInputBoundary.walkTo("exit");
                break;
            //case "pickup":
                //playerInputBoundary.pickUp(in);
                //break;
            case "walk to the old man":
                playerInputBoundary.walkTo("NPC");
                break;
            case "walk to wand of water":
                playerInputBoundary.walkTo("Equipment");
                break;
            case "speech":
                break;
            case "exit":
                break;
            //case "putinbag":
               // playerInputBoundary.putInBag();
                //break;
            case "put it in bag":
                playerInputBoundary.putInBag();
                break;
            case "pick up key":
                playerInputBoundary.pickUp("key");
                break;
            case "getfrombag":
                playerInputBoundary.getFromBag(in);
                break;
            case "inspectbag":
                playerInputBoundary.inspectBag();
                break;
            case "use the key to open the door":
                playerInputBoundary.interact("key", "exit");
                break;
            case "dragon fang sword":
                playerInputBoundary.getFromBag(in);
                break;
            case "clean the spiderweb":
                playerInputBoundary.interact("key", "exit");
                break;
            case "attack it with your sword":
                break;
            case "use the key in your hand":
                playerInputBoundary.interact("key", "exit");
                playerInputBoundary.interact_spiderweb(); // Deduct 2 health points
                break;
            case "use key to open the door":
                playerInputBoundary.interact("key", "exit");
                break;
            case "key":
                break;
            case "sword":
                break;
            case "torch":
                break;
            default:
                break;
        }
    }
}
