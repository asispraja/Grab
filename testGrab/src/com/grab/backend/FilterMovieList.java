package com.grab.backend;

import java.io.*;

public class FilterMovieList {

	public static void main(String[] args) throws IOException {
		/*BufferedReader br = new BufferedReader(new FileReader("data/usablelink.txt"));
		BufferedReader movie = new BufferedReader(new FileReader("data/movie_metadata.csv"));
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("data/movie_data.csv"));
		String line=null;
		String list=null;
		String[] st=null;
		int myline=0;
		 while((line = br.readLine()) != null) {
			 	myline++;
			 	while(true)
			 	{
	         list=movie.readLine();
	        
	         st=list.split(",");
	         if(line.equals(st[7]))
	         {	
	        	 System.out.println(list);
	        	 bw.append(list);
	        	 bw.append("\n");
	        	 bw.flush();
	        	 break;
	         }
	       
	         
		 }
		 }
		 bw.close();
		 br.close();
		 movie.close();
		
		
		
		
*/
		
		/*BufferedWriter bw = new BufferedWriter(new FileWriter("data/mylist.csv"));
		
		try
        {
        // This method will rename all files in a folder by chaning ReplaceFrom string with ReplaceWith string
		int i=0;
			File dir = new File("data/images");
	        for (File file : dir.listFiles()) {
	         i++;
	        	bw.append(i+","+file.toString());
	        	bw.append("\n");
	        	bw.flush();
	        }
	        System.out.println("Done");
     
	}catch(Exception e)
		{
		e.printStackTrace();
		System.out.println("Error");
		}*/
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("data/mylists.csv"));
		BufferedReader br = new BufferedReader(new FileReader("data/mylist.csv"));
		int myline=0;
		String line=null;
		String[] st=null;
		String[] number=new String[4677];
		String[] actor=null;
		int[] mynumber=new int[4677];
		 while((line = br.readLine()) != null) {
			 	myline++;
			 	st=line.split(",");
			 	number[myline]=st[1].substring(17);
			 	number[myline]=number[myline].replace(".jpg", "");
			 	actor[myline]=line;
			 	//System.out.println("HI"+number[myline]);
		 }
		 int temp=0;
		 for(int i=1;i<4677;i++)
		 {
			 try {
			 mynumber[i]=Integer.parseInt(number[i]);
			// System.out.println("Bye"+number[i]);
			 }
			 catch(Exception e)
			 {
				// System.out.println("NONO"+number[i]);
			 }
				 
		 }
		 int temps=0;
		 for(int i=1;i<4676;i++)
		 {
			 temps=i;
			 for(int j=i+1;j<4677;j++)
			 {
				 if(mynumber[j]<mynumber[temps])
					 temps=j;
				 
					 temp=mynumber[i];
					 mynumber[i]=mynumber[temps];
					 mynumber[temps]=temp;
				 
			 }
		 }
		 for(int i=1;i<100;i++)
		 {
			 temps=i;
			 for(int j=i+1;j<100;j++)
			 {
				 if(mynumber[j]<mynumber[temps])
					 temps=j;
				 
					 temp=mynumber[i];
					 mynumber[i]=mynumber[temps];
					 mynumber[temps]=temp;
				 
			 }
		 }
		 for(int i=1;i<4677;i++)
		 {
			bw.append(i+","+mynumber[i]);
			bw.append("\n");
			bw.flush();
		 }
		br.close();
		bw.close();
		}
		

}
