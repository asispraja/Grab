package com.grab.recommend;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MovieRecommendAi {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MovieRecommendAi window = new MovieRecommendAi();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws FileNotFoundException 
	 */
	public MovieRecommendAi() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize() throws Exception {
		frame = new JFrame();
		frame.setBounds(0, 0, 1376, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		String filmTitle=null,filmGenre=null;
		int posX=100,posY=260;
		JLabel[] labels=new JLabel[14];
		JLabel[] thumb = new JLabel[14];
//		JPanel panel = new JPanel(new FlowLayout());
//		panel.setSize(1300,700);
		BufferedReader moviefile = new BufferedReader(new FileReader("data/moviefile.txt"));
		BufferedReader genrefile = new BufferedReader(new FileReader("data/genrefile.txt"));
		for(int i=0;i<14;i++)
		{
			filmTitle = moviefile.readLine();
			filmGenre = genrefile.readLine();
			posX+=154;
			
			
			
			labels[i] = new JLabel(filmTitle+" \n"+filmGenre);
			labels[i].setForeground(Color.WHITE);
			labels[i].setBounds(posX, posY+150, 100, 20);
			frame.getContentPane().add(labels[i]);
			thumb[i] = new JLabel(new ImageIcon("res/film.png"));
			thumb[i].setBounds(posX,posY, 127, 183);
			frame.getContentPane().add(thumb[i]);
			if(i==6)
			{
				posY+=280;
				posX=100;
			}
			//panel.add(labels[i]);
		
		}
		//panel.setVisible(true);
		
		JLabel home = new JLabel(new ImageIcon("res/grablayoutempty.png"));
		home.setBounds(0, 0, 1360, 768);
		frame.getContentPane().add(home);
	}

}
