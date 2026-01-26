package tutorial.multiframe;

import javax.swing.*;

public class MenuManager {

    public static JMenuBar createMenuBar(AudioManager audioManager, String instructionsText) {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("MENU");

     // Instructions popup menu item
        JMenuItem instructionsItem = new JMenuItem("Instructions");
        instructionsItem.addActionListener(e -> {
            JOptionPane.showMessageDialog(
                null,

                instructionsText, // Modifiable per frame
                "Instructions", // Title
                JOptionPane.INFORMATION_MESSAGE
            );
        });
        menu.add(instructionsItem);

        // Audio toggle checkbox
        JCheckBoxMenuItem audioToggle = new JCheckBoxMenuItem("Audio");
        audioToggle.setSelected(true);
        audioToggle.addActionListener(e -> {
            if (audioToggle.isSelected()) {
                audioManager.play();
            } else {
                audioManager.pause();
            }
        });
        menu.add(audioToggle);

        // Volume slider
        JSlider volumeSlider = new JSlider(0, 100, 80);
        volumeSlider.setMaximumSize(new java.awt.Dimension(100, 20));
        volumeSlider.addChangeListener(e -> {
            audioManager.setVolume(volumeSlider.getValue());
        });
        menu.add(volumeSlider);

        menuBar.add(menu);
        return menuBar;
    }
}
