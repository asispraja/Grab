package com.grab.recommend;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.BoxLayout;

public class MyButton {

	private JFrame frame;
	int count=0;
	private JTextField txtHello;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyButton window = new MyButton();
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
	public MyButton() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(0, 0, 1360,768 );
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(500,500,100,50);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				count++;
			}
		});
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		
		frame.getContentPane().add(btnNewButton);
		
		JPanel panel = new JPanel();
		
		txtHello = new JTextField(10);
		
		txtHello.setText("Hello");
		frame.getContentPane().add(txtHello);
		txtHello.setColumns(10);
		
		
		
		
	}

}
