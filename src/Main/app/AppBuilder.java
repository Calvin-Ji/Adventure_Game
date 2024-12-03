package app;

import Entity.*;
import Entity.TicTacToe.TicTacToeBoard;

import Frameworks_and_drivers.guiUtility;

import Frameworks_and_drivers.Tictactoe.TicTacToeCLIView;
import Frameworks_and_drivers.Tictactoe.TicTacToeView;
import Entity.NPC;
import User_case.GUI.GUIActionPresenter;
import User_case.GUI.GUIController;
import User_case.InventoryUseCase.InventoryManagementInteractor;
import User_case.InventoryUseCase.InventoryOutputBoundary;
import User_case.PlayerUsercase.PlayerInputBoundary;
import User_case.PlayerUsercase.PlayerOutBoundary;
import User_case.TicTacToe.BotMoveUseCase;
import User_case.TicTacToe.PlayerMoveUseCase;
import interface_adaptor.GUI.actionRepositor;
import interface_adaptor.GUI.GameGUI;
import interface_adaptor.GUI.GUIPresenter;
import User_case.GameLevelsUserCase.LevelInteractor;
import User_case.RoomUserCase.RoomInteraction;
import interface_adaptor.Tictactoe.TicTacToeController;
import interface_adaptor.Tictactoe.TicTacToePresenter;

import java.util.Scanner;

public class AppBuilder {

    private GameLevelList dungen;
    private Player player;
    private GameGUI gameGUI;
    private GUIPresenter presenter;
    //private UserActionInteractor interactor;

    public AppBuilder() {
        // Initialize core components
        dungen = new GameLevelList();
    }

    /**
     * Adds the training room level to the application.
     *
     * @return this builder
     */
    public AppBuilder addTrainingRoom() {
        // initailize

        Key key = new Key("key", "There is a key in the mail_box!", "a key lies on the floor", 1, "regular");
        Exit exit = new Exit("exit", "The exit is covered by a thick spider web", "There is a heavy gate in " +
                "front of you.","regular");
        Equipment sword = new Equipment("dragon fang sword",
                "A weapon bestowed upon warriors chosen by the Dragon Clan. It holds the power of the dragon!",
                "A sword is stuck on the wall", 4, null);


        Room room1 = new Room("This is the training room for beginners!");
        RoomInteraction roomInteractor = new RoomInteraction(room1);
        roomInteractor.addItem(key);
        roomInteractor.addItem(sword);
        roomInteractor.addItem(exit);

        LevelInteractor levelInteractor = new LevelInteractor(dungen);
        levelInteractor.addLevel(room1);
        Room startingRoom = dungen.getLevels().get(0);

        this.player = new Player(5,15,2,startingRoom);
        Inventory inventory = this.player.getInventory();
        InventoryOutputBoundary inventoryOutputBoundary = new InventoryOutputBoundary();
        InventoryManagementInteractor InventoryManagementInteractor = new InventoryManagementInteractor(inventory, inventoryOutputBoundary);
        InventoryManagementInteractor.addItem(sword);

        // Player player = new Player(5,15,2,startingRoom); // Assume Player is properly initialized
        PlayerOutBoundary outputBoundary = new PlayerOutBoundary();
        PlayerInputBoundary inputBoundary = new PlayerInputBoundary(player, outputBoundary);
        actionRepositor actionRepository = new actionRepositor(inputBoundary);
        //room start
        Frameworks_and_drivers.guiUtility guiUtility = new Frameworks_and_drivers.guiUtility();
        guiUtility.displayOutput("As a gift for beginner, we decide to give you a Flame Dragon Bow to you!");
        String action1 = guiUtility.getValidInput("Try to inspect your bag by entering 'inspectbag' to inspect" +
                " the bag!", actionRepositor.getValidActions());
        actionRepository.handleAction(action1);
        // Step 1: Get user input for each action
        String action2 = guiUtility.getValidInput("Try getting your sword from your bag by entering 'dragon " +
                "fang sword'", actionRepositor.getValidActions());
        actionRepository.handleAction(action2);
        String action3 = guiUtility.getValidInput("There are too many things in your hands, try putting what " +
                "you are holding in your bag by entering 'put it in bag'.", actionRepositor.getValidActions());
        actionRepository.handleAction(action3);
        String action4 = guiUtility.getValidInput("There is a mail-box in the center of the room and there is a key in it. Enter 'walk to the mailbox' to move towards the mail-box", actionRepositor.getValidActions());
        actionRepository.handleAction(action4);
        String action5 = guiUtility.getValidInput("Enter 'pick up key' to grab the key", actionRepositor.getValidActions());
        actionRepository.handleAction(action5);
        String action6 = guiUtility.getValidInput("Look ahead! It seems to be a door, but it's completely shrouded in a massive spiderweb that glistens ominously in the dim light. Try to walk to there by entering walk to the spiderweb", actionRepositor.getValidActions());
        actionRepository.handleAction(action6);

        String action7 = guiUtility.getValidInput( "You feel an eerie chill as you step closer. Now, you have" +
                " three choices:\n\n"
                + "1. clean the spiderweb – Carefully remove the sticky threads, hoping to uncover what lies beneath.\n"
                + "2. attack it with your sword – Strike the web with all your might, ready for whatever might emerge.\n"
                + "3. use the key in your hand – Perhaps this key is meant for the door hidden beyond the web.\n\n"
                + "What will you do?", actionRepositor.getValidActions());

        if ("clean the spiderweb".equals(action7)) {
            String action8 = guiUtility.getValidInput("Try opening the door by entering 'use key to open the door'", actionRepositor.getValidActions());
            actionRepository.handleAction(action8);
        } else if ("attack it with your sword".equals(action7)) {
            guiUtility.displayOutput("You swing your sword with determination, slicing through the thick webbing. The web starts to break apart, but the force of your attack leaves your sword slightly dull. The way forward is now open. But the door is still locked");
            String action9 = guiUtility.getValidInput("Try opening the door by entering 'use key to open the door'", actionRepositor.getValidActions());
            actionRepository.handleAction(action9);
        }

        actionRepository.handleAction(action7);

        return this;
    }

    /**
     * Adds the training forest level to the application.
     *
     * @return this builder
     */
    public AppBuilder addTrainingForest() {
        Enemy GhostRider = new Fire("Ghost Rider",
                "An ancient soul guardian. He ravages the mortal realm with blazing fire.");
        Equipment FlameDragonBow = new Equipment("Flame Dragon Bow","A legendary weapon bestowed by the Flame Dragon " +
                "itself, each bow is engulfed in roaring flames. When fired, it burns as fiercely as the dragon's " +
                "breath.","on the floor",3,"fire");
        NPC Oldman = new NPC("NPC","An elderly scavenger","by the side of the forest",
                "One man’s scrap is another’s treasure. What will your story leave behind, traveler?");
        Equipment wandofwater = new Equipment("Equipment","A crystal wand etched with glowing " +
                "blue runes, it channels the tranquil yet powerful essence of water, controlling tides and unleashing " +
                "elemental waves.","on the grass",4,"water");
        Grass Clover = new Grass ("Clover","is a sly manipulator who thrives on deception, using charm " +
                "and lies to exploit others for personal gain. Marked by a twisted four-leaf clover, they leave " +
                "betrayal and chaos wherever they go.");
        NPC forest_exit = new NPC ("forest_exit", "", "", "");


        Room room2 = new Room("This is the training forest for beginners!.");



//        RoomInteraction roomInteractor = new RoomInteraction(room2);
//        roomInteractor.addItem(Oldman);
//        roomInteractor.addBattle(Oldman, GhostRider);
//        roomInteractor.addItem(wandofwater);
//        roomInteractor.addBattle(wandofwater, Clover);
//        roomInteractor.addItem(forest_exit);


        LevelInteractor levelInteractor = new LevelInteractor(dungen);
        levelInteractor.addLevel(room2);
        levelInteractor.addPlayer(player);

        Room trainningroom = dungen.getLevels().get(1);

        player.setCurrRoom(trainningroom);


        PlayerOutBoundary outputBoundary = new PlayerOutBoundary();
        PlayerInputBoundary inputBoundary = new PlayerInputBoundary(player, outputBoundary);
        actionRepositor actionRepository = new actionRepositor(inputBoundary);

        //room start
        Frameworks_and_drivers.guiUtility guiUtility = new Frameworks_and_drivers.guiUtility();
        guiUtility.displayOutput("now, you are already get familiar with the actions that you can make. Let’s go to the" +
                " training valley to practice your battle skills!\n");
        String action1 = guiUtility.getValidInput("Entering the forest, you see an old man not far away. You " +
                "prepare to ask him for directions (type 'walktooldman' to talk to the old man). ",
                actionRepositor.getValidActions());

        actionRepository.handleAction(action1);
        guiUtility.displayOutput("There is a monster in front of you! You must fight!");
        guiUtility.displayOutput(GhostRider.getName());
        guiUtility.displayOutput("An ancient soul guardian. He ravages the mortal realm with blazing fire.");
        guiUtility.displayOutput("Ghost rider use the attack to attack you 4 damage!");
        guiUtility.displayOutput("Now you use the correct equipment: dragon fang sword, the only equipment you can use inside your bag");
        guiUtility.displayOutput("You attack the enemy 6 health. Ghost rider: health :9");
        guiUtility.displayOutput("The enemy choose to defence. It will help him protect 3 damage of attack!");
        guiUtility.displayOutput("Now the Fire element enemy Ghost Rider's health has dropped below 5! The special ability of the enemy will start");
        guiUtility.displayOutput("Ghost Rider attack you 7 damage because the special ability of him can make him have critical Strike!");
        guiUtility.displayOutput("Your health is 4 now. Give the enemy the last hit to make success!!");
        guiUtility.displayOutput("You attack the enemy 6 health. The ghost Rider die!");
        guiUtility.displayOutput("Congrats!!!! You successfully bit the fire enemy!");
        guiUtility.displayOutput("This is the gift for your success!");
        guiUtility.displayOutput(FlameDragonBow.getDescription());


        // trigger battle skip
        String action2 = guiUtility.getValidInput("After a hard-fought victory, you catch your breath and look" +
                " at the old man.(type 'interact the old man' to talk to the old man)", actionRepositor.getValidActions());
        actionRepository.handleAction(action2);
        guiUtility.displayOutput(Oldman.getSpeech());
        guiUtility.displayOutput(Oldman.getRiddle());
        guiUtility.displayOutput("Do you have the answer now? Here is your answer");
        guiUtility.displayOutput(Oldman.getAnswer());
        // API skip
        guiUtility.displayOutput("After solving it, you feel a strange sensation and decide to move forward.");

        String action3 = guiUtility.getValidInput("In the distance, you see a glimmer of light. As you get " +
                "closer, you discover it's a Wand of Water. Quickly, type 'walk to wand of water' to take a " +
                "closer look!", actionRepositor.getValidActions());
        guiUtility.displayOutput("There is an enemy in front of you! You must fight!");
        guiUtility.displayOutput(Clover.getName());
        guiUtility.displayOutput("is a sly manipulator who thrives on deception, using charm and lies to exploit others for personal gain. Marked by a twisted four-leaf clover, they leave betrayal and chaos wherever they go.");
        guiUtility.displayOutput("Clover use the attack to attack you 4 damage!");
        guiUtility.displayOutput("Now you use the correct equipment: FlameDragonBow, the equipment you just get");
        guiUtility.displayOutput("You attack the enemy 4 health. Clover: health :11");
        guiUtility.displayOutput("The enemy choose to attack. It attacks 6 damage!");
        guiUtility.displayOutput("Now the Grass element enemy health has dropped below 5! The special ability of the enemy will start");
        guiUtility.displayOutput("Ghost Rider attack you 4 damage but the health of him become 8, because the special ability of him can make him healing!");
        guiUtility.displayOutput("Your health is 7 now. Give the enemy the last hit to make success!!");
        guiUtility.displayOutput("You attack the enemy 6 health.");
        guiUtility.displayOutput("The enemy attacks you 4 health.");
        guiUtility.displayOutput("You attack the enemy 6 health. The enemy die!");
        guiUtility.displayOutput("Congrats!!!! You successfully bit the grass enemy!");
        guiUtility.displayOutput("This is the gift for your success!");
        guiUtility.displayOutput(FlameDragonBow.getDescription());
        actionRepository.handleAction(action3);

        //triger battle
        guiUtility.displayOutput("You rid the land of evil, deeply moving the Spirit of the Forest. In gratitude, it " +
                "decides to grant you an additional 10 health points to help you face the final trial. Health +10");
        guiUtility.displayOutput("You finally made it!! you already have the magic ring with you!!");
        int health = player.getHealth() + 10;
        player.setHealth(health);
        return this;
    }

    /**
     * Adds the training forest level to the application.
     *
     * @return this builder
     */
    public AppBuilder lastHorizonValley() {
        ticTacToeRule();
        startTicTacToeGame();
        Equipment ElfStaff = new Equipment("Elf Staff","A treasured artifact of the Elf Tribe, it " +
                "wields the power to " + "command all flora in the world and unleashes immense vitality.",
                "on the floor",5,"grass");
        NPC Hobbit = new NPC("Hobbit","a small, humble creature of remarkable resilience and courage," +
                " known for their love of peace, good food, and quiet life, yet capable of great heroism and " +
                "resourcefulness when called to adventure.","on the street","Even the smallest of us " +
                "can carry the heaviest burdens, for it’s not strength that defines a hero, but the courage to take " +
                "the first step");
        Water FrostWyrm = new Water ("Frost Wyrm", "Possesses immense power to control aquatic " +
                "creatures, and has long terrorized these waters, harming many innocent fishermen as well as brave" +
                " warriors seeking the magic ring.");
        Key magic_ring = new Key ("Magic Ring", "forged in the Elemental Nexus, radiates a shifting " +
                "glow of fiery red, verdant green, and oceanic blue, granting its bearer immense power to balance " +
                "the forces of nature.","on the floor",2,"regular");

        Room room3 = new Room("Now let’s go to the final adventure to the last horizon valley to chase your " +
                "magic ring!");
        RoomInteraction roomInteractor = new RoomInteraction(room3);
        roomInteractor.addItem(ElfStaff);
        roomInteractor.addItem(Hobbit);
        roomInteractor.addItem(magic_ring);
        roomInteractor.addBattle(magic_ring, FrostWyrm);
        LevelInteractor levelInteractor = new LevelInteractor(dungen);
        levelInteractor.addLevel(room3);

        return this;
    }

    /**
     * Sets up the player and the GUI.
     *
     * @return this builder
     */
    public AppBuilder setupPlayerAndGUI() {
        LevelInteractor levelInteracto = new LevelInteractor(dungen);
        Room startingRoom = dungen.getLevels().get(0);

        this.player = new Player(5,15,2,startingRoom); // Assume Player is properly initialized
        PlayerOutBoundary outputBoundary = new PlayerOutBoundary();
        PlayerInputBoundary inputBoundary = new PlayerInputBoundary(player, outputBoundary);
        actionRepositor actionRepository = new actionRepositor(inputBoundary);
        guiUtility guiUtility = new guiUtility();
        GUIActionPresenter actionPresenter = new GUIActionPresenter(guiUtility);
        GUIController controller = new GUIController(inputBoundary);

        GameGUI gameGUI = new GameGUI(controller);
        gameGUI.setVisible(true);

        return this;
    }

    /**
     * Starts the game by displaying the initial messages.
     *
     * @return this builder
     */
    public AppBuilder startGame() {
        Frameworks_and_drivers.guiUtility guiUtility = new Frameworks_and_drivers.guiUtility();
        guiUtility.displayOutput("Hey, Frodo, you are inside the adventure to chase your magic ring!");
        guiUtility.displayOutput("Now, let's enter a training room to get used to this adventure!");
        return this;
    }

    private void ticTacToeRule(){
        Frameworks_and_drivers.guiUtility guiUtility = new Frameworks_and_drivers.guiUtility();
        guiUtility.displayOutput("Players take turns placing their symbol (X or O) in an empty cell, aiming to align " +
                "three of their symbols in a row, column, or diagonal to win. The game starts with X and alternates " +
                "turns."+'\n'+" Moves must be within the grid and cannot overwrite existing symbols. The game ends " +
                "when a player achieves three in a row or the grid is full. "+'\n'+"If no one wins, the result is a " +
                "draw. Simple yet strategic, it’s a race to outsmart your opponent!");
    }

    public void run() {
        // Game logic starts from here; GUI handles further user inputs
        Frameworks_and_drivers.guiUtility guiUtility = new Frameworks_and_drivers.guiUtility();
        guiUtility.displayOutput("The game is ready. Begin your adventure!");
    }

    private void startTicTacToeGame() {
        // Initialize the Tic Tac Toe game components
        TicTacToeBoard board = new TicTacToeBoard();
        TicTacToeView view = new TicTacToeCLIView();
        TicTacToePresenter presenter = new TicTacToePresenter(view);
        PlayerMoveUseCase useCase = new PlayerMoveUseCase(board, presenter);
        BotMoveUseCase botUseCase = new BotMoveUseCase(board, presenter);
        TicTacToeController controller = new TicTacToeController(useCase, botUseCase);
        Scanner scanner = new Scanner(System.in);

        // Start the Tic Tac Toe game
        Frameworks_and_drivers.guiUtility guiUtility = new Frameworks_and_drivers.guiUtility();
        guiUtility.displayOutput("To exit the game at any time, type '9'. To start, type any other number.");
        int userCommand = scanner.nextInt();

        while (userCommand != 9) {
            view.displayBoard(board.getBoard());
            guiUtility.displayOutput("Player " + board.getCurrentPlayer() + ", enter your move by typing the row then a space then column number. Your options are 0, 1, or 2.");
            String numberStr = guiUtility.getValidInput("Enter the row:",
                    actionRepositor.getValidActions());
            int row = Integer.parseInt(numberStr);
            int col = scanner.nextInt();
            controller.makeMove(row, col);
            if (board.checkWin() != '-' || board.isFull()) {
                break;
            }
            userCommand = row;
        }

        view.displayBoard(board.getBoard());
        char winner = board.checkWin();
        if (winner != '-') {
            view.displayWinner(winner);
        } else {
            view.displayWinner('D'); // Draw
        }
    }
}
