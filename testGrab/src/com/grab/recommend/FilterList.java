package com.grab.recommend;

	import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

	public class FilterList {
		
		public FilterList()
		{
			
		}
		
		public static void main(String[] args) 
		{
			String file= "data/movie_metadata.csv";
			
			BufferedReader br = null;
			BufferedWriter moviefile=null;
			BufferedWriter actor1file=null;
			BufferedWriter actor2file=null;
			BufferedWriter yearfile=null;
			BufferedWriter languagefile=null;
			BufferedWriter genrefile=null;
			BufferedWriter countryfile=null;

			BufferedWriter linkfile=null;
			
			String line=null;
			String[] st = null;
			String[] actor1=new String[5044];
			String[] actor2=new String[5044];
			String[] film=new String[5044];
			String[] year=new String[5044];
			String[] language=new String[5044];
			String[] genres =new String[5044];
			String[] country =new String[5044];
			String[] link=new String[5044]; 
			int myline=0;
			 try {

		            br = new BufferedReader(new FileReader(file));
			
		            while((line = br.readLine()) != null) {
		            	
		            	st=line.split(",");
		            	 film[myline]=st[0];
		            	 genres[myline]=st[1];
		            	 actor1[myline]=st[2];
		            	 actor2[myline]=st[3];
		            	 year[myline]=st[4];
		            	 country[myline]=st[5];
		            	 link[myline]=st[6];
		            	myline++;
		                
		            }   
		            moviefile = new BufferedWriter(new FileWriter("data/moviefile.txt"));
		            actor1file = new BufferedWriter(new FileWriter("data/actor1file.txt"));
		            actor2file = new BufferedWriter(new FileWriter("data/actor2file.txt"));
		            yearfile = new BufferedWriter(new FileWriter("data/yearfile.txt"));
		           // languagefile = new BufferedWriter(new FileWriter("data/languagefile.txt"));
		            countryfile = new BufferedWriter(new FileWriter("data/countryfile.txt"));
		            genrefile = new BufferedWriter(new FileWriter("data/genrefile.txt"));
		            linkfile = new BufferedWriter(new FileWriter("data/linkfile.txt"));
		          
		            moviefile.write(film[0]);
		        	   genrefile.write(genres[0]);
		        	   actor1file.write(actor1[0]);
		        	   actor2file.write(actor2[0]);
		        	   yearfile.write(year[0]);
		        	   countryfile.write(country[0]);
		        	   linkfile.write(link[0]); 
		           for(int i=1;i<myline;i++)
		           {
		        	   System.out.println("Count="+i);
		        	   moviefile.append("\n");
		        	   moviefile.append(film[i]);
		        	   genrefile.append("\n");
		        	   genrefile.append(genres[i]);
		        	   actor1file.append("\n");
		        	   actor1file.append(actor1[i]);
		        	   actor2file.append("\n");
		        	   actor2file.append(actor2[i]);
		        	   yearfile.append("\n");
		        	   yearfile.append(year[i]);
		        	   countryfile.append("\n");
		        	   countryfile.append(country[i]);
		        	   linkfile.append("\n");
		        	   linkfile.append(link[i]); 
		        	   
		        	  
		        	  /* System.out.println("FilmName = "+film[i]);
		        	   System.out.println("Genre = "+genres[i]);
		        	   System.out.println("Actor = "+actor1[i]);
		        	   System.out.println("Actor 2 = "+actor2[i]);
		        	   System.out.println("Year = "+year[i]);
		        	   System.out.println("Country = "+country[i]);
		        	   System.out.println("Link = "+link[i]);*/
		        	   
		        	   System.out.println("");
		        	   
		           }
		         

		            // Always close files.
		             
				System.out.println();
			}
		catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}


	}