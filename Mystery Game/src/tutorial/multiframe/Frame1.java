package tutorial.multiframe;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Frame1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
	        		ApplicationData.frame1 = new Frame1();
					ApplicationData.frame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frame1() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 761, 582);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(118, 0, 2)); 
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	    if (ApplicationData.audioManager == null) {
	        ApplicationData.audioManager = new AudioManager("audio.wav");
	    }
	 // Load the original image (make sure "Front.png" is in the correct location)
	    ImageIcon originalIcon = new ImageIcon(getClass().getResource("Front.png"));

	    // Scale the image to exactly 761 x 582 pixels
	    Image originalImage = originalIcon.getImage();
	    Image scaledImage = originalImage.getScaledInstance(761, 582, Image.SCALE_SMOOTH);
	    ImageIcon scaledIcon = new ImageIcon(scaledImage);

	    // Create a JLabel with the scaled image and set its bounds to fill the content pane
	    JLabel backgroundLabel = new JLabel(scaledIcon);
	    backgroundLabel.setBounds(0, 0, 761, 582);

	    // Add the background label first to ensure it stays in the background
	    contentPane.add(backgroundLabel);

		
		
		JLabel lblNewLabel = new JLabel("Murder on Estate Belladonna ");
		lblNewLabel.setEnabled(false);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 39));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBackground(new Color(255, 205, 59));
		lblNewLabel.setBounds(94, 6, 573, 111);
		contentPane.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea(
			    " Detective, you have been called in to solve the murder of Mistress Eleanore from the Estate Belladonna.The mistress had recently inherited the estate after the mysterious passing of her husband.The cause of death seems to be poison laced in her tea. At the time of death, the individuals present in the estate were her step-daughter, maid, butler, and gardener.You must solve this murder and bring justice to Estate Belladonna..."
			    
			);
		textArea.setBackground(new Color(255, 212, 53));
			textArea.setWrapStyleWord(true);
			textArea.setLineWrap(true);
			textArea.setEditable(false);
			textArea.setOpaque(false);
			textArea.setForeground(Color.WHITE);
			textArea.setFont(new Font("Times New Roman", Font.PLAIN, 16));

			
			JScrollPane scrollPane = new JScrollPane(textArea);
			scrollPane.setBounds(135, 142, 547, 200); 
			scrollPane.setBorder(null); 
			scrollPane.setOpaque(false);
			scrollPane.getViewport().setOpaque(false);

			contentPane.add(scrollPane);
		
		JButton btnNewButton = new JButton("Continue..");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if ((ApplicationData.frame2 == null)) {
        		ApplicationData.frame2 = new Frame2();
        		}
        		ApplicationData.frame2.setVisible(true);
        		ApplicationData.frame1.setVisible(false);
        	}
        });

		btnNewButton.setBounds(312, 436, 160, 40);
		contentPane.add(btnNewButton);  
	    contentPane.setComponentZOrder(backgroundLabel, contentPane.getComponentCount() - 1);

		
	}
}
