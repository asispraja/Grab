package com.grab.backend;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;


public class Hello {

    public static void main(String[] args) {
        int id[]={241,222,276,273,200,229,231,239,286};
        String user[]={"u1","u1","u2","u2","u3","u3","u3","u4","u4"};
        String item[]={"m1","m3","m1","m2","m1","m2","m3","m2","m3"};
        int rating[]={2,3,5,2,3,3,1,2,2};
        
        TreeSet<String> userNames=new TreeSet<>();
        TreeSet<String> itemNames=new TreeSet<>();
        
        Map< String,Map<String,Integer>> dataMap=new HashMap<>();
        
        for(int i=0;i<id.length;i++){
            String x=user[i],y=item[i];
            int rate=rating[i];
            userNames.add(x);
            itemNames.add(y);
            
            Map<String,Integer> map=dataMap.getOrDefault(x, new HashMap<>());
            map.put(y, rate);
            dataMap.put(x, map);
        }
        
        for(String itemName:itemNames){
            System.out.print("\t"+itemName);
        }
        System.out.println();
        for(String userName:userNames){
            System.out.print(userName);
            for(String itemName:itemNames){
                Map<String,Integer> map=dataMap.getOrDefault(userName, new HashMap<>());
                Integer rate=map.getOrDefault(itemName, -1);
                String str= ((int)rate==-1)? "?":String.valueOf(rate);
                System.out.print("\t"+str);
            }
            System.out.println("");
        }
        
        
    }
    
}

/*
package com.grab.backend;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Cosine {

	public static void main(String[] args) throws Exception {
		double rating;
		BufferedReader movie = new BufferedReader(new FileReader("data/test/ratings.txt"));
		List<String[]> lines = new ArrayList<String[]>();
		String thisLine;
		while ((thisLine = movie.readLine()) != null) {
		     lines.add(thisLine.split(" "));
		}
		
	
		
		
		int rows = lines.size();
		int cols = lines.get(0).length;
		String[][] array2D = new String[rows][cols];
		for(int row = 0; row < rows; row++) {
		    for(int col = 0; col < cols; col++) {
		        array2D[row][col] = lines.get(row)[col];
		    	System.out.print(lines.get(row)[col]+" ");
		    }
		    System.out.println();
		}
		ArrayList<String> m1 = new ArrayList<String>();
		ArrayList<String> m2 = new ArrayList<String>();
		ArrayList<String> m3 = new ArrayList<String>();
		ArrayList<ArrayList<String>> mov = new ArrayList<ArrayList<String>>(3);
		
		mov.add(0,m1);
		mov.add(1,m2);
		mov.add(2,m3);
		
		if (!mov.isEmpty()) {
		   
		for(int i=0;i<3;i++)
		{
			mov.get(0).add(array2D[i][0]);
			mov.get(1).add(array2D[i][1]);
			mov.get(2).add(array2D[i][2]);
		}
		double[][] cosine = new double[3][3];
		for(int i=0;i<3;i++)
		{
			
		for(int j=0;j<3;j++)
		{
			if(i==j)
				cosine[i][j]=1;
			else
				cosine[i][j]=getCosineValue(mov.get(i),mov.get(j));
			
		}
		
		}
		for(int i=0;i<3;i++)
		{
			
		for(int j=0;j<3;j++)
		{
			
			
			System.out.printf("%.2f  ",cosine[i][j]);
			
		}
		System.out.println();
		
		}
		BufferedWriter bw =new BufferedWriter(new FileWriter("data/test/cosine.txt"));
        for(int i=0;i<cols;i++)
        {
        	for(int j=0;j<cols;j++)
        	{
        		bw.append(cosine[i][j]+" ");
        	}
        	bw.append("\n");
        	bw.flush();
        	System.out.println();
        }
        bw.close();
		}
	}
	public static double getCosineValue(List<String> m1,List<String> m2)
	{
		double val=0,prod=0;
		double det=1;
		for(int i=0;i<m1.size();i++)
		{
			int mm2 = Integer.parseInt(m2.get(i));
			int mm = Integer.parseInt(m1.get(i));
			
			if(mm==-1 || mm2==-1)
				continue;
			else
			{
				
				prod=prod+mm*mm2;
				det=det*Math.sqrt(mm*mm+mm2*mm2);
				
				
			}
		}
		
		val=prod/det;
		val=Double.parseDouble(new DecimalFormat("##.###").format(val));
		return val;
		
	}
	
}
*/