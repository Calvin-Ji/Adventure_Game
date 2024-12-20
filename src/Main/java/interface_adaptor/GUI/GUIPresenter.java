package interface_adaptor.GUI;

import User_case.GUI.GUIOutputBoundry;

public class GUIPresenter implements GUIOutputBoundry {
    private final GameGUI gameGUI;

    public GUIPresenter(GameGUI gameGUI) {
        this.gameGUI = gameGUI;
    }

    @Override
    public void displayResult(String message) {
        gameGUI.displayResult(message);
        gameGUI.updateStats(); // Update stats if necessary
    }
}
