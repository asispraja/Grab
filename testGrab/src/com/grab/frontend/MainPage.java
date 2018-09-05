package com.grab.frontend;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MainPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtSearch;
	private static String username="100";
	
	//private Map watched=null;
	private Map<Integer,Double> recommended,rec = null;
	Map<Integer,String > movie = new LinkedHashMap<Integer,String>();
	private List<Integer> userRec=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
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
	public MainPage() {
		loadMovie();
		setUser(username);
	loadUser();
	draw();	
	}
	public void loadMovie()
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
			 		continue;
			 	movie.put(Integer.parseInt(st[0]), st[1]);
			}
			int count=0;
			Iterator<Integer> itr = movie.keySet().iterator();
			
			
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
	public String getMName(Integer id)
	{
		String st= movie.getOrDefault(id,"not available");
		return st;
	}
		private void loadUser() {
		try {
			recommended = new LinkedHashMap<Integer,Double>();
			userRec = new ArrayList<Integer>();
			rec = new LinkedHashMap<Integer,Double>();
			BufferedReader br = new BufferedReader(new FileReader("data/test/ItemPearsonPredictedRating.csv"));
			String line=null;
			String[] st=null;
			int i=1;
			List<String> mv = new ArrayList<String>();
			int myline=0;
			
			while((line=br.readLine())!=null)
			{
				i=1;
				
				st=line.split(",");
				while(myline==0)
				{
					mv.add(st[i]);
					i++;
					if(i==st.length-2)
						break;
				}
				
				myline++;
				if(username.equals(st[0]))
				{
					while(true)
					{
					recommended.put(Integer.parseInt(mv.get(i-1)),Double.parseDouble( st[i]));
					rec= sortByValue(recommended);
					i++;
					if(i==st.length-2)
						break;
					}
					int j=0;
					 for(Integer key:rec.keySet())
					 {
						userRec.add(key);
						
					 j++;
					 
					 if (j>10) 
					 break;
				}
				}
				else
					continue;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		private static Map<Integer, Double> sortByValue(Map<Integer, Double> unsortMap) {

	        // 1. Convert Map to List of Map
	        List<Map.Entry<Integer,Double>> list =
	                new LinkedList<Map.Entry<Integer,Double>>(unsortMap.entrySet());

	        // 2. Sort list with Collections.sort(), provide a custom Comparator
	        //    Try switch the o1 o2 position for a different order
	        Collections.sort(list, new Comparator<Map.Entry<Integer,Double>>() {
	            public int compare(Map.Entry<Integer,Double> o1,
	                               Map.Entry<Integer,Double> o2) {
	                return (o1.getValue()).compareTo(o2.getValue());
	            }
	        });
	        
	        Collections.reverse(list);
	        // 3. Loop the sorted list and put it into a new insertion order Map LinkedHashMap
	        Map<Integer, Double> sortedMap = new LinkedHashMap<Integer, Double>();
	        for (Map.Entry<Integer,Double> entry : list) {
	            sortedMap.put(entry.getKey(), entry.getValue());
	        }

	        return sortedMap;
	    }
		public void draw()
		{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHiUser = new JLabel("Hi "+username);
		lblHiUser.setBounds(1265, 28, 46, 14);
		contentPane.add(lblHiUser);
		
		JLabel lblTopTrending = new JLabel("Top Trending");
		lblTopTrending.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTopTrending.setBounds(394, 353, 238, 14);
		contentPane.add(lblTopTrending);
		
		JLabel label_6 = new JLabel("");
		//System.out.println(getName(userRec.get(0)+""));
		//label_6.setIcon(new ImageIcon("data/kkimage/"+userRec.get(0)+".jpg"));
		label_6.setBounds(394, 109, 127, 183);
		contentPane.add(label_6);
		
		JLabel[] recom = new JLabel[6];
		int recomX=394;
		int recomY=109;
		int m=0;
		for(Integer ss: userRec)
		{
			if(m==10)
				break;
		recom[m]= new JLabel();
		System.out.println(getMName(ss));
		recom[m].setIcon(new ImageIcon("data/kkimage/"+getMName(ss)+".jpg"));
		recom[m].setBounds(recomX, recomY, 127, 183);
		contentPane.add(recom[m]);
		m++;
		recomX+=150;
		}
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon("data/finalimage/"+getMName(100017)+".jpg"));
		System.out.println(getMName(100017));
		label_8.setBounds(394, 378, 127, 183);
		contentPane.add(label_8);
		
		JLabel lblRecommendedForYou = new JLabel("Recommended For You");
		lblRecommendedForYou.setBounds(394, 84, 238, 14);
		lblRecommendedForYou.setFont(new Font("Tahoma", Font.BOLD, 11));
		contentPane.add(lblRecommendedForYou);
		
		textField = new JTextField();
		textField.setBounds(394, 22, 674, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		txtSearch = new JTextField();
		txtSearch.setBounds(1065, 22, 70, 27);
		txtSearch.setHorizontalAlignment(SwingConstants.CENTER);
		txtSearch.setText("Search");
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
		lblNewLabel.setBounds(38, 117, 276, 44);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JLabel lblPopular = new JLabel("AI Recommendation");
		lblPopular.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				RecommendationPage.main(null);
				dispose();
			}
		});
		lblPopular.setBounds(38, 227, 324, 44);
		lblPopular.setHorizontalAlignment(SwingConstants.CENTER);
		lblPopular.setForeground(Color.WHITE);
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
		label.setBounds(10, 0, 1355, 730);
		label.setIcon(new ImageIcon("res/image/homepage123.png"));
		contentPane.add(label);
		
	}

	public static void setUser(String x) {
		username=x;
		// TODO Auto-generated method stub
		
	}
}
