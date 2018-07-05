package com.grab.recommend;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;

public class GrabMain {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GrabMain window = new GrabMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GrabMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1376, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		JTextField user = new JTextField("Enter UserName");
		user.setBounds(620, 354, 150, 40);
		user.setBorder(null);
		user.setBackground(null);
		user.setFocusable(true);
		user.setVisible(true);
		user.setOpaque(false);
		
		
		frame.getContentPane().add(user);
		
		JPasswordField password = new JPasswordField("Enter Password");
		password.setBounds(620, 430, 150, 40);
		password.setBorder(null);
		password.setBackground(null);
		password.setFocusable(true);
		password.setVisible(true);
		password.setOpaque(false);
		
		
		frame.getContentPane().add(password);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(635, 548, 100, 50);
		
		btnLogin.setOpaque(false);
		btnLogin.setContentAreaFilled(false);
		btnLogin.setBorderPainted(false);
		frame.getContentPane().add(btnLogin);
		JLabel lblNewLabel = new JLabel(new ImageIcon("res/homepage.png"));
		lblNewLabel.setBounds(0, 0, 1360, 768);
		frame.getContentPane().add(lblNewLabel);
		
		
	}
}
