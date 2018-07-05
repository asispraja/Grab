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

import javax.imageio.ImageIO;

public class ResizeThumbnail {
int i=0;
			    public ResizeThumbnail() {
			    }

			    public void run(String folder) {
			        File dir = new File(folder);
			        for (File file : dir.listFiles()) {
			            createThumbnail(file);
			        }
			    }
			    public String getthumbname(File file) {
			    	String line=null;
					String ss=null;
					String[] st=null;
					String x;
					int myline=0;
			    	try {
						BufferedReader movie = new BufferedReader(new FileReader("data/mylists.csv"));
						
						ss=file.toString();
					 	ss=ss.substring(17);
					 	ss=ss.replace(".jpg","");
						 try {
							while((line = movie.readLine()) != null) {
								 	myline++;
								 	st=line.split(",");
								 	if(ss==st[1])
								 		{
								 			ss=st[0];
								 			break;
								 		} 		
							 }
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return ss;
			    	
			    }
			    private void createThumbnail(File file) {
			    	
			        try {
			        	BufferedWriter bw = new BufferedWriter(new FileWriter("data/final.csv"));
			        	i++;
			            // BufferedImage is the best (Toolkit images are less flexible)
			            BufferedImage img = ImageIO.read(file);
			            BufferedImage thumb = new BufferedImage(127,183, BufferedImage.TYPE_INT_RGB);

			            // BufferedImage has a Graphics2D
			            Graphics2D g2d = (Graphics2D) thumb.getGraphics(); 
			        /*    g2d.drawImage(img, 0, 0, 
			                         127,
			                          183, 
			                          0, 0, 
			                          img.getWidth() ,
			                          img.getHeight(), 
			                          null);
			           */
			            g2d.dispose();
			            String newname=getthumbname(file);
			            
			            //ImageIO.write(thumb, "JPG", createOutputFile(new File("data/ima/mythumb"+newname)));
			            bw.append(i+","+newname);
			            bw.append("\n");
			            bw.flush();
			            
			        } catch (Exception e) {
			            e.printStackTrace();
			        }
			       
			    }

			    private File createOutputFile(File inputFile) {
			        // You'll want something better than this...
			        return new File(inputFile.getAbsolutePath()+".jpg" );
			    }

			   
			    public static void main(String[] args) {
			    	ResizeThumbnail fac = new ResizeThumbnail();
			        fac.run("data/images");
			    }
			}
		