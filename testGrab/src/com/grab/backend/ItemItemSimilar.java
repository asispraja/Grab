package com.grab.backend;
// Unused Class
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ItemItemSimilar {

	public static void itemSimilarity()
	{
		String oldfile="data/test/movie_data.csv";
		String newfile="data/test/movies_similarity.csv";
		String line=null;
		String[] st=null;
		String[] actor1=new String[100];
		
		String[] film=new String[100];
		String[] year=new String[100];
		String[] language=new String[5044];
		String[] genres =new String[100];
		String[] country =new String[100];
		
		int[] mid=new int[100];
		String[] gen =null;
		String[] jen =null;
		long similarity=0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(oldfile));
			BufferedWriter bw = new BufferedWriter(new FileWriter(newfile));
			int myline=0;
			 while((line = br.readLine()) != null) {
	            	
	            	st=line.split(",");
	            	mid[myline]=Integer.parseInt(st[0]);
	            	 film[myline]=st[1];
	            	 genres[myline]=st[1];
	            	 actor1[myline]=st[3];
	            	 language[myline]=st[4];
	            	 year[myline]=st[5].substring(7);
	            	 country[myline]=st[6];
	            	
	            	
	            	myline++;
	            	if(myline>100)
	            		break;
	            	
	            	}
			 
			// bw.write("movie1 , movie2 , similarity ");
			 for(int i=1;i<myline;i++)
			 {
				 
				 for(int j=1;j<myline;j++)
				 {
					 similarity=0;
					 if(i==j)
					 {
						 similarity=1;
						break;
						
					 }
					 else
					 {
						if(actor1[i].equals(actor1[j]))
						{
							similarity+=1;
						}
						if(year[i].equals(year[j]))
						{
							similarity+=1;
						}
					 }
					 
					 bw.append(mid[i]+","+mid[j]+","+similarity);
					 bw.append("\n");
					 
				 }
				
			 }
			 br.close();
			 bw.close();
			 System.out.println("Done");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	public static void main(String[] args) {
		itemSimilarity();
	}
	public int getGenre()
	{
		return 0;
		
	}
	public int getTitle()
	{
		return 0;
		
	}
	public int getCountry()
	{
		return 0;
		
	}
	public int getYear()
	{
		return 0;
		
	}
	public int getActor()
	{
		return 0;
		
	}

}
