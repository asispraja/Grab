package com.grab.recommend;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Color;

public class HomePage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage window = new HomePage();
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
	public HomePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.BLACK);
		frame.setBounds(0, 0, 1376, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextField search = new JTextField("Enter A Movie Name");
		search.setBounds(113, 390, 300, 30);
		frame.getContentPane().add(search);
		
		JLabel btnsearch = new JLabel(new ImageIcon("res/liked.png"));
		btnsearch.setBounds(450, 390, 30, 30);
		frame.getContentPane().add(btnsearch);
		
		JLabel home = new JLabel(new ImageIcon("res/sidehome.png"));
		home.setBounds(0, 0, 1360, 768);
		frame.getContentPane().add(home);
		
		
	}

}
