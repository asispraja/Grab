package com.grab.backend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class checkSame {

	public static void main(String[] args) {
		
		/*List<String> lines = new ArrayList<String>();
		List<String> mylines = new ArrayList<String>();
		List<String> same = new ArrayList<String>();
		
		int count=0;
		try {
			BufferedReader br = new BufferedReader(new FileReader("data/test/ratingsszz.csv"));
			BufferedReader brs = new BufferedReader(new FileReader("data/test/ratingsszz.csv"));
			BufferedReader bs = new BufferedReader(new FileReader("data/test/new_movie_data.csv"));
			BufferedReader bss = new BufferedReader(new FileReader("data/test/new_movie_data.csv"));
			
			String thisLine,thatLine;
			Scanner scan = new Scanner(System.in);
			String[] st=null;
			while ((thisLine = br.readLine()) != null) {
				st = thisLine.split(",");
			    for(String s : st)
			    {
			    	lines.add(s);
			    }
			     break;
			}
			
			while ((thatLine = bs.readLine()) != null) {
				st = thatLine.split(",");
			     mylines.add(st[0]);
			     
			     
			}
			int cc=0,dd=0;
			for(String c: lines)
			{
				cc++;
				dd=0;
				//System.out.println("C:"+c);
				for(String d:  mylines)
				{
					dd++;
					//System.out.println("D:"+d);
					if(c.equals(d))
					{
						//System.out.println("C:"+c+"----"+"D:"+d);
						same.add(c);
						count++;
					}
				}
			}
			
			System.out.println(count+" ,"+cc+","+dd);
			
			  br.close();
		        bs.close();
		        bss.close();
			*/
		try {
		Map<String,Integer> dataCount=new HashMap<String,Integer>();
		List<String> same = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new FileReader("data/test/ratingsszz.csv"));
		String thisLine, thatLine;
		String[] st = null;
		while ((thisLine = br.readLine()) != null) {
		        st = thisLine.split(",");
		        for(int i=0;i<st.length;i++){
		            dataCount.put(st[i], 1);
		        }
		        
		        break;
		}
		

		BufferedReader bs = new BufferedReader(new FileReader("data/test/new_movie_data.csv"));

		while ((thatLine = bs.readLine()) != null) {
		        st = thatLine.split(",");
		                
		        dataCount.put(st[0],dataCount.getOrDefault(st[0], 0)+1);
		}

		int cc = 0, dd = 0;
		            
		            for(String key:dataCount.keySet()){
		                if(dataCount.get(key)>1){
		                    same.add(key);
		                }
		            }
		            System.out.println(same.size());
		BufferedWriter bw = new BufferedWriter(new FileWriter("data/test/finalsrating.csv"));
			//BufferedWriter bww = new BufferedWriter(new FileWriter("data/test/finalmoviedata.csv"));
			
			
			String lin=null;
			String[][] temp = new String[5344][5344];
			
			String[][]matric =new String[5000][22031]; 
			int i=0;
			while ((lin = br.readLine()) != null) {
				if(i==2500)
					break;
				st = lin.split(",");
				
			    for(int j=0;j<st.length;j++)
			    	{
			    	
			    		matric[i][j]=st[j];
			    		
			    		System.out.println(matric[i][0]);
			    		
			    		
			    	}
			    
			   // System.out.println();
			   
			    i++;
			}
			br.close();
		
					int l=0;
					int k=0;
					for( i=0;i<same.size();i++) {
						
						for(int j=0;j<matric[1].length;j++) {
							
							System.out.println(same.get(i));
							if(same.get(i).equals(matric[0][j])){
								
								for( k=0;k<matric.length;k++) {
									
									System.out.println(matric[k][j]);
									temp[k][l]=matric[k][j];
									
								}
								l++;
								break;
							}
							
						}
					}
					
					for( i=0;i<matric.length;i++) {
						bw.append(matric[i][0]+",");
						for(int j=0;j<l;j++) {
							System.out.print(temp[i][j]+" ");
							bw.append(temp[i][j]+",");
						}
						//System.out.println("");
						bw.append("\n");
						bw.flush();
					}
					
					/*
					i=0;
					String[][]matrix =new String[45468][7];
					String[][] temps = new String[5344][7];
					
					while ((lin = bss.readLine()) != null) {
						
						st = lin.split(",");
						
					    for(int j=0;j<7;j++)
					    	{
					    	try {
					    		matrix[i][j]=st[j];
					    		
					    		//System.out.println(st[j]);
					    	}catch(Exception e)
					    	{
					    		matrix[i][j]="undefined";
					    	}
					    		
					    	}
					    
					   // System.out.println();
					   
					    i++;
					}
					int m=0;
					
						for( l=0;l<5344;l++)
						{
							for( i=0;i<45468;i++) {
							if(same.get(l).equals(matrix[i][0])){
								
								for( k=0;k<7;k++) {
									
									
									temps[m][k]=matrix[i][k];
									
									System.out.println(temps[m][k]);
									System.out.println(m);
									
								}
								m++;
								break;
								
								
							}
						}
						
					}
					for( i=0;i<7;i++) {
						bww.append(matrix[0][i]+",");
					}
					bww.append("\n");
					bww.flush();
					for( i=0;i<5344;i++) {
						//bw.append(matrix[i][0]+",");
						for(int j=0;j<7;j++) {
							//System.out.print(temp[i][j]+" ");
							bww.append(temps[i][j]+",");
						}
						//System.out.println("");
						bww.append("\n");
						bww.flush();
					}
					*/
	        bw.close();
	      
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
