package com.grab.backend;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Search {
	
	
	public static int minDistance(String word1, String word2) {
		int len1 = word1.length();
		int len2 = word2.length();
		int[][] dp = new int[len1 + 1][len2 + 1];
		for (int i = 0; i <= len1; i++) {
			dp[i][0] = i;
		}
		for (int j = 0; j <= len2; j++) {
			dp[0][j] = j;
		}
		for (int i = 0; i < len1; i++) {
			char c1 = word1.charAt(i);
			for (int j = 0; j < len2; j++) {
				char c2 = word2.charAt(j);
				if (c1 == c2) {	
					dp[i + 1][j + 1] = dp[i][j];
				} else {
					int replace = dp[i][j] + 1;
					int insert = dp[i][j + 1] + 1;
					int delete = dp[i + 1][j] + 1;
	 
					int min = replace > insert ? insert : replace;
					min = delete > min ? min : delete;
					dp[i + 1][j + 1] = min;
				}
			}
		}
		return dp[len1][len2];
	}
	
public static void main(String[] args)
{
	Scanner scan  = new Scanner(System.in);
	String search = scan.nextLine();
	String thisLine=null;
	String st[] = null;
	List<String> lines = new ArrayList<String>();
	try {
		BufferedReader br = new BufferedReader(new FileReader("data/test/finalmoviedata.csv"));
		int ml=0;
		while ((thisLine = br.readLine()) != null) {
			ml++;
			if(ml==1)
				continue;
		     st=thisLine.split(",");
		     lines.add(st[1]);
		     
		}
		int distance= 0;
		
		for(String s: lines)
		{
			String ss[] = s.split(" ");
			
			for(String a: ss)
			{
				distance=minDistance(a,search);
			if(distance<=0.4*a.length())
				{
				System.out.println(s);
				
				break;
				}
			}
		}
		br.close();
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
