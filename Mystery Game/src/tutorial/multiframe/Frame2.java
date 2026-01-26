package tutorial.multiframe;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JToolBar;
import javax.swing.JSlider;
import java.awt.Button;

public class Frame2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public Frame2() {

		//Setting up panel 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 761, 582);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(50, 30, 30)); 
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		AudioManager audioManager = ApplicationData.audioManager;
		setJMenuBar(MenuManager.createMenuBar(audioManager, 
				"Instructions:\n- Interrogate suspects\n- Interrogation intensity may be adjusted to change suspect's answer"));

		//Setting up tabs 
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(6, 19, 749, 437);
		tabbedPane.setBackground(new Color(40, 20, 20)); 
		tabbedPane.setForeground(Color.WHITE); 
		contentPane.add(tabbedPane);

		JSlider slider = new JSlider();
		slider.setValue(0);
		slider.setBounds(287, 487, 224, 39);
		slider.setMajorTickSpacing(25);
		slider.setMinorTickSpacing(5);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setBackground(new Color(80, 40, 40)); 
		slider.setForeground(new Color(255, 205, 59)); 
		contentPane.add(slider);
		// Panel 1 for BUTLER
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Butler", null, panel_1, null);
		tabbedPane.setForegroundAt(0, Color.WHITE);
		panel_1.setBorder(BorderFactory.createLineBorder(new Color(255, 205, 59), 3));
		panel_1.setBackground(new Color(30, 15, 15));
		panel_1.setLayout(null);

		// Load the butler image using a relative path
		ImageIcon icon3 = new ImageIcon(getClass().getResource("Butler.png"));

		// Get the image from the icon
		Image image3 = icon3.getImage();

		// Scale the image to the desired dimensions
		Image scaledImage3 = image3.getScaledInstance(200, 250, Image.SCALE_SMOOTH);

		// Create a new ImageIcon using the scaled image
		ImageIcon scaledIcon3 = new ImageIcon(scaledImage3);

		// Create a JLabel to hold the icon
		JLabel butlerImageLabel = new JLabel(scaledIcon3);

		// Set the bounds for the JLabel 
		butlerImageLabel.setBounds(22, 40, 207, 250);

		// Add the JLabel to the new panel
		panel_1.add(butlerImageLabel);

		JLabel responseLabel1 = new JLabel("...");
		responseLabel1.setVerticalAlignment(SwingConstants.TOP);
		responseLabel1.setBounds(244, 40, 478, 200);
		responseLabel1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		responseLabel1.setForeground(Color.WHITE);
		panel_1.add(responseLabel1);

		JButton btnNewButton_1 = new JButton("Where were you? Alibi?");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnNewButton_1.setBounds(476, 293, 162, 32);
		panel_1.add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("Choose a question...");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(22, 256, 136, 16);
		panel_1.add(lblNewLabel);

		JButton btnNewButton_4 = new JButton("Tell me about your past");
		btnNewButton_4.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton_4.setBounds(452, 252, 172, 29);
		panel_1.add(btnNewButton_4);

		JButton btnNewButton_6 = new JButton("Behaviour of Staff");
		btnNewButton_6.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton_6.setBounds(254, 252, 148, 29);
		panel_1.add(btnNewButton_6);

		JButton btnNewButton_7 = new JButton("How are others on the estate?");
		btnNewButton_7.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton_7.setBounds(264, 293, 195, 32);
		panel_1.add(btnNewButton_7);


		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int intensity = slider.getValue();
				if (intensity <= 25) {
					responseLabel1.setText("<html><body style='width: 360px;'> I was sleeping in my quarters!</body></html>");
				} else if (intensity <= 50) {
					responseLabel1.setText("<html><body style='width: 360px;'> I told you I was sleeping in my quarters</body></html>");
				} else if (intensity <= 75) {
					responseLabel1.setText("<html><body style='width: 360px;'> I was sleeping in my quarters, I didnt kill anybody!</body></html>");
				} else {
					responseLabel1.setText("<html><body style='width: 360px;'> I was sleeping in my quarters!</body></html>");
				}
			}
		});

		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int intensity = slider.getValue();
				if (intensity <= 25) {
					responseLabel1.setText("<html><body style='width: 360px;'> I have worked her for 40 years and seen many estate owners come and go</body></html>");
				} else if (intensity <= 50) {
					responseLabel1.setText("<html><body style='width: 360px;'> I have had painful moments over these 40 years</body></html>");
				} else if (intensity <= 75) {
					responseLabel1.setText("<html><body style='width: 360px;'> I lost my brother while I was working here to gambling and drinking...</body></html>");
				} else {
					responseLabel1.setText("<html><body style='width: 360px;'> I had a brother who had feelings for the mistress however he was rejected by her.He was never the same...</body></html>");
				}
			}
		});
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int intensity = slider.getValue();
				if (intensity <= 25) {
					responseLabel1.setText("<html><body style='width: 360px;'> Everyone was acting strange that day</body></html>");
				} else if (intensity <= 50) {
					responseLabel1.setText("<html><body style='width: 360px;'> I had an eerie feeling that day</body></html>");
				} else if (intensity <= 75) {
					responseLabel1.setText("<html><body style='width: 360px;'> It was a quiet day that day </body></html>");
				} else {
					responseLabel1.setText("<html><body style='width: 360px;'> Everyone was doing their work efficiently</body></html>");
				}
			}
		});
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int intensity = slider.getValue();
				if (intensity <= 25) {
					responseLabel1.setText("<html><body style='width: 360px;'> Everybody is kind and genuine</body></html>");
				} else if (intensity <= 50) {
					responseLabel1.setText("<html><body style='width: 360px;'> Everybody is kind however, I get the feeling they are hiding something</body></html>");
				} else if (intensity <= 75) {
					responseLabel1.setText("<html><body style='width: 360px;'> Everybody is kind however, I get the feeling they are hiding something</body></html>");
				} else {
					responseLabel1.setText("<html><body style='width: 360px;'> Everybody is kind however a little strange</body></html>");
				}
			}
		});




		// Panel 2 for Gardener
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(BorderFactory.createLineBorder(new Color(255, 205, 59), 3));
		panel_2.setBackground(new Color(30, 15, 15));
		panel_2.setLayout(null);


		// Load the gardener image using a relative path
		ImageIcon icon2 = new ImageIcon(getClass().getResource("Gardener.png"));

		// Get the image from the icon
		Image image2 = icon2.getImage();

		// Scale the image to the desired dimensions (width: 200, height: 250)
		Image scaledImage2 = image2.getScaledInstance(200, 250, Image.SCALE_SMOOTH);

		// Create a new ImageIcon using the scaled image
		ImageIcon scaledIcon2 = new ImageIcon(scaledImage2);

		// Create a JLabel to hold the icon
		JLabel gardenerImageLabel = new JLabel(scaledIcon2);

		// Set the bounds for the JLabel (adjust these values as needed)
		gardenerImageLabel.setBounds(16, 52, 207, 250);

		// Add the JLabel to the new panel
		panel_2.add(gardenerImageLabel);


		//Response Label
		JLabel responseLabel2 = new JLabel("...");
		responseLabel2.setVerticalAlignment(SwingConstants.TOP);
		responseLabel2.setBounds(244, 68, 478, 200);
		responseLabel2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		responseLabel2.setForeground(Color.WHITE);
		panel_2.add(responseLabel2);

		//Button Creation 
		JButton btnNewButton = new JButton("Where were you? Alibi? ");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton.setBounds(244, 280, 166, 29);
		panel_2.add(btnNewButton);

		JButton btnNewButton_5 = new JButton("Any strange shipments?");
		btnNewButton_5.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton_5.setBounds(244, 321, 166, 29);
		panel_2.add(btnNewButton_5);

		JButton btnNewButton_9 = new JButton("How are the others on the estate?");
		btnNewButton_9.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton_9.setBounds(422, 321, 203, 29);
		panel_2.add(btnNewButton_9);

		JButton btnNewButton_10 = new JButton("Behaviour of Staff");
		btnNewButton_10.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton_10.setBounds(429, 279, 153, 29);
		panel_2.add(btnNewButton_10);

		btnNewButton.setBackground(new Color(80, 40, 40));
		btnNewButton.setForeground(Color.BLACK);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int intensity = slider.getValue();
				if (intensity <= 25) {
					responseLabel2.setText("<html><body style='width: 360px;'> I was attending to the shed in the garden. It has been quite disorganized lately</body></html>");
				} else if (intensity <= 50) {
					responseLabel2.setText("<html><body style='width: 380px;'> I told you I was in the shed.</body></html>");
				} else if (intensity <= 75) {
					responseLabel2.setText("<html><body style='width: 360px;'> I was in the shed however I went into the grand foyer once</body></html>");
				} else {
					responseLabel2.setText("<html><body style='width: 360px;'> I went to the Grand Foyer once to perfect the arrangement of the flowers for tomorrows guests</body></html>");
				}
			}
		});

		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int intensity = slider.getValue();
				if (intensity <= 25) {
					responseLabel2.setText("<html><body style='width: 360px;'> Their have been many shipments of new flowers</body></html>");
				} else if (intensity <= 50) {
					responseLabel2.setText("<html><body style='width: 360px;'> Their have been many shipment sof new flowers. Some are quite dangerouse..</body></html>");
				} else if (intensity <= 75) {
					responseLabel2.setText("<html><body style='width: 360px;'> I was attending to my duties as per usual</body></html>");
				} else {
					responseLabel2.setText("<html><body style='width: 360px;'> Their was a shipment of flowers said to be extremely poisonouse if ingested</body></html>");
				}
			}
		});

		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int intensity = slider.getValue();
				if (intensity <= 25) {
					responseLabel2.setText("Its a pleasent place to work, ervybody is delightful");
				} else if (intensity <= 50) {
					responseLabel2.setText("Everybody is delightful especially the Mistress and Lady Margaret");
				} else if (intensity <= 75) {
					responseLabel2.setText("The pay is a little on the lower end however I get to work with amazing people!");
				} else {
					responseLabel2.setText("<html><body style='width: 360px;'> The estate owners are delightful, and the staff is kind. I have done many favours for both over the years.</body></html>");
				}
			}
		});

		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int intensity = slider.getValue();
				if (intensity <= 25) {
					responseLabel2.setText("<html><body style='width: 360px;'> It was like any other day. </body></html>");
				} else if (intensity <= 50) {
					responseLabel2.setText("<html><body style='width: 360px;'> Some of the staff like the butler were quieter than usual</body></html>");
				} else if (intensity <= 75) {
					responseLabel2.setText("<html><body style='width: 360px;'> Some were quiet however it was a regular day</body></html>");
				} else {
					responseLabel2.setText("<html><body style='width: 360px;'> Its not my job to look after other staff members.</body></html>");
				}
			}
		});

		tabbedPane.addTab("Gardener", null, panel_2, null);
		tabbedPane.setForegroundAt(1, Color.WHITE);
		// Panel 3 for MAID
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Maid", null, panel_3, null);

		panel_3.setBorder(BorderFactory.createLineBorder(new Color(255, 205, 59), 3));
		panel_3.setBackground(new Color(30, 15, 15));
		panel_3.setLayout(null);

		ImageIcon icon = new ImageIcon(getClass().getResource("Maid.png"));
		Image image = icon.getImage();
		Image scaledImage = image.getScaledInstance(200, 250, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);
		JLabel maidImageLabel = new JLabel(scaledIcon);
		maidImageLabel.setBounds(16, 66, 207, 250);
		panel_3.add(maidImageLabel);

		JLabel responseLabel3 = new JLabel("...");
		responseLabel3.setVerticalAlignment(SwingConstants.TOP);
		responseLabel3.setBounds(234, 68, 494, 202);
		responseLabel3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		responseLabel3.setForeground(Color.WHITE);
		panel_3.add(responseLabel3);

		JButton btnNewButton_2 = new JButton("Do you have an alibi?");
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton_2.setBounds(293, 282, 184, 29);
		panel_3.add(btnNewButton_2);

		JButton btnNewButton_11 = new JButton("View on the Estate");
		btnNewButton_11.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton_11.setBounds(293, 312, 158, 29);
		panel_3.add(btnNewButton_11);

		JButton btnNewButton_12 = new JButton("Notice anything strange?");
		btnNewButton_12.setForeground(new Color(0, 0, 0));
		btnNewButton_12.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton_12.setBounds(361, 343, 207, 29);
		panel_3.add(btnNewButton_12);

		JButton btnNewButton_13 = new JButton("Relationship to owner");
		btnNewButton_13.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton_13.setBounds(499, 312, 169, 29);
		panel_3.add(btnNewButton_13);

		JButton btnNewButton_14 = new JButton("Behaviour of other staff");
		btnNewButton_14.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton_14.setBounds(489, 282, 179, 29);
		panel_3.add(btnNewButton_14);
		tabbedPane.setForegroundAt(2, Color.WHITE);

		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int intensity = slider.getValue();
				if (intensity <= 25) {
					responseLabel3.setText("<html><body style='width: 400px;'>I was in the Grand Foyer cleaning for tomorrows guests.</body></html>");
				} else if (intensity <= 50) {
					responseLabel3.setText("<html><body style='width: 400px;'>I told you I was in the Grand Foyer cleaning for tomrrows guests. Alibi? I've worked here for 50 years!</body></html>");
				} else if (intensity <= 75) {
					responseLabel3.setText("<html><body style='width: 400px;'>I was in the Grand Foyer. How dare you accuse me!</body></html>");
				} else {
					responseLabel3.setText("<html><body style='width: 400px;'>IM LEAVING!</body></html>");
				}
			}
		});

		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int intensity = slider.getValue();
				if (intensity <= 25) {
					responseLabel3.setText("Recently their have been far to many deaths, its quite suspiciouse");
				} else if (intensity <= 50) {
					responseLabel3.setText("Now that the mistress is deceased it will all go Lady Margaret ");
				} else if (intensity <= 75) {
					responseLabel3.setText("I have done my best to serve the estate and whoever rules over it");
				} else {
					responseLabel3.setText("<html><body style='width: 400px;'>This estate has been riddled with misfortune and darkness since for more than 50 years</body></html>");
				}
			}
		});

		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int intensity = slider.getValue();
				if (intensity <= 25) {
					responseLabel3.setText("<html><body style='width: 380px;'> I heard voices coming from the grand foyer, however I didnt see anybody</body></html>");
				} else if (intensity <= 50) {
					responseLabel3.setText("<html><body style='width: 380px;'>I heard voices coming from the grand foyer, however I didnt see anybody.I was scared</body></html>");
				} else if (intensity <= 75) {
					responseLabel3.setText("<html><body style='width: 380px;'>I heard voices coming from the grand foyer, however I didnt see anybody.I was scared</body></html>");
				} else {
					responseLabel3.setText("<html><body style='width: 380px;'>I heard voices coming from the grand foyer, however I didnt see anybody.I was scared</body></html>");
				}
			}
		});

		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int intensity = slider.getValue();
				if (intensity <= 25) {
					responseLabel3.setText("<html><body style='width: 380px;'> I had know the man for 50 years, what a shame what happen to him</body></html>");
				} else if (intensity <= 50) {
					responseLabel3.setText("<html><body style='width: 380px;'> He was a kind man he often helped me financially over the years</body></html>");
				} else if (intensity <= 75) {
					responseLabel3.setText("<html><body style='width: 380px;'> He was like a brother to me. We'd know eachother for 50 years afterall.</body></html>");
				} else {
					responseLabel3.setText("<html><body style='width: 380px;'> He was a great man, its a shame what happend to him. His death was so sudden.Their was many rumours that the new mistress had something to do with his death but no proof.He was like a little brother to me...</body></html>");
				}
			}
		});

		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int intensity = slider.getValue();
				if (intensity <= 25) {
					responseLabel3.setText("<html><body style='width: 380px;'> I noticed the staff had a more subdued demeanor that day especially the butler.</body></html>");
				} else if (intensity <= 50) {
					responseLabel3.setText("<html><body style='width: 380px;'> There was an unusual hush among the staff that day, I didnt see the gardener much</body></html>");
				} else if (intensity <= 75) {
					responseLabel3.setText("<html><body style='width: 380px;'>  Everyone, from the gardeners to the footmen, maintained a routine that felt a bit too mechanical that day.</body></html>");
				} else {
					responseLabel3.setText("<html><body style='width: 380px;'> There was an eerie silence that day but everybody was just doing their work.I've notived Lady Margaret and the gardener enjoy gardening</body></html>");
				}
			}
		});




		//Panel for Daughter
		JPanel panel_4 = new JPanel();
		panel_4.setToolTipText("");
		tabbedPane.addTab("Margaret", null, panel_4, null);
		panel_4.setBorder(BorderFactory.createLineBorder(new Color(255, 205, 59), 3));
		panel_4.setBackground(new Color(30, 15, 15));
		panel_4.setLayout(null);

		// Load the butler image using a relative path
		ImageIcon icon4 = new ImageIcon(getClass().getResource("Daughter.png"));

		// Get the image from the icon
		Image image4 = icon4.getImage();

		// Scale the image to the desired dimensions
		Image scaledImage4 = image4.getScaledInstance(200, 250, Image.SCALE_SMOOTH);

		// Create a new ImageIcon using the scaled image
		ImageIcon scaledIcon4 = new ImageIcon(scaledImage4);

		// Create a JLabel to hold the icon
		JLabel daughterImageLabel = new JLabel(scaledIcon4);

		// Set the bounds for the JLabel 
		daughterImageLabel.setBounds(16, 66, 207, 250);

		// Add the JLabel to the new panel
		panel_4.add(daughterImageLabel);

		JLabel responseLabel4 = new JLabel("...");
		responseLabel4.setVerticalAlignment(SwingConstants.TOP);
		responseLabel4.setBounds(235, 75, 494, 189);
		responseLabel4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		responseLabel4.setForeground(Color.WHITE);
		panel_4.add(responseLabel4);

		JButton btnNewButton_15 = new JButton("Where were you? Alibi?");
		btnNewButton_15.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton_15.setBounds(224, 259, 174, 29);
		panel_4.add(btnNewButton_15);

		JButton btnNewButton_16 = new JButton("Estates future");
		btnNewButton_16.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton_16.setBounds(224, 291, 164, 29);
		panel_4.add(btnNewButton_16);

		JButton btnNewButton_17 = new JButton("Relationship with Staff");
		btnNewButton_17.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton_17.setBounds(410, 259, 155, 29);
		panel_4.add(btnNewButton_17);

		JButton btnNewButton_18 = new JButton("Discrepencies");
		btnNewButton_18.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton_18.setBounds(408, 290, 117, 29);
		panel_4.add(btnNewButton_18);

		JButton btnNewButton_20 = new JButton("Notice anything strange?");
		btnNewButton_20.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton_20.setBounds(537, 290, 164, 29);
		panel_4.add(btnNewButton_20);





		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int intensity = slider.getValue();
				if (intensity <= 25) {
					responseLabel4.setText("<html><body style='width: 400px;'>I was in my private study.</body></html>");
				} else if (intensity <= 50) {
					responseLabel4.setText("<html><body style='width: 400px;'>I told you I was in my private study</body></html>");
				} else if (intensity <= 75) {
					responseLabel4.setText("<html><body style='width: 400px;'>I took a walk around the estate for 10 minutes as I grew tired of sitting</body></html>");
				} else {
					responseLabel4.setText("<html><body style='width: 400px;'>I was working in my private study</body></html>");
				}
			}
		});
		btnNewButton_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int intensity = slider.getValue();
				if (intensity <= 25) {
					responseLabel4.setText("<html><body style='width: 400px;'>It's very sad on what happend to my late mother, but I must be strong for the estate.</body></html>");
				} else if (intensity <= 50) {
					responseLabel4.setText("<html><body style='width: 400px;'>II intend to see that the estate’s legacy is preserved, and I believe in claiming what destiny has earmarked for me.</body></html>");
				} else if (intensity <= 75) {
					responseLabel4.setText("<html><body style='width: 400px;'>I intend to see that the estate’s legacy is preserved, and I believe in claiming what destiny has earmarked for me.</body></html>");
				} else {
					responseLabel4.setText("<html><body style='width: 400px;'>I intend to see that the estate’s legacy is preserved, and I believe in claiming what destiny has earmarked for me.</body></html>");
				}
			}
		});
		btnNewButton_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int intensity = slider.getValue();
				if (intensity <= 25) {
					responseLabel4.setText("<html><body style='width: 400px;'>I have remained a good relaitonship with everybody.</body></html>");
				} else if (intensity <= 50) {
					responseLabel4.setText("<html><body style='width: 400px;'>Everybody is efficent and completes their work. Their are a few who are strange like the butler and maid.</body></html>");
				} else if (intensity <= 75) {
					responseLabel4.setText("<html><body style='width: 400px;'>I have made mutually beneficial connections with staff.Certain alliances, though private, are strategic. I always consider the implications of each connection on my future and legacy.</body></html>");
				} else {
					responseLabel4.setText("<html><body style='width: 400px;'>Everybody is amazing.</body></html>");
				}
			}
		});
		btnNewButton_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int intensity = slider.getValue();
				if (intensity <= 25) {
					responseLabel4.setText("<html><body style='width: 400px;'>I didn't meet with anybody in the foyer. These are lies</body></html>");
				} else if (intensity <= 50) {
					responseLabel4.setText("<html><body style='width: 400px;'>Why would I meet with somebody in the middle of the night.</body></html>");
				} else if (intensity <= 75) {
					responseLabel4.setText("<html><body style='width: 400px;'>These are lies .</body></html>");
				} else {
					responseLabel4.setText("<html><body style='width: 400px;'>I've had enough.</body></html>");
				}
			}
		});
		btnNewButton_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int intensity = slider.getValue();
				if (intensity <= 25) {
					responseLabel4.setText("<html><body style='width: 400px;'>All the staff was quiet that day, some were acting strange</body></html>");
				} else if (intensity <= 50) {
					responseLabel4.setText("<html><body style='width: 400px;'>Some of the staff were roaming around at strange hours.</body></html>");
				} else if (intensity <= 75) {
					responseLabel4.setText("<html><body style='width: 400px;'>I saw the butler and maid acting strange and avoiding contact.</body></html>");
				} else {
					responseLabel4.setText("<html><body style='width: 400px;'>It was a very strange day. Their was an eerie silence.</body></html>");
				}
			}
		});


		// Navigation Buttons
		JButton btnNewButton_3 = new JButton("CONTINUE");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((ApplicationData.frame3 == null)) {
					ApplicationData.frame3 = new Frame3();
				}
				ApplicationData.frame3.setVisible(true);
				ApplicationData.frame2.setVisible(false);
			}
		});
		btnNewButton_3.setBounds(602, 479, 132, 29);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_19 = new JButton("BACK");
		btnNewButton_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((ApplicationData.frame2 == null)) {
					ApplicationData.frame2 = new Frame2();
				}
				ApplicationData.frame2.setVisible(false);
				ApplicationData.frame1.setVisible(true);
			}
		});
		btnNewButton_19.setBounds(31, 479, 132, 29);
		contentPane.add(btnNewButton_19);

		JLabel lblNewLabel_1 = new JLabel("          Interrogation Intensity ");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(287, 452, 224, 16);
		contentPane.add(lblNewLabel_1);
	}
}
