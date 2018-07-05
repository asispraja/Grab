package com.grab.frontend;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class RecommendationPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecommendationPage frame = new RecommendationPage();
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
	public RecommendationPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JLabel lblRecommendedForYou = new JLabel("Selected Movies:");
		lblRecommendedForYou.setBounds(394, 84, 238, 14);
		lblRecommendedForYou.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblRecommendedForYou);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon("res/image/thumb.png"));
		label_6.setBounds(394, 109, 127, 183);
		label_6.setVisible(false);
		contentPane.add(label_6);
		
		
		
		
		
		JLabel lblTopTrending = new JLabel("Top Trending");
		lblTopTrending.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTopTrending.setBounds(394, 300, 238, 14);
		contentPane.add(lblTopTrending);
		int x=394;
		int y=338;
		for(int i=1;i<12;i++)
		{
		JLabel[] suggested = new JLabel[12];
		String ss="data/ima/mythumb"+i+".jpg";
		Image ima=new ImageIcon(ss).getImage().getScaledInstance(127, 183, Image.SCALE_DEFAULT);
		
		suggested[i] = new JLabel(new ImageIcon(ima));
				
		suggested[i].setBounds(x, y, 127, 183);
		
		
		suggested[i].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				label_6.setIcon(new ImageIcon(ima));
				label_6.setVisible(true);
			}
		});
		contentPane.add(suggested[i]);
		x+=160;
		if(i%6==5)
		{
			y=y+200;
			x=394;
		}
		}
		
		textField = new JTextField();
		textField.setBounds(509, 22, 738, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		txtSearch = new JTextField();
		txtSearch.setBounds(1248, 22, 70, 27);
		txtSearch.setHorizontalAlignment(SwingConstants.CENTER);
		txtSearch.setText("Select");
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		JLabel lblTreanding = new JLabel("Trending");
		lblTreanding.setBounds(48, 172, 276, 44);
		lblTreanding.setHorizontalAlignment(SwingConstants.CENTER);
		lblTreanding.setForeground(Color.WHITE);
		lblTreanding.setFont(new Font("Arial Black", Font.PLAIN, 26));
		contentPane.add(lblTreanding);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(0, 182, 362, 34);
		label_2.setIcon(new ImageIcon("res/image/line.png"));
		contentPane.add(label_2);
		
		JLabel lblNewLabel = new JLabel("Home");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MainPage.main(null);
				dispose();
			}
		});
		lblNewLabel.setBounds(38, 117, 276, 44);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		
		
		JLabel lblPopular = new JLabel("AI Recommendation");
		/*lblPopular.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				HomePage.main(null);
				dispose();
			}
		});*/
		lblPopular.setBounds(38, 227, 324, 44);
		lblPopular.setHorizontalAlignment(SwingConstants.CENTER);
		lblPopular.setForeground(Color.RED);
		lblPopular.setFont(new Font("Arial Black", Font.PLAIN, 26));
		
		contentPane.add(lblPopular);
		
		
		JLabel lblHistory = new JLabel("LIBRARY");
		lblHistory.setBounds(38, 331, 276, 44);
		lblHistory.setHorizontalAlignment(SwingConstants.CENTER);
		lblHistory.setForeground(Color.WHITE);
		lblHistory.setFont(new Font("Arial Black", Font.PLAIN, 26));
		contentPane.add(lblHistory);
		
		JLabel lblHistory_1 = new JLabel("History");
		lblHistory_1.setBounds(60, 432, 276, 44);
		lblHistory_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblHistory_1.setForeground(Color.WHITE);
		lblHistory_1.setFont(new Font("Arial Black", Font.PLAIN, 26));
		contentPane.add(lblHistory_1);
		
		JLabel lblLikedVideos = new JLabel("Liked Videos");
		lblLikedVideos.setBounds(70, 497, 276, 44);
		lblLikedVideos.setHorizontalAlignment(SwingConstants.CENTER);
		lblLikedVideos.setForeground(Color.WHITE);
		lblLikedVideos.setFont(new Font("Arial Black", Font.PLAIN, 26));
		contentPane.add(lblLikedVideos);
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(0, 507, 362, 34);
		label_5.setIcon(new ImageIcon("res/image/line.png"));
		contentPane.add(label_5);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(0, 442, 362, 34);
		label_4.setIcon(new ImageIcon("res/image/line.png"));
		contentPane.add(label_4);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(0, 237, 362, 34);
		label_3.setIcon(new ImageIcon("res/image/line.png"));
		contentPane.add(label_3);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(0, 126, 362, 34);
		label_1.setIcon(new ImageIcon("res/image/line.png"));
		contentPane.add(label_1);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 1355, 730);
		label.setIcon(new ImageIcon("res/image/homepage123.png"));
		contentPane.add(label);
	}
	
	
}
