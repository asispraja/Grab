package com.grab.backend;
// II Convert content similarity to m X m movie similarity matrix
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

public class BuildContentSimilarity {
	public static void buildSimilarityMatrix()
	{
		try {
			BufferedReader br = new BufferedReader(new FileReader("data/test/content_similarity.csv"));
			BufferedWriter bw =new BufferedWriter(new FileWriter("data/test/contentz_matrix.csv"));
			
				
				TreeSet<String> movieNames=new TreeSet<>();
		        TreeSet<String> itemNames=new TreeSet<>();
			try {
				 String movielist=null;
				 String movie1list=null;
				 double ratinglist;
				List<String[]> lines = new ArrayList<String[]>();
				String[] st=null;
				String thisLine;
				int my=0;
				 Map< String,Map<String,Double>> dataMap=new HashMap<>();
				while ((thisLine = br.readLine()) != null) {
					my++;
					if(my>1500000)
						break;
					if(my==1)
						continue;
				     lines.add(thisLine.split(","));
				     st= thisLine.split(",");
				movielist=st[0];
				movie1list=st[1];
				ratinglist=Double.parseDouble(st[2]);
		       
		        String x=movielist;
		            String y= movie1list;
		            double rate= ratinglist;
		            
		            movieNames.add(x);
		            itemNames.add(y);
		            
		            Map<String,Double> map=dataMap.getOrDefault(x, new HashMap<>());
		            map.put(y, rate);
		            dataMap.put(x, map);
		        }
		       String[] moviemat=new String[movieNames.size()];
		       String[][] ratingmat = new String[movieNames.size()][itemNames.size()];
		        for(String itemName:itemNames){
		           // System.out.print("\t"+itemName);
		            bw.append(","+itemName);
		        }
		        //System.out.println();
		        bw.append("\n");
		        int i=0,j=0;
		       for(String movieName:movieNames){
		    	  moviemat[i]=movieName;
		    	   j=0;
		          //  System.out.print(userName);
		            
		            for(String itemName:itemNames){
		            	
		            	 Map<String,Double> map=dataMap.getOrDefault(movieName, new HashMap<>());
		                Double rate=map.getOrDefault(itemName, 9.0);
		                String str= ((double)rate==-1)? "-1":String.valueOf(rate);
		              //  System.out.print("\t"+str);
		                ratingmat[i][j]=str;
		                j++;
		            }
		            //System.out.println("");
		           
		            i++;
		        }
		      
		       
		        for(i=0;i<movieNames.size();i++)
		        {
		        	bw.append(moviemat[i]+",");
		        	for( j=0;j<itemNames.size();j++)
		        	{
		        		bw.append(ratingmat[i][j]+",");
		        		bw.flush();
		        	}
		        	bw.append("\n");
		        	
		        	//System.out.println();
		        }
		        bw.close();
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			br.close();
			bw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	System.out.println("Done");
	}
	
public static void main(String[] args)
{
	buildSimilarityMatrix();
}
}