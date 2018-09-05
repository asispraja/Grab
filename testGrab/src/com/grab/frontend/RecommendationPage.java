package com.grab.frontend;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.grab.backend.ShowRecommendation;
// TODO write  an arraylist to get the movie id and movie name 
public class RecommendationPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtSearch;
	String ss=null;
	int j=0;
	List<Integer> result = null;
	//String[] s= {"1","10","1011","1016","1022","1028","1029","1030","1031","1032","1033","1035","1036","104"};
	List<String> recommendeds= new ArrayList<String>();
	Map<Integer,String > movie = new LinkedHashMap<Integer,String>();
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
	public void getMovieName()
	{
		BufferedReader m=null;
		try {
			 m = new BufferedReader(new FileReader("data/test/finalmoviedata.csv"));
			String line =null;
			String st[] =null;
			int myyline=0;
			while((line = m.readLine()) != null) {
			 	st=line.split(",");
			 	myyline++;
			 	if(myyline==1)
			 		break;
			 	movie.put(Integer.parseInt(st[0]), st[1]);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				m.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public Integer getid(String name)
	{
		for(Integer key: movie.keySet())
		{
			if(movie.get(key).equals(name))
			{
				return key;
			}
		}
		return null;
	}
	
	public RecommendationPage() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 768);
		System.out.println("start");
		//getMovieName();
		System.out.println("ready");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JLabel lblRecommendedForYou = new JLabel("Selected Movies:");
		lblRecommendedForYou.setBounds(394, 84, 238, 14);
		lblRecommendedForYou.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblRecommendedForYou);
		
		JLabel selectedM = new JLabel("HIIIIIII");
		selectedM.setIcon(new ImageIcon("data/kkimage/"+"8MM"+".jpg"));
		selectedM.setBounds(394, 109, 127, 183);
		selectedM.setVisible(false);
		contentPane.add(selectedM);
		
		JLabel lblTopTrending = new JLabel("Top Trending");
		lblTopTrending.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTopTrending.setBounds(394, 300, 238, 14);
		contentPane.add(lblTopTrending);
		int x=394;
		int y=338;
		JLabel[] suggested = new JLabel[12];
		int count=0;
		for(Integer j:movie.keySet()) 
		{
			count++;
			if(count>11)
				break;
		 ss="data/kkimage/"+"8MM"+".jpg";
		 System.out.println(ss);
		Image ima=new ImageIcon(ss).getImage().getScaledInstance(127, 183, Image.SCALE_DEFAULT);
		suggested[j] = new JLabel("HIIIII");
		//suggested[j] = new JLabel(new ImageIcon(ima));
			
		suggested[j] = new JLabel(ss);	
		suggested[j].setBounds(x, y, 127, 183);
		
		suggested[j].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			//	getRecommendations(suggested[j].getText());
				//selectedM.setIcon(new ImageIcon(ima));
				selectedM.setVisible(true);
			}
		});
		contentPane.add(suggested[j]);
		x+=160;
		if(j%6==5)
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
	public List<String> getRecommendations(String selected)
	{
		List<String> recommended= new ArrayList<String>();
		String line;
		String st[] = null;
		System.out.println(selected);
		/*try {
			BufferedReader bf = new BufferedReader (new FileReader("data/test/cosine.csv"));
			
			
			
			while ((line = bf.readLine()) != null) {
			    st=line.split(",");
			  
			    if(st[0]==selected)
			    {
			    	for(int i=0;i<st.length;i++)
			    	{
			    		
						recommended.add(st[i+1]);
						
			    	}
			    	break;
			    	
			    }
			     
			}
		for(String s : recommended)
		{
			System.out.println(s);
		}
		
		
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		return null;
		
	}
	
}
