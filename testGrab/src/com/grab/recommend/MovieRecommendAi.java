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
	static String searchtitle=null;
	 static String[] myrecommend=new String[10];
	 static String[] recommendedfilms=new String[10];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			//@SuppressWarnings("null")
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

	public static void setName(String title)
	{
		searchtitle=title;
	}

	/**
	 * Create the application.
	 * @throws Exception 
	 * @throws FileNotFoundException 
	 */
	public MovieRecommendAi() throws Exception{
		getRecommend();
		initialize();
	}
	public void getRecommend() throws Exception
	{
		String chosen=null;
		BufferedReader br = new BufferedReader(new FileReader("data/similarity_ranking.csv"));
		BufferedReader movielist = new BufferedReader(new FileReader("data/movie_metadata.csv"));
		String myline=null;
		
		String[] myst=null; 
		String line=null;
		String[] st=null;
	
		while((myline = movielist.readLine()) != null) {
			myst=myline.split(",");
			if(myst[1].equals(searchtitle))
			{
				System.out.println(searchtitle+myst[0]);
				chosen=myst[0];
				
				break;
			}
		}
		
			
		int i=0;
		while((line = br.readLine()) != null) {
			st=line.split(",");
			
			 if(st[0].equals(chosen))
			 {
				 myrecommend[i] = st[1];
				 System.out.println(st[1]);
				 i++;
			 }
			 if(i==10)
				 break;
		 
		 }
		movielist.close();
		 movielist = new BufferedReader(new FileReader("data/movie_metadata.csv"));
		int x=0;
		while((myline = movielist.readLine()) != null) {
			
			myst=myline.split(",");
			for(int k=0;k<10;k++)
			{
			if(myst[0].equals(myrecommend[k]))
			{
				
				recommendedfilms[x]=myst[1];
				System.out.println(recommendedfilms[x]);
				x++;
				//chosen=myst[0];
				
				//break;
			}
			}
			
		}
		movielist.close();
		br.close();
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
		JLabel[] labels=new JLabel[10];
		JLabel[] thumb = new JLabel[10];
		JPanel panel = new JPanel(new FlowLayout());
		panel.setBounds(300,300,500,200);
		
//		BufferedReader moviefile = new BufferedReader(new FileReader("data/moviefile.txt"));
//		BufferedReader genrefile = new BufferedReader(new FileReader("data/genrefile.txt"));
		BufferedReader movielist = new BufferedReader(new FileReader("data/movie_metadata.csv"));
		String myline=null; 
		String[] st=null; 
//		int i=0;
//		int found=-1;
/*		while((myline = movielist.readLine()) != null) 
		{
			found=-1;
			st=myline.split(",");
			for(int j=0;j<10;j++)
			{
				if(st[0].equals(myrecommend[j]))
					{
						found=j;
						break;
					}
			}
			
			filmTitle = st[1];
			//filmGenre = genrefile.readLine();
			
			
			
*/			
			for(int i=0;i<10;i++)
			{
			posX+=154;
			//String num=myrecommend[i];
			labels[i] = new JLabel(recommendedfilms[i]);
			System.out.println("HI"+myrecommend[i]);
			labels[i].setForeground(Color.RED);
			labels[i].setBounds(posX, posY+150, 100, 20);
			frame.getContentPane().add(labels[i]);
			thumb[i] = new JLabel(new ImageIcon("res/film.png"));
			thumb[i].setBounds(posX,posY, 127, 183);
			frame.getContentPane().add(thumb[i]);
			if(i==4)
			{
				posY+=200;
				posX=150;
			}
			//panel.add(labels[i]);
			}
			
			
			
		
		
		//movielist.close();
		panel.setVisible(true);
		
		JLabel home = new JLabel(new ImageIcon("res/grablayoutempty.png"));
		home.setBounds(0, 0, 1360, 768);
		frame.getContentPane().add(home);
	}

}
