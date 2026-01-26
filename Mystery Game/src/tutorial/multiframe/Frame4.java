package tutorial.multiframe;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextArea;

public class Frame4 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	public Frame4() {


		// import menu 
		AudioManager audioManager = ApplicationData.audioManager;
		setJMenuBar(MenuManager.createMenuBar(audioManager, 
				"Instructions:\nChoose who the suspect is. If guessed incorrectly twice in a row,"
						+ "\nyou will be sent back to the interrogation board to collect more intel. "
						+ "\nIf you guess incorrectly the third time, game over, and the true suspect responsible will be shown"));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 761, 582);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(50, 30, 30)); 
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Who was responsible?");
		lblNewLabel.setBounds(210, 70, 146, 22);
		lblNewLabel.setForeground(new Color(255, 255, 255));

		contentPane.add(lblNewLabel);

		JLabel lblDecisionBoard = new JLabel(" Decision Board");
		lblDecisionBoard.setForeground(new Color(255, 255, 255));
		lblDecisionBoard.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblDecisionBoard.setBounds(283, 11, 184, 47);

		contentPane.add(lblDecisionBoard);

		JComboBox comboBox = new JComboBox();
		comboBox.addItem("");
		comboBox.addItem("Maid");
		comboBox.addItem("Butler");
		comboBox.addItem("Gardener");
		comboBox.addItem("Lady Margaret");
		comboBox.setBounds(418, 71, 107, 22);
		contentPane.add(comboBox);

		JButton submitButton = new JButton("Submit Guess");
		submitButton.setBounds(313, 103, 131, 22);
		contentPane.add(submitButton);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(56, 136, 674, 141);
		textArea.setForeground(Color.WHITE); // text color
		textArea.setBorder(BorderFactory.createLineBorder(new Color(255, 205, 59), 3));
		textArea.setBackground(new Color(30, 15, 15));
		contentPane.add(textArea);

		// Image label (initially hidden)
		ImageIcon icon = new ImageIcon(getClass().getResource("Gardener.png"));
		Image scaledImage = icon.getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);

		JLabel imageLabel = new JLabel(scaledIcon);
		imageLabel.setBounds(267, 275, 240, 300);
		contentPane.add(imageLabel);
		imageLabel.setVisible(false);

		JButton backButton = new JButton("← Revise information");
		backButton.setBounds(283, 289, 200, 25);
		// hidden by default
		backButton.setVisible(false); 
		contentPane.add(backButton);

		backButton.addActionListener(e -> {
			submitButton.setVisible(true);  
			backButton.setVisible(false);   
			if (ApplicationData.frame2 == null) {
				ApplicationData.frame2 = new Frame2();
			}
			ApplicationData.frame2.setVisible(true);
			Frame4.this.setVisible(false);
		});


		// Respond to user selection
		submitButton.addActionListener(e -> {
			String selected = (String) comboBox.getSelectedItem();
			String correctSuspect = "Gardener";

			if (selected == null || selected.isEmpty()) {
				textArea.setText("Please select a suspect.");
				return;
			}

			if (selected.equals(correctSuspect)) {
				textArea.setText(
						"Correct! Well done. The culprit was: " + correctSuspect + "\n\n" +
								"The gardener stealthily squeezed a drop of the poisonous flower (Belladonna), " +
								"ensuring her demise "
								+ "\nwithout raising immediate suspicion.\n" +
								"He had long coveted her step-daughter, yearning for a life together that was forbidden" +
								"by the strict "
								+ "\ninheritance clauses of the estate.\n" +
								"Driven by uncontrolled ambition and forbidden desire, "
								+ "\nhe eliminated her to clear the path " +
								"toward a future with the one he truly loved."
						);
				submitButton.setVisible(false);
				imageLabel.setVisible(true);
			} else {
				ApplicationData.incorrectGuesses++;
				if (ApplicationData.incorrectGuesses == 1) {
					textArea.setText("Incorrect. Reevaluate your decision.");
				} else if (ApplicationData.incorrectGuesses == 2) {
					textArea.setText(
							"Incorrect. Reevaluate your decision. One attempt left.\n" +
									"You may choose to revise evidence and interrogate suspects."
							);
					backButton.setVisible(true);
					submitButton.setVisible(false);
				} else if (ApplicationData.incorrectGuesses == 3) {
					textArea.setText(
							"You Failed. The real suspect was: " + correctSuspect + "\n\n" +
									"The gardener stealthily squeezed a drop of the poisonous flower (Belladonna), " +
									"ensuring her demise "
									+ "\nwithout raising immediate suspicion.\n" +
									"He had long coveted her step-daughter, yearning for a life together that was forbidden" +
									"by the strict "
									+ "\ninheritance clauses of the estate.\n" +
									"Driven by uncontrolled ambition and forbidden desire, "
									+ "\nhe eliminated her to clear the path " +
									"toward a future with the one he truly loved."
							);
					submitButton.setVisible(false);
					imageLabel.setVisible(true);
				}
			}
		});
	}
}
