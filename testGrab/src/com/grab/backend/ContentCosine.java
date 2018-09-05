package com.grab.backend;
//III Compute Cosine of the m X m similarity matrix
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ContentCosine {
public static void computeCosine() throws Exception
{
	double rating;
	BufferedReader movie = new BufferedReader(new FileReader("data/test/content_matrix.csv"));
	BufferedWriter bw =new BufferedWriter(new FileWriter("data/test/content_cosine.csv"));
	
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
	/*double avg[]= new double[lines.size()];
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
		System.out.println(avg[i-1]);
		}
		catch(Exception e)
		{
			avg[i]=0;
		}
		
	}
	*/
	
	//Get Cosine Value
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
			cosine[i][j]=getCosineValue(mov.get(i),mov.get(j));
		
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
	
	public static double getCosineValue(ArrayList<String> m1,ArrayList<String> m2)
	{
		double val=0,prod=0;
		double det0 = 1;
		double det1=0,det2=0;
		
		//System.out.println("size="+m1.size());
		for(int i=0;i<m1.size();i++)
		{
			double mm2 = Double.parseDouble(m2.get(i));
			double mm = Double.parseDouble(m1.get(i));
			//System.out.println(mm+"  "+mm2);
			
			if(mm==9 || mm2==9)
				continue;
			else
			{
				//System.out.println("average = "+i+ avg[i]);
				
				//Comment following 2 lines to get cosine similarity
				//mm=mm-avg[i];
				//mm2=mm2-avg[i];
				prod=prod+Math.abs(mm*mm2);
				//System.out.println(mm+"  "+mm2);
				//det=det*Math.sqrt(mm*mm+mm2*mm2);
				det1=det1+mm*mm;
				det2=det2+mm2*mm2;
				//System.out.println(prod+"  "+det1+"  "+det2);
			}
		}
	
		det0 = Math.sqrt(det1*det2);
		
		
		try {
		val=prod/det0;
		val=Double.parseDouble(new DecimalFormat("##.###").format(val));
	//	System.out.println(val);
		}
		catch(Exception e){
			val=0;
		}
		return val;
		
	}
	public static void main(String[] args) throws Exception {
		computeCosine();
		}
	
}


