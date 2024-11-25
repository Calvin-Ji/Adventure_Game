package GUI;

import Player. Player;

public class Controller {
    public static void handleInput(String input, GameGUI gui, Player player) {
        switch (input.toLowerCase()) {
            case "attack":
                gui.displayOutput("You attacked the enemy!");
                break;
            case "heal":
                player.setHealth(player.getHealth() + 5);
                gui.displayOutput("You healed yourself! Current health: " + player.getHealth());
                break;
            default:
                gui.displayOutput("Unknown command: " + input);
        }
        gui.updateStats(); // Update the player's stats on the GUI
    }
}