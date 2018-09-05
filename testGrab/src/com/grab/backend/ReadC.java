package com.grab.backend;
// Was Used to import useful information from given Content related data
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

public class ReadC {

	public static void main(String[] args) {
		String oldfile="data/test/movies_metadata.csv";
		BufferedReader br;
		BufferedWriter bw;
		String newfile="data/test/new_movie_data.csv";
		final int q=45468;
		try {
			 br = new BufferedReader(new FileReader(oldfile));
		//	BufferedReader br = new BufferedReader(new FileReader("data/test/"));
			
			bw = new BufferedWriter(new FileWriter(newfile));
			int myline=0;
			String line=null;
			String[] st=null;
			String[] id=new String[q];
			String[] film=new String[q];
			String[] year=new String[q];
			String[] language=new String[q];
			String[] genres =new String[q];
			String[] genn = new String[q];
			String[] country =new String[q];
			//String[] actor1 =new String[q];
			 while((line = br.readLine()) != null) {
	            	try {
				 st= line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				 id[myline]=st[0];
				 film[myline]=st[1];
            	 genres[myline]=st[2];
            	 genres[myline]=genres[myline].substring(1,genres[myline].length()-1);
            	 language[myline]=st[3];
            	 year[myline]=st[4].substring(6);
            	 country[myline]=st[5];
            	 country[myline]=country[myline].substring(1,country[myline].length()-1);
	            	}
	            	catch(Exception e)
	            	{
	            		
	            	}
            	 
            	 myline++;
			 }
			 //FOR GENRE
			int[] genre = new int[16];
			
			 for(int i=1;i<q;i++)
			 {
				 genn[i]="";
				 try {
					 int x=0;
			 JSONArray arr1= new JSONArray(genres[i]);
			String gen="";
			for(int j=0;j<16;j++)
			{
				genre[j]=0;
				
			}
			
			for(Object index: arr1)
			{
			 JSONObject obj1 = arr1.getJSONObject(x);
			  gen = obj1.getString("name");
			  switch(gen)
			  {
			  case "Action":
				  genre[0]++;
				  break;
			  case "Animation":
				  genre[1]++;
				  break;
			  case "Comedy":
				  genre[2]++;
				  break;
			  case "Family":
				  genre[3]++;
				  break;
			  case "Adventure":
				  genre[4]++;
				  break;
			  case "Fantasy":
				  genre[5]++;
				  break;
			  case "Romance":
				  genre[6]++;
				  break;
			  case "Drama":
				  genre[7]++;
				  break;
			  case "Thriller":
				  genre[8]++;
				  break;
			  case "Horror":
				  genre[9]++;
				  break;
			  case "History":
				  genre[10]++;
				  break;
			  case "Crime":
				  genre[11]++;
				  break;
			  case "Science Fiction":
				  genre[12]++;
				  break;
			  case "Documentary":
				  genre[13]++;
				  break;
			  case "War":
				  genre[14]++;
				  break;
			  default:
				  genre[15]++;
				  break;
			  }
			 
			 x++;
			}
			genn[i]="X";
			for(int j=0;j<16;j++)
			{
				//System.out.print(genre[j]);
				
				genn[i]=genn[i]+genre[j];
			}
			genn[i]=genn[i]+"X";
				
			
			//System.out.println();
			// System.out.println(gen);
			
			//genres[i]=gen;
				 }catch(Exception e)
				 {
					// e.printStackTrace();
					// System.out.println("hi"+genres[i]);
					// genres[i]=null;
					 genn[i]="null";
				 }
			 }
			 //FOR ACTOR INCOMPLETE
			/* for(int i=1;i<100;i++)
			 {
				 try {
					 int x=0;	
			 JSONArray arr1= new JSONArray(actor1[i]);
			 String act="";
			 for(Object index: arr1)
				{
			 JSONObject obj1 = arr1.getJSONObject(x);
			   act =act+"+"+obj1.getString("name");

			 x++;
				}
			 System.out.println(act);
			actor1[i]=act;
				 }catch(Exception e)
				 {
					 e.printStackTrace();
					 System.out.println(actor1[i]);
				 }
			 }*/
			 //For Country
			 for(int i=1;i<q;i++)
			 {
				 try {
					 int x=0;	
			 JSONArray arr1= new JSONArray(country[i]);
			 String act="";
			 for(Object index: arr1)
				{
			 JSONObject obj1 = arr1.getJSONObject(x);
			   act =obj1.getString("name")+"+"+act;

			 x++;
				}
			// System.out.println(act);
			 country[i]=act;
				 }catch(Exception e)
				 {
					 //e.printStackTrace();
					 country[i]="null";
					
				 }
				 if(country[i].length()>=1)
				country[i]=country[i].substring(0,country[i].length()-1);
				
			 }
			 
			 for(int i=0;i<q;i++)
			 {
				 bw.append(id[i]+","+film[i]+","+genn[i]+","+language[i]+","+year[i]+","+country[i]);
				 bw.append("\n");
				 bw.flush();
				//System.out.println(id[i]+" "+film[i]+" "+genn[i]+" "+language[i]+" "+year[i]+" "+country[i]);
			 }
			 
			br.close();
			bw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
System.out.println("Done");
	}

}
