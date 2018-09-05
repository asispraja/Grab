package com.grab.backend;
// Display movie under Content Cosine rank
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ShowRecommendation {
	public static  List<Integer> showRecommendation()
	{
		Scanner scan = new Scanner(System.in);
		String s=scan.nextLine();
		Map<Integer,Double> ss= new LinkedHashMap<Integer,Double>();
		List<Integer> result = new ArrayList<Integer>();
		ss=	getRecommendations(s);
		 Map<Integer, Double> sortedMap = sortByValue(ss);
		
		 while (sortedMap.values().remove(1.0));
		 sortedMap.remove(Integer.parseInt(s));
		 int i=0;
		 for(Integer key:sortedMap.keySet())
		 {
			 System.out.println(key );
			
			result.add(key);
		 i++;
		 
		 if (i>10) 
		 break;
	}
		 return result;
		
		//System.out.println(sortedMap.values());
	}
	// will try to complete this code soon
	   /* public static <K, V extends Comparable<? super V>> Map<K, V> sortValue(Map<K, V> map) {
	        List<Entry<K, V>> list = new ArrayList<>(map.entrySet());
	        list.sort(Entry.comparingByValue());

	        Map<K, V> result = new LinkedHashMap<>();
	        for (Entry<K, V> entry : list) {
	            result.put(entry.getKey(), entry.getValue());
	        }

	        return result;
	    }
	}*/
	private static Map<Integer, Double> sortByValue(Map<Integer, Double> unsortMap) {

        // 1. Convert Map to List of Map
        List<Map.Entry<Integer,Double>> list =
                new LinkedList<Map.Entry<Integer,Double>>(unsortMap.entrySet());

        // 2. Sort list with Collections.sort(), provide a custom Comparator
        //    Try switch the o1 o2 position for a different order
        Collections.sort(list, new Comparator<Map.Entry<Integer,Double>>() {
            public int compare(Map.Entry<Integer,Double> o1,
                               Map.Entry<Integer,Double> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        
        Collections.reverse(list);
        // 3. Loop the sorted list and put it into a new insertion order Map LinkedHashMap
        Map<Integer, Double> sortedMap = new LinkedHashMap<Integer, Double>();
        for (Map.Entry<Integer,Double> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
	
	public static void main(String[] args) {
		 showRecommendation();
	}
	public static Map<Integer,Double> getRecommendations(String selected)
	{
		Map<Integer,Double> recommended= new HashMap<Integer,Double>();
		String line;
		String st[] = null;
		String movie[] = new String[5343];
		int myline=0;
		System.out.println("Recommendations for :"+selected);
		try {
			BufferedReader bf = new BufferedReader (new FileReader("data/test/finalcosinecontent_similarity.csv"));
			
			
			while ((line = bf.readLine()) != null) {
			    st=line.split(",");
			    
		    		
		    	 if(myline==0)
				   {
		    		 for(int i=0;i<st.length-1;i++)
				    	{
					   movie[i]=st[i];
				    	}
					
		    	}
		    	
			   // System.out.println( st[0]+" "+selected);
			    if(st[0].equals(selected))
			    {
			    	//System.out.println("hi");
			    	//System.out.println(st.length);
			    	for(int i=1;i<st.length-1;i++)
			    	{
			    		
						recommended.put(Integer.parseInt(movie[i]),Double.parseDouble(st[i]));
						
			    	}
			    	break;
			    	
			    }
			    myline++;
			}
			
			//System.out.println(recommended.size());
	//Prints the score 
		/*for(String s : recommended)
		{
			System.out.println(s);
		}*/
		
		
			
			bf.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO aaa
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return recommended;
		
	}
}
