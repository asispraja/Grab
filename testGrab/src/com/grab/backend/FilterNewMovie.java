package com.grab.backend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FilterNewMovie {

	public static void main(String[] args) {
		BufferedReader br;
		BufferedWriter bw;
			try {
				br = new BufferedReader(new FileReader("data/kaggle/ratings_small.csv"));
			
					bw = new BufferedWriter(new FileWriter("data/kaggle/ratings_opimized.csv"));
				
				
			
		
		int myline=0;
		String line=null;
		String[] st=null;
		boolean found=false;
		int count=0;
		
		
			try {
				int i=1;
				while((line = br.readLine()) != null) {
					
				       	myline++;
				       	if(myline==1)
				       		continue;
				       	st=line.split(",");
				       	
				       	
				      
				       		if(i==Integer.parseInt(st[0]))
				       		{
				       			count++;
				       			bw.append(st[0]+","+st[1]+","+st[2]);
			       				bw.append("\n");
			       				bw.flush();
			       				System.out.println(count);

				       			if(count==20)
				       			{
				       				count=0;
				       				i++;
				       			}
				       		}
				       	
				       	
				       	
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			
			} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}

	}

}
