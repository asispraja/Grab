package com.grab.backend;
//2 Computes Pearson of userratings
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Pearson {

	public static void computePearson() throws Exception
	{
		double rating;
		BufferedReader movie = new BufferedReader(new FileReader("data/test/finalrating.csv"));
		BufferedWriter bw =new BufferedWriter(new FileWriter("data/test/finalItemPearson.csv"));
		
		List<String[]> lines = new ArrayList<String[]>();
		String thisLine;
		while ((thisLine = movie.readLine()) != null) {
			
		     lines.add(thisLine.split(","));
		}
		
		
		
		
		int rows = lines.size();
		int cols = lines.get(1).length;
		String[] movielist = new String[cols-1];
		String[][] array2D = new String[rows-1][cols-1];
		for(int row = 0; row < rows; row++) {
		    for(int col = 1; col < cols; col++) {
		    	if(row==0)
		    	{
		    		movielist[col-1]=lines.get(row)[col];
		    	}
		    	else
		    	{
		        array2D[row-1][col-1] = lines.get(row)[col];
		    	
		    	}
		    }
		   
		}
		
		
		cols=1000;
		ArrayList<ArrayList<String>> mov = new ArrayList<ArrayList<String>>(cols-1);

		for(int i=0;i<cols-1;i++)
		{
		mov.add(i,new ArrayList<String>());
		
		}
		 
		   
		for(int i=0;i<cols-1;i++)
		{
			for(int j=0;j<rows-1;j++)
			{
			mov.get(i).add(array2D[j][i]);
			
			}
			//System.out.println(mov.get(i)+"  ");
			
		}
		
		
		//Get Average user Ratings
		double avg[]= new double[lines.size()];
		for(int i=1;i<rows;i++)
		{
			double sum=0;
			int count=0;
			for(int j=1;j<cols;j++)
				{
					if(!lines.get(i)[j].equals("-1"))
					{
						count++;
						sum=sum+Double.parseDouble(lines.get(i)[j]);
					}
				}
			try {
			avg[i-1]=sum/count;
			}
			catch(Exception e)
			{
				avg[i]=0;
			}
			
		}
		
		
		
		double[][] cosine = new double[cols-1][cols-1];
		for(int i=0;i<cols-1;i++)
		{
			
		for(int j=0;j<cols-1;j++)
		{
			
			if(i==j)
				cosine[i][j]=1;
			else if(i>j)
				cosine[i][j]=cosine[j][i];
			else
				cosine[i][j]=getPersonCoeffecient(mov.get(i),mov.get(j),avg);
			
		}
		
		}
		for(int i=0;i<cols-1;i++)
		{
			//System.out.print(" "+movielist[i]);
			bw.append(","+movielist[i]);
		}
		//System.out.println();
		bw.append("\n");
		for(int i=0;i<cols-1;i++)
		{
			//System.out.print(movielist[i]+" ");
			bw.append(movielist[i]+",");
			
		for(int j=0;j<cols-1;j++)
		{
		//System.out.printf("%.2f   ",cosine[i][j]);
		bw.append(cosine[i][j]+",");
		bw.flush();
		}
		bw.append("\n");
		//System.out.println();
		
		}
		
        bw.close();
        System.out.println("DONE");
        
		
	}
	public static void main(String[] args) throws Exception {
		computePearson();
	}
	
	public static double getPersonCoeffecient(ArrayList<String> m1,ArrayList<String> m2,double[] avg)
	{
		double val=0,prod=0, det0 = 1;
		double det1=0,det2=0;
		for(int i=0;i<m1.size();i++)
		{
			double mm2 = Double.parseDouble(m2.get(i));
			double mm = Double.parseDouble(m1.get(i));
			if(mm==-1 || mm2==-1)
				continue;
			else
			{
				mm=mm-avg[i];
				mm2=mm2-avg[i];
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
}
