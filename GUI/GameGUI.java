package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Player. Player;


public class GameGUI extends JFrame {
    private Player player;
    private JTextArea gameOutput; // To display system messages
    private JTextField userInput; // To get user input
    private JLabel healthLabel; // Display player's health
    private JLabel damageLabel; // Display player's damage

    public GameGUI(Player player) {
        this.player = player;
        initializeGUI();
    }

    private void initializeGUI() {
        setTitle("Text-Based Adventure Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        // Top Panel: Display player's stats
        JPanel statsPanel = new JPanel();
        statsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        healthLabel = new JLabel("Health: " + player.getHealth());
        damageLabel = new JLabel("Damage: " + player.getDamage());
        statsPanel.add(healthLabel);
        statsPanel.add(damageLabel);
        add(statsPanel, BorderLayout.NORTH);

        // Center Panel: Game Output
        gameOutput = new JTextArea();
        gameOutput.setEditable(false);
        gameOutput.setLineWrap(true);
        gameOutput.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(gameOutput);
        add(scrollPane, BorderLayout.CENTER);

        // Bottom Panel: User Input
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        userInput = new JTextField();
        JButton submitButton = new JButton("Submit");
        inputPanel.add(userInput, BorderLayout.CENTER);
        inputPanel.add(submitButton, BorderLayout.EAST);
        add(inputPanel, BorderLayout.SOUTH);

        // Event Listener for Submit Button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleUserInput(userInput.getText());
                userInput.setText(""); // Clear input field
            }
        });

        setVisible(true);
    }

    // Update stats
    public void updateStats() {
        healthLabel.setText("Health: " + player.getHealth());
        damageLabel.setText("Damage: " + player.getDamage());
    }

    // Display output in the text area
    public void displayOutput(String message) {
        gameOutput.append(message + "\n");
        gameOutput.setCaretPosition(gameOutput.getDocument().getLength());
    }

    // Handle user input
    private void handleUserInput(String input) {
        Controller.handleInput(input, this, player);
    }
}
