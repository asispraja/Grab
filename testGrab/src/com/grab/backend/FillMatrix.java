package com.grab.backend;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

public class FillMatrix {

	public static void sortLargeNumbers(String arr[])
    {
        // Refer below post for understanding below expression:
        // https://www.geeksforgeeks.org/lambda-expressions-java-8/ 
        Arrays.sort(arr, (left, right) ->
        {
            /* If length of left != right, then return 
               the diff of the length else  use compareTo
               function to compare values.*/
            if (left.length() != right.length())
                return left.length() - right.length();
             return left.compareTo(right);
        });
    }
	public static void main(String[] args) {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("data/kaggle/ratings_opimized.csv"));
		
		int myline=0;
		String line=null;
		String[] st=null;
		String[] aray=new String[13421];
		String[] rating = new String[13421];
	
		 try {
			while((line = br.readLine()) != null) {
				
			       	myline++;
			       
			       	st=line.split(",");
			       	aray[myline]=st[1];
			       	rating[myline]=st[2];
			       	
			       	
			}
			String[] unique = new HashSet<String>(Arrays.asList(aray)).toArray(new String[0]);
			
			for(int i=0;i<1696;i++)
			{
				System.out.println(i+"   "+unique[i]);
			
			}
			
			
			for(int i=0;i<671;i++)
			{
				for(int j=0;j<1696;i++)
				{
				if(i==0)
					System.out.print(unique[j]+" ");
				else
					System.out.println(rating[j]);
				}
				System.out.println();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	         
	}

}
