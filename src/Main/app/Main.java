package app;


import app.AppBuilder;

public class Main {
    public static void main(String[] args) {
        app.AppBuilder appBuilder = new AppBuilder();

        // Use the builder to initialize and start the game
        appBuilder
                .startGame()
//
                .addTrainingRoom()
                .addTrainingForest()
                //.lastHorizonValley()
                .setupPlayerAndGUI()
                .run();
    }
}
