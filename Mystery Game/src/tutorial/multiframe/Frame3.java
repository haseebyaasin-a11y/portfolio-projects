package tutorial.multiframe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Image;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Frame3 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    private String[] diaryEntries = {
        "Day 1:\nToday the estate had an eerie silence to it. The maid was cleaning meticulosley as usual, and the gardener was cutting the shrubs. Margaret gave me a smile that couldnt hide her discontent...",
        "Day 2:\nAn unusual delivery arrived today, an exotic deep purple flower that intrigued me.The gardener was fixated on planting them in the garden while the butler watched as if he knew a secret not meant for my ears ",
        "Day 3:\nAt dinner I sensed tension between me and the butler.Perhaps resentment towards me for not choosing his poor brother over the estate owner .",
        "Day 4:\n late night today while wandering the corridors I caught the butler in the library pouring over some books on exotic flowers. What a strange man",
        "Day 5:\nI cant shake the impression everybody in this mansion is hiding something.The butler with sorrowful memories of his little brother, the maid always cleaning after the l death, and Margaret seems to have developed a hobby for gardening"
    };
    private int currentDiaryIndex = 0; 


    public Frame3() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 761, 582);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(50, 30, 30)); 
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        AudioManager audioManager = ApplicationData.audioManager;
        setJMenuBar(MenuManager.createMenuBar(audioManager,
            "Instructions:\nInspect the pictures and other evidence for clues..."));
        String inheritanceClauses =
        	    "Estate Inheritance Clauses:\n\n" +
        	    
        	    "1. Sole Beneficiary Designation Clause:\n" +
        	    "   Upon the decease of the estate holder, the entirety of Estate Belladonna shall pass solely to a recognized member " +
        	    "of the family who upholds our noble traditions.\n\n" +
        	    
        	    "2. Lineage and Preservation Clause:\n" +
        	    "   All beneficiaries must preserve the dignity and social standing of the Belladonna name. Any conduct " +
        	    "that diminishes the honor of the family shall be cause for disinheritance.\n\n" +
        	    
        	    "3. Social Status Restriction Clause (For the Daughter):\n" +
        	    "   Should the designated daughter form a matrimonial or intimate union with someone of inferior social rank " +
        	    "(for example, a gardener or any other person of lowly birth), her claim to the estate shall be rendered null " +
        	    "and void immediately.\n\n" +
        	    
        	    "4. Servant Conduct and Integrity Clause (For Other Suspects):\n" +
        	    "   Any member of the servant staff—including the butler, maid, or gardener—found guilty of betrayal, " +
        	    "collusion, or other egregious acts that undermine the estate's honor shall forfeit any associated benefits, " +
        	    "with assets redistributed among remaining qualified heirs.\n\n" +
        	    
        	    "5. Marital Alliance and Approval Clause:\n" +
        	    "   Any matrimonial union involving heirs must receive explicit pre-approval from the estate's executors. " +
        	    "Failure to secure such approval will immediately result in disinheritance.\n\n" +
        	    
        	    "6. Revocation for Felonious Conduct Clause:\n" +
        	    "   Should a beneficiary—including any potential claimant among the staff—be implicated in or convicted of " +
        	    "criminal activities that tarnish the estate's reputation, their right to inheritance shall be permanently revoked.";

        
        // Create a new button for viewing the clauses
        JButton btnViewClauses = new JButton("View Inheritance Clauses");
        btnViewClauses.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        btnViewClauses.setBounds(181, 405, 200, 29); 
        contentPane.add(btnViewClauses);

        // Add a simple action listener using a basic dialog (no parent specified, default message type)
        btnViewClauses.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, inheritanceClauses);
            }
        });


        JLabel lblNewLabel = new JLabel("Evidence Board");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setBounds(298, 11, 177, 47);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
        contentPane.add(lblNewLabel);
        
        // Load and scale the diary image for display (not the thumbnail view)
        ImageIcon diaryIcon = new ImageIcon(getClass().getResource("/tutorial/multiframe/Diary.png"));
        Image diaryScaledImage = diaryIcon.getImage().getScaledInstance(117, 50, Image.SCALE_SMOOTH);
        ImageIcon diaryScaledIcon = new ImageIcon(diaryScaledImage);

        // Create a JLabel to hold the diary image
        JLabel diaryImageLabel = new JLabel(diaryScaledIcon);

        
        diaryImageLabel.setBounds(421, 343, 117, 50);

        // Add the diary image label to the content pane
        contentPane.add(diaryImageLabel);
        
        ImageIcon scrollIcon = new ImageIcon(getClass().getResource("/tutorial/multiframe/Scroll.png"));
        Image scrollScaledImage = scrollIcon.getImage().getScaledInstance(117, 50, Image.SCALE_SMOOTH);
        ImageIcon scrollScaledIcon = new ImageIcon(scrollScaledImage);

        // Create a JLabel to hold the diary image
        JLabel scrollImageLabel = new JLabel(scrollScaledIcon);

        scrollImageLabel.setBounds(218, 303, 105, 90);

        // Add the diary image label to the content pane
        contentPane.add(scrollImageLabel);


        JButton btnContinue = new JButton("Continue");
        btnContinue.setBounds(599, 468, 117, 29);
        contentPane.add(btnContinue);

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(37, 468, 117, 29);
        contentPane.add(btnBack);
       
        JButton btnOpenDiary = new JButton("Open Diary...");
        btnOpenDiary.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        btnOpenDiary.setBounds(410, 406, 144, 29);
        contentPane.add(btnOpenDiary);

        // Create a panel with a horizontal BoxLayout for the thumbnails.
        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new BoxLayout(imagePanel, BoxLayout.X_AXIS));
        imagePanel.setBackground(Color.white);
        imagePanel.setBorder(BorderFactory.createLineBorder(new Color(255, 205, 59), 3));
        imagePanel.setBackground(new Color(30, 15, 15));
       
        String[] imageFiles = { "CS1.png" , "CS2.png" , "CS3.png" ,"CS4.png" };

        for (int i = 0; i < imageFiles.length; i++) {
            String file = imageFiles[i]; // Get the current filename

            ImageIcon thumbIcon = new ImageIcon(getClass().getResource("/tutorial/multiframe/" + file));
            Image scaledThumb = thumbIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            ImageIcon scaledThumbIcon = new ImageIcon(scaledThumb);
            JLabel thumbnailLabel = new JLabel(scaledThumbIcon);
            thumbnailLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            thumbnailLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    showExpandedImage(file);
                }
            });
            imagePanel.add(thumbnailLabel);
        }

        JScrollPane scrollPane = new JScrollPane(imagePanel);
        scrollPane.setBounds(50, 100, 660, 150);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        contentPane.add(scrollPane);
       
       

        btnContinue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (ApplicationData.frame4 == null) {
                    ApplicationData.frame4 = new Frame4();
                }
                ApplicationData.frame4.setVisible(true);
                ApplicationData.frame3.setVisible(false);
            }
        });

        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ApplicationData.frame2.setVisible(true);
                ApplicationData.frame3.setVisible(false);
            }
        });

        btnOpenDiary.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openDialogWindow();
            }
        });
    }

    /**
     * Displays the full-size image in a dialog window.
     * @param filename The image file name (assumed to be in the package).
     */
    private void showExpandedImage(String filename) {
        // Load the original image
        ImageIcon icon = new ImageIcon(getClass().getResource("/tutorial/multiframe/" + filename));

        // Scale the image to a fixed size (300 x 300 pixels)
        Image scaledImage = icon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        // Create and configure a dialog to display the scaled image
        JDialog dialog = new JDialog(this, "Image Detail", true);
        JLabel imageLabel = new JLabel(scaledIcon);
        dialog.getContentPane().add(imageLabel);
        
        // Pack the dialog so it fits the image size and display it
        dialog.pack();
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    /**
     * Opens a dialog window for the diary with navigation buttons.
     */
    private void openDialogWindow() {
        JDialog dialog = new JDialog(this, "My Diary", true);
        dialog.setSize(300, 200);
        dialog.setLocationRelativeTo(this);
        dialog.getContentPane().setLayout(new BorderLayout());

        JLabel diaryTitleLabel = new JLabel("Diary Entry " + (currentDiaryIndex + 1), SwingConstants.CENTER);
        diaryTitleLabel.setFont(new Font("Serif", Font.BOLD, 18));
        dialog.getContentPane().add(diaryTitleLabel, BorderLayout.NORTH);

        JTextArea diaryTextArea = new JTextArea(diaryEntries[currentDiaryIndex]);
        diaryTextArea.setEditable(false);
        diaryTextArea.setLineWrap(true);
        diaryTextArea.setWrapStyleWord(true);
        diaryTextArea.setFont(new Font("Serif", Font.PLAIN, 16));
        dialog.getContentPane().add(new JScrollPane(diaryTextArea), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton prevButton = new JButton("Previous");
        JButton nextButton = new JButton("Next");
        JButton closeButton = new JButton("Close");
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);
        buttonPanel.add(closeButton);
        dialog.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        prevButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currentDiaryIndex > 0) {
                    currentDiaryIndex--;
                    updateDiary(diaryTitleLabel, diaryTextArea);
                }
            }
        });
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currentDiaryIndex < diaryEntries.length - 1) {
                    currentDiaryIndex++;
                    updateDiary(diaryTitleLabel, diaryTextArea);
                }
            }
        });
        closeButton.addActionListener(e -> dialog.dispose());

        dialog.setVisible(true);
    }

    private void updateDiary(JLabel titleLabel, JTextArea textArea) {
        titleLabel.setText("Diary Entry " + (currentDiaryIndex + 1));
        textArea.setText(diaryEntries[currentDiaryIndex]);
    }

   
}