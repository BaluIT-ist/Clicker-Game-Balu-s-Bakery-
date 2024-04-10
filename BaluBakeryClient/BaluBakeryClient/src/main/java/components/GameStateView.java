package components;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Arrays;

@SuppressWarnings("serial")
public class GameStateView extends JPanel {

    private int score = 0; // Counter for the score
    private JLabel scoreLabel; // JLabel to display the score

    public GameStateView() {
        super(new BorderLayout());
        this.setPreferredSize(new Dimension(400, 450));
        this.setBackground(new Color(89, 120, 51)); // Calmer and colder cyan color

        // Create a panel for the score
        JPanel scorePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        scorePanel.setBackground(new Color(89, 120, 51)); // Match the background color of the main panel
        scoreLabel = new JLabel("Score: " + score);
        scoreLabel.setForeground(Color.WHITE);
        scorePanel.add(scoreLabel);

        // Add the score panel to the top left corner
        add(scorePanel, BorderLayout.NORTH);

        // Create a panel for the button
        JPanel panelBakeButton = new JPanel(new BorderLayout());
        panelBakeButton.setBackground(new Color(0, 0, 0, 0));
        panelBakeButton.add(createBakingButton(), BorderLayout.CENTER); // Add button to center
        add(panelBakeButton, BorderLayout.CENTER); // Add button panel to the center
    }

    private JButton createBakingButton() {
        try {
            Image image = ImageIO.read(new File("src/main/resources/Cakes/Cookie.png"));

            JButton bakingButton = new JButton(new ImageIcon(image));
            bakingButton.addActionListener(this::bakeAction);
            bakingButton.setBackground(new Color(0, 0, 0, 0)); // Transparent background

            return bakingButton;

        } catch (Exception e) {
            System.out.println("Error: " + Arrays.toString(e.getStackTrace()));
        }

        return null;
    }

    private void bakeAction(ActionEvent a) {
        score++; // Increment the score
        scoreLabel.setText("Score: " + score); // Update the score label
        System.out.println("You just baked a cookie!");
    }
}
