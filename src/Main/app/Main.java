package src.Main.app;


import src.Main.app.AppBuilder;

public class Main {
    public static void main(String[] args) {
        src.Main.app.AppBuilder appBuilder = new AppBuilder();

        // Use the builder to initialize and start the game
        appBuilder

                .startGame()
//
//                .addTrainingRoom()
                .addTrainingForest()
                .lastHorizonValley()
                .setupPlayerAndGUI()
                .run();
    }
}
