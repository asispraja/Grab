package com.grab.backend;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.imageio.ImageIO;

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
		BufferedReader br = new BufferedReader(new FileReader("data/test/finalmoviedata.csv"));
		
		int myline=0;
		String line=null;
		String ftitle=null;
		String fname=null;
		String[] st = null;
		int i=0;
		 while((line = br.readLine()) != null) {
			 
           	myline++;
           	if(myline==1)
           		continue;
           	st=line.split(",");
           ftitle=st[6];
        
           fname = st[1];
           //System.out.println(ftitle);
           
			i++;
			try {
		String url =base+ftitle+"?api_key="+api+"&external_source=imdb_id";
		
		URL u = new URL(url);
		//System.out.println(u);
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
		
		URL file = new URL(image);
		BufferedImage img = ImageIO.read(file);
        BufferedImage thumb = new BufferedImage(127,183, BufferedImage.TYPE_INT_RGB);

        // BufferedImage has a Graphics2D
        Graphics2D g2d = (Graphics2D) thumb.getGraphics(); 
        g2d.drawImage(img, 0, 0, 
                     127,
                      183, 
                      0, 0, 
                      img.getWidth() ,
                      img.getHeight(), 
                      null);
       
        g2d.dispose();
        String newname=fname;
        ImageIO.write(thumb, "JPG", createOutputFile(new File("data/finalimage/"+newname)));
       
		/*try(InputStream in = new URL(image).openStream()){
		    Files.copy(in, Paths.get("data/images/thumb/thumbnail"+i+".jpg"));
		    }catch(Exception e)
		{
		    	e.printStackTrace();
		}*/
		}catch(Exception e){
			System.out.println("No Image Found ");
			continue;
		}
			}
			catch(Exception e)
			{
				System.out.println("Incorrect url Error");
			}
			
		}
		 System.out.println("Done");
		 br.close();
		
	}
	 private static File createOutputFile(File inputFile) {
	        
	        return new File(inputFile.getAbsolutePath()+".jpg" );
	    }
	}

	

	


