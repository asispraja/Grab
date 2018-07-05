package com.grab.backend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ItemItemSimilar {

	public static void main(String[] args) {
		String oldfile="data/movie_metadata.csv";
		String newfile="data/movie_similarity.csv";
		String line=null;
		String[] st=null;
		String[] actor1=new String[5044];
		String[] actor2=new String[5044];
		String[] film=new String[5044];
		String[] year=new String[5044];
		//String[] language=new String[5044];
		String[] genres =new String[5044];
		String[] country =new String[5044];
		String[] link=new String[5044];
		int[] mid=new int[5044];
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
	            	 actor2[myline]=st[4];
	            	 year[myline]=st[5];
	            	 country[myline]=st[6];
	            	 link[myline]=st[7];
	            	
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
						 similarity=100;
						break;
						
					 }
					 else
					 {
						if(actor1[i].equals(actor1[j]))
						{
							similarity+=20;
						}
						if(actor2[i].equals(actor2[j]))
						{
							similarity+=10;
						}
						if(country[i].equals(country[j]))
						{
							similarity+=10;
						}
						if(year[i].equals(year[j]))
						{
							similarity+=15;
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

}
