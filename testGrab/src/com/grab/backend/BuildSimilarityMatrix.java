package com.grab.backend;
//1 Converts user ratings file into m X m rating matrix
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class BuildSimilarityMatrix {
	public static void buildSimilarityMatrix() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("data/test/ratings.csv"));
			BufferedWriter bw =new BufferedWriter(new FileWriter("data/test/ratingsszz.csv"));
			TreeSet<String> userNames=new TreeSet<>();
	        TreeSet<String> itemNames=new TreeSet<>();
	        String userlist,movielist;
	        double ratinglist;
	        Map< String,Map<String,Double>> dataMap=new HashMap<>();
			try {
				List<String[]> lines = new ArrayList<String[]>();
				String[] st=null;
				String thisLine;
				int my=0;
				while ((thisLine = br.readLine()) != null) {
					my++;
					if(my>1500000)
						break;
					if(my==1)
						continue;
				     lines.add(thisLine.split(","));
				     st= thisLine.split(",");
				     userlist=st[0];
				     movielist = st[1];
				     ratinglist = Double.parseDouble(st[2]);
				
				
			
				/*String[][] array = new String[lines.size()][0];
				lines.toArray(array);*/
				/*
				int rows = lines.size();
				int cols = lines.get(0).length;
				String[][] array2D = new String[rows][cols];
				for(int row = 0; row < rows; row++) {
				    for(int col = 0; col < cols; col++) {
				        array2D[row][col] = lines.get(row)[col];
				    	//System.out.print(lines.get(row)[col]+" ");
				    }
				}
				
				String[] userlist=new String[rows];
				String[] movielist=new String[rows];
				double[] ratingslist=new double[rows];
				for(int i=0;i<rows;i++)
				{
					userlist[i]=array2D[i][0];
					movielist[i]=array2D[i][1];
					ratingslist[i]=Double.parseDouble(array2D[i][2]);
					//System.out.print(userlist[i]);
				}
//				String[] uniqueuser = new HashSet<String>(Arrays.asList(userlist)).toArray(new String[0]);
//				String[] uniquemovie = new HashSet<String>(Arrays.asList(movielist)).toArray(new String[0]);
				
		        
		        for(int i=0;i<userlist.length-1;i++){
		            String x=userlist[i];
		            String y=movielist[i];
		            double rate=ratingslist[i];
		           */ 
		            userNames.add(userlist);
		            itemNames.add(movielist);
		            
		            Map<String,Double> map=dataMap.getOrDefault(userlist, new HashMap<>());
		            map.put(movielist, ratinglist);
		            dataMap.put(userlist, map);
		        }
		       String[] usermat=new String[userNames.size()];
		       String[][] ratingmat = new String[userNames.size()][itemNames.size()];
		        for(String itemName:itemNames){
		           // System.out.print("\t"+itemName);
		            bw.append(","+itemName);
		        }
		       // System.out.println();
		        bw.append("\n");
		        int i=0,j=0;
		       for(String userName:userNames){
		    	  usermat[i]=userName;
		    	   j=0;
		            //System.out.print(userName);
		            
		            for(String itemName:itemNames){
		            	
		                Map<String,Double> map=dataMap.getOrDefault(userName, new HashMap<>());
		                Double rate=map.getOrDefault(itemName, -1.0);
		                String str= ((double)rate==-1)? "-1":String.valueOf(rate);
		                //System.out.print("\t"+str);
		                ratingmat[i][j]=str;
		                j++;
		            }
		          //  System.out.println("");
		           
		            i++;
		        }
		      
		       
		        for(i=0;i<userNames.size();i++)
		        {
		        	bw.append(usermat[i]+",");
		        	for( j=0;j<itemNames.size();j++)
		        	{
		        		bw.append(ratingmat[i][j]+",");
		        	}
		        	bw.append("\n");
		        	bw.flush();
		        	//System.out.println();
		        }
		        bw.close();
				
		        System.out.println("Done");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("hi");
		}
	}
public static void main(String[] args)
{
	buildSimilarityMatrix();
	
}
}
