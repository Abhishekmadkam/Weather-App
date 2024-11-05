
import javax.swing.*;
import java.awt.*;

public class BackgroundImageExample {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create a JFrame
            JFrame frame = new JFrame("Background Image Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(230, 320);

            // Set layout to BorderLayout to cover the whole frame
            frame.setLayout(new BorderLayout());

            // Create a JPanel with the background image
            JPanel backgroundPanel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    ImageIcon imageIcon = new ImageIcon("src/assets/taylor-van-riper-yQorCngxzwI-unsplash.jpg");
                    Image image = imageIcon.getImage();
                    g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
                }
            };

            // Set layout to null to allow placing components freely
            backgroundPanel.setLayout(null);




            // Add the background panel to the content pane of the JFrame
            frame.add(backgroundPanel);

            // Center the frame
            frame.setLocationRelativeTo(null);

            // Make the frame visible
            frame.setVisible(true);
        });
    }
}