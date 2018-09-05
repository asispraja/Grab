package com.grab.backend;
// I used to give content based similarity to the movies
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class ComputeContentSimilarity {
	public static BufferedReader br;
	public static BufferedWriter bw;
	public static void computeSimilarity()
	{
		try {
			
			 br= new BufferedReader(new FileReader("data/test/finalmoviedata.csv"));
			 bw= new BufferedWriter(new FileWriter("data/test/finalcosinecontent_similarity.csv"));
			 TreeSet<String> movieNames=new TreeSet<>();
		       
				 Map< String,Map<String,Double>> dataMap=new HashMap<>();
			 List<String[]> lines = new ArrayList<String[]>();
			String thisLine;
			int ml=0;
			while ((thisLine = br.readLine()) != null) {
				ml++;
				if(ml==1)
					continue;
			     lines.add(thisLine.split(","));
			    
			     
			}
			int rows = lines.size();
			int cols = lines.get(1).length;
			System.out.println("rows="+rows);
			System.out.println("cols="+cols);
			double[][] aray =new double[rows][rows];
			double r=0;
			for(int i=0;i<rows;i++)
			{

				 String x=lines.get(i)[0];
				  movieNames.add(x);
				for(int j=i;j<rows;j++)
				{
					try {
					if(i<j)
					{
						
						 r= calculateSimilarity(lines.get(i),lines.get(j));
						aray[i][j]=r;
						aray[j][i]=r;
					}
					
					else
						aray[i][j]=0;
					
						}catch (Exception e) {
							
							e.printStackTrace();
						}
					}
					
					
				}
			
			System.out.println("Done here");
			double[][] cosine = new double[rows][rows];
			for(int i=0;i<aray.length;i++)
			{
				
			for(int j=0;j<aray.length;j++)
			{
				
				if(i==j)
					cosine[i][j]=1;
				else if(i>j)
					cosine[i][j]=cosine[j][i];
				else
					cosine[i][j]=getCosineValue(aray[i],aray[j]);
				
			}
			}
			System.out.println("i m done");
			 for(String movieName:movieNames){
		           
		            bw.append(","+movieName);
				 	}
				       
			        bw.append("\n");
			        int i=0;
			        int j=0;
			        for(String movie: movieNames)
			        {
			        	j=0;
			        	bw.append(movie+",");
			        	for(String z: movieNames)
			        	{
			        		bw.append(cosine[i][j]+",");
			        		j++;
			        	}
			        	bw.append("\n");
			        	bw.flush();
			        	i++;
			        }
			        
		   
		        bw.close();
				
				
			}catch(Exception e)
						{
							//e.printStackTrace();
							
						}
System.out.println("Done");
	}
	
	
	
	public static double calculateSimilarity(String[] m1,String[] m2)
	{
		double sim=0;
		
		sim=sim+calcuateTitleSimilarity(m1[1],m2[1]);

		sim=sim+calcuateGenreSimilarity(m1[2],m2[2]);
		
		
		sim=sim+calcuateCountrySimilarity(m1[5],m2[5]);

		sim=sim+calcuateLanguageSimilarity(m1[3],m2[3]);
		
		sim=sim+calcuateDateSimilarity(m1[4],m2[4]);
		
		sim=Double.parseDouble(new DecimalFormat("##.###").format(sim));
		
		return sim;
	}
	
	
	
	
	
	
	
	public static double calcuateGenreSimilarity(String m1,String m2)
	{
		int gen=0;
		double sum=0;
		try {
		for(int i=1;i<17;i++)
		{
			if(m1.charAt(i)==m2.charAt(i))
			{
				gen++;
			}
		}
		sum=gen*0.1875;
		
		}
		catch(Exception e)
		{
			sum=0;
		}
		return sum;
	}
	
	
	
	
	public static double calcuateTitleSimilarity(String m1,String m2)
	{
		String[] st1=null,st2=null;
		double tit=0;
		//System.out.println(m1+""+m2);
		st1=m1.split(" ");
		st2=m2.split(" ");
		for(String x: st1)
		{
			for(String y: st2)
			{
				if(x.equals(y))
				{
					tit++;
				}
			}
		}
		int sum=st1.length+st2.length;
	
		try{tit=tit/(sum-tit)*2;}
		catch(Exception e)
		{
			tit=0;
		}
		return tit;
	}
	
	
	public static double calcuateCountrySimilarity(String m1,String m2)
	{
		String[] st1=null,st2=null;
		double cont=0;
		try{
		
	//	System.out.println(m1+""+m2);
		
		st1=m1.split("[+]");
		
		st2=m2.split("[+]");
		
		for(String x: st1)
		{
			for(String y: st2)
			{
				
				if(x.equals(y))
				{
					cont++;
				}
			}
		}
		int sum=st1.length+st2.length;
	//	System.out.println(sum);
		cont=cont/(sum-cont)*1;
		}
		catch(Exception e)
		{
			cont=0;
		}
	//	System.out.println("Cont="+cont);
		return cont;
	}
	public static int calcuateLanguageSimilarity(String m1,String m2)
	{
		
		if(m1.equals(m2))
		{
		return 1;	
		}
		else 
		return 0;
	}
	public static int calcuateDateSimilarity(String m1,String m2)
	{
		if(m1.equals(m2))
		{
			return 1;
		}
		else 
			return 0;
	}

	public static double getCosineValue(double[] m1,double[] m2)
	{
		double val=0,prod=0;
		double det0 = 1,det1=0,det2=0;
		for(int i=0;i<m1.length;i++)
		{
			double mm2 = m2[i];
			double mm = m1[i];
			if(mm==9 || mm2==9)
				continue;
			else
			{
				prod=prod+Math.abs(mm*mm2);
				det1=det1+mm*mm;
				det2=det2+mm2*mm2;
			}
		}
		det0 = Math.sqrt(det1*det2);
		try {
		val=prod/det0;
		val=Double.parseDouble(new DecimalFormat("##.###").format(val));
	
		}
		catch(Exception e){
			val=0;
		}
		return val;	
	}
	
	
	
public static void main(String[] args) {
		
		computeSimilarity();
	}
	
}
