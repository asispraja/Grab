package com.grab.backend;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class FindMovie {

	public static void main(String[] args) {
		
		BufferedReader br;
		BufferedWriter bw;
		try {
			br = new BufferedReader(new FileReader("data/kaggle/posterr.csv"));
			bw = new BufferedWriter(new FileWriter("data/kaggle/successful.csv"));
		
		int myline=0;
		String filmimage=null;
		String image=null;
		String line=null;
		String[] st=null;
		 try {
			while((line = br.readLine()) != null) {
				 
			       	myline++;
			       	st=line.split(",");
			       	filmimage=st[1];
			       	System.out.println(filmimage);
			       	if(myline==10)
			       		break;
			
			image="http://image.tmdb.org/t/p/original"+filmimage;
			
			URL url = new URL(image);
			BufferedImage images = ImageIO.read(url);
			 BufferedImage thumb = new BufferedImage(127,183, BufferedImage.TYPE_INT_RGB);
			 Graphics2D g2d = (Graphics2D) thumb.getGraphics(); 
	            g2d.drawImage(images, 0, 0, 
	                         127,
	                          183, 
	                          0, 0, 
	                          images.getWidth() ,
	                          images.getHeight(), 
	                          null);
	           
	            g2d.dispose();
	            String newname="thumbnail"+myline+".jpg";
	            ImageIO.write(thumb, "JPG", new File("data/newimages/"+newname));
	            bw.append(myline+","+newname);
	            bw.append("\n");
	            bw.flush();
			}
			

		 } catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

}
