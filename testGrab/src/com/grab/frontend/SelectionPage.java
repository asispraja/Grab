package com.grab.frontend;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class SelectionPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtSearch;
	String[] genre= {"Action","Comedy","Horror","Romantic","Sci-Fi","Thriller","Documentary","Animation","Adventure"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectionPage frame = new SelectionPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SelectionPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1360, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		textField = new JTextField();
		textField.setBounds(929, 36, 355, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		txtSearch = new JTextField();
		txtSearch.setHorizontalAlignment(SwingConstants.CENTER);
		txtSearch.setText("search");
		txtSearch.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtSearch.setColumns(10);
		txtSearch.setBounds(1283, 36, 51, 27);
		contentPane.add(txtSearch);
		int x=628;
		int y=263;
		JLabel[] lblAction= new JLabel[9];
		JLabel[] thumb = new JLabel[9];
		for(int i=0;i<9;i++)
		{
			
		
		lblAction[i]= new JLabel(genre[i]);
		lblAction[i].setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAction[i].setForeground(Color.BLACK);
		lblAction[i].setBounds(x, y, 100, 47);
		contentPane.add(lblAction[i]);
		thumb[i] = new JLabel(new ImageIcon("res/image/kingsman-the-golden-circle-119567.jpg"));
		
		thumb[i].setBounds(x, y-146, 153, 149);
		contentPane.add(thumb[i]);
		
		x=x+200;
		if(i%3==2)
		{
			y=y+200;
			x=628;
		}
		}
		/*JLabel lblComedy = new JLabel("COMEDY");
		lblComedy.setForeground(Color.BLACK);
		lblComedy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblComedy.setBounds(815, 263, 70, 47);
		contentPane.add(lblComedy);*/
		
		/*JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon("res/image/kingsman-the-golden-circle-119567.jpg"));
		label_5.setBounds(597, 117, 153, 149);
		contentPane.add(label_5);*/
		
		JLabel lblGenre = new JLabel("GENRE");
		lblGenre.setFont(new Font("Arial Black", Font.PLAIN, 52));
		lblGenre.setForeground(Color.WHITE);
		lblGenre.setBounds(68, 188, 409, 47);
		contentPane.add(lblGenre);
		
		JLabel lblActors = new JLabel("ACTORS");
		lblActors.setForeground(Color.WHITE);
		lblActors.setFont(new Font("Arial Black", Font.PLAIN, 52));
		lblActors.setBounds(68, 301, 409, 47);
		contentPane.add(lblActors);
		
		JLabel lblCountry = new JLabel("COUNTRY");
		lblCountry.setForeground(Color.WHITE);
		lblCountry.setFont(new Font("Arial Black", Font.PLAIN, 52));
		lblCountry.setBounds(54, 407, 409, 47);
		contentPane.add(lblCountry);
		
		JLabel lblYear = new JLabel("YEAR");
		lblYear.setForeground(Color.WHITE);
		lblYear.setFont(new Font("Arial Black", Font.PLAIN, 52));
		lblYear.setBounds(59, 514, 409, 47);
		contentPane.add(lblYear);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("res/image/line.png"));
		label_1.setBounds(28, 180, 512, 66);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("res/image/line.png"));
		label_2.setBounds(28, 290, 512, 66);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("res/image/line.png"));
		label_3.setBounds(28, 396, 512, 66);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("res/image/line.png"));
		label_4.setBounds(28, 506, 512, 66);
		contentPane.add(label_4);
		
		JLabel lblSelectProperties = new JLabel("SELECT PROPERTIES");
		lblSelectProperties.setFont(new Font("Tahoma", Font.PLAIN, 39));
		lblSelectProperties.setForeground(Color.WHITE);
		lblSelectProperties.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectProperties.setBounds(10, 53, 458, 72);
		contentPane.add(lblSelectProperties);
		
		JLabel label = new JLabel("");
		label.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		label.setIcon(new ImageIcon("res/image/homeplain1.png"));
		label.setBounds(0, 11, 1344, 719);
		contentPane.add(label);
	}

}
