package com.grab.frontend;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Label;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginPaage extends JFrame {
	

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField txtLogin;
	private JTextField txtClose;
	private JLabel lblNewLabel_1;
	private JLabel lblNotAMembersign;
	private JLabel lblNewLabel;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		
		catch(Exception e)
		{
			//handlels exception
			
		}
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPaage frame = new LoginPaage();
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
	public LoginPaage() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 629, 309);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 0, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField("");
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setForeground(new Color(75, 0, 130));
		textField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textField.setBounds(210, 81, 260, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		
		label = new JLabel("");
		label.setIcon(new ImageIcon("res/image/pass.png"));
		label.setBounds(180, 139, 32, 32);
		contentPane.add(label);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		passwordField.setBounds(210, 139, 260, 32);
		contentPane.add(passwordField);
		
		txtLogin = new JTextField();
		txtLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String x="100";
				String pass = new String(passwordField.getPassword());
				if(textField.getText().equals(x) && pass.equals(x))
				{
				MainPage.setUser(x);
				MainPage.main(null);
				
				
				dispose();
				}
				
			}
		});
		
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("res/image/userimage.png"));
		lblNewLabel.setBounds(180, 81, 32, 32);
		contentPane.add(lblNewLabel);
		txtLogin.setForeground(Color.WHITE);
		txtLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtLogin.setHorizontalAlignment(SwingConstants.CENTER);
		txtLogin.setText("LOGIN");
		txtLogin.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		txtLogin.setOpaque(false);
		txtLogin.setEditable(false);
		txtLogin.setColumns(10);
		txtLogin.setBounds(180, 226, 126, 26);
		contentPane.add(txtLogin);
		
		txtClose = new JTextField();
		txtClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		
		lblNotAMembersign = new JLabel("Not a member??Sign up for free");
		lblNotAMembersign.setForeground(new Color(255, 255, 255));
		lblNotAMembersign.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNotAMembersign.setBounds(180, 192, 290, 20);
		contentPane.add(lblNotAMembersign);
		txtClose.setForeground(Color.WHITE);
		txtClose.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtClose.setHorizontalAlignment(SwingConstants.CENTER);
		txtClose.setText("CLOSE");
		txtClose.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		txtClose.setOpaque(false);
		txtClose.setEditable(false);
		txtClose.setColumns(10);
		txtClose.setBounds(340, 226, 126, 26);
		contentPane.add(txtClose);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblNewLabel_1.setIcon(new ImageIcon("res/image/logowala.png"));
		lblNewLabel_1.setBounds(0, 0, 629, 309);
		contentPane.add(lblNewLabel_1);
		setUndecorated(true);
	}
}
