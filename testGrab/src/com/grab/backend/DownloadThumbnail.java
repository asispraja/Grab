package com.grab.backend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



public class DownloadThumbnail {

	public static void main(String[] args) throws MalformedURLException, IOException {
		String api="214972a7241e2391596658f6c1b0b71e";
		String baseurl="http://image.tmdb.org/t/p/w150";
		String originalimage="http://image.tmdb.org/t/p/original";
		String base="https://api.themoviedb.org/3/find/";
		String movieid="";
		BufferedReader br = new BufferedReader(new FileReader("data/linkfile.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("data/usablelink.txt"));
		int myline=0;
		String line=null;
		String ftitle=null;
		int i=0;
		 while((line = br.readLine()) != null) {
			 
           	myline++;
         
           
           	if(line.length()<20)
           	{
           		System.out.println("invalid title");
           		continue;
           	}
           	else
           	{
           		ftitle=line.substring(26, 35);
           		System.out.println(ftitle);
           		
           	}
           
			i++;
		String url ="https://api.themoviedb.org/3/find/"+ftitle+"?api_key=214972a7241e2391596658f6c1b0b71e&external_source=imdb_id";
		URL u = new URL(url);
		 Scanner scan = new Scanner(u.openStream());
		    String str = new String();
		    while (scan.hasNext())
		        str += scan.nextLine();
		    scan.close();
		try {
		JSONObject obj = new JSONObject(str);
		JSONArray ar1 = obj.getJSONArray("movie_results");
		JSONObject obj2 = ar1.getJSONObject(0);
		String imageurl=obj2.getString("poster_path");
		
		String image=originalimage+imageurl;
		//System.out.println(image);
		bw.append(line);
   		bw.append("\n");
		bw.flush();
		
		
		/*try(InputStream in = new URL(image).openStream()){
		    Files.copy(in, Paths.get("data/images/thumb/thumbnail"+i+".jpg"));
		    }catch(Exception e)
		{
		    	e.printStackTrace();
		}*/
		}catch(JSONException e){
			System.out.println("No Image Found ");
			continue;
		}
		}
		 System.out.println("Done");
		 br.close();
		 bw.close();
	}
	}

	

	


