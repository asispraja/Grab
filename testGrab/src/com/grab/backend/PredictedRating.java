package com.grab.backend;
// 3 Predicts user ratings for unrated movie using Pearson
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class PredictedRating {
	public static void predict() throws Exception
	{
		double rating;
		BufferedReader movie = new BufferedReader(new FileReader("data/test/finalItemPearson.csv"));
		BufferedReader user = new BufferedReader(new FileReader("data/test/finalrating.csv"));
		List<String[]> lines = new ArrayList<String[]>();
		String thisLine;
		while ((thisLine = movie.readLine()) != null) {
		     lines.add(thisLine.split(","));
		}
		String line=null;
		List<String[]> usline = new ArrayList<String[]>();
		
		
		while ((line = user.readLine()) != null) {
		     usline.add(line.split(","));
		    
		    
		}
		
	/*	String[][] array = new String[lines.size()][0];
		lines.toArray(array);*/
		
		
		
		
		int rows = lines.size();
		int cols = lines.get(0).length;
		String[] movielist = new String[cols-1];
		
		
		    for(int col = 1; col < cols; col++) {
		    	
		    		movielist[col-1]=lines.get(0)[col];
		    	}
		    	
		    	
		    
		   // System.out.println();
		
		ArrayList<String> m1 = new ArrayList<String>();
		BufferedWriter bw =new BufferedWriter(new FileWriter("data/test/finalItemPearsonPredictedRating.csv"));
		
		int turn=usline.size();

		for(int i=0;i<cols-1;i++)
		{
			bw.append(","+movielist[i]);
			
		}
		bw.append("\n");
	
		
		
		double prod=0;
		double sum=0;
		double val=0;
		for(int i=1;i<turn;i++)
		{
			for(int j=0;j<cols;j++)
				{
					val=0;
					prod=0;
					sum=0;
					if(usline.get(i)[j].equals("-1"))
					{
						for(int k=1;k<cols;k++)
						{
							if(!usline.get(i)[k].equals("-1"))
							{
							 prod=prod+Double.parseDouble(usline.get(i)[k])*Double.parseDouble(lines.get(j)[k]);
							 sum=sum+Double.parseDouble(lines.get(j)[k]);
							}
						}
						try {
						val=prod/sum;
						val=Double.parseDouble(new DecimalFormat("##.###").format(val));
						}catch(Exception e)
						{
							val=0;
						}
						bw.append(val+",");
						bw.flush();
					}
					else
					{
						
						//System.out.println(usline.get(i)[j]+",");
						bw.append(usline.get(i)[j]+",");
						bw.flush();
					}
					
					
				}
				bw.append("\n");
				//System.out.println();
				bw.flush();
					
				}
		
		System.out.println("Done");
	bw.close();
	
	}
	
	public static void main(String[] args) throws Exception {
		
		predict();
	}
	

}
