package com.grab.backend;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.TanimotoCoefficientSimilarity;
//import org.apache.mahout.cf.taste.impl.similarity.TanimotoCoefficientSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;

public class ItemRecommend {

	public static void main(String[] args) throws IOException {
		 BufferedWriter bw = new BufferedWriter(new FileWriter("data/similarity_rankings.csv"));
		try {
			DataModel dm = new FileDataModel(new File("data/movie_similarity.csv"));
			
			ItemSimilarity sim = new LogLikelihoodSimilarity(dm);
			//TanimotoCoefficientSimilarity sim = new TanimotoCoefficientSimilarity(dm);
			
			GenericItemBasedRecommender recommender = new GenericItemBasedRecommender(dm, sim);
			
			
			for(LongPrimitiveIterator items = dm.getItemIDs(); items.hasNext();) {
				long itemId = items.nextLong();
				String myitem,myrecom,myval;
				List<RecommendedItem>recommendations = recommender.mostSimilarItems(itemId, 10);
				
				for(RecommendedItem recommendation : recommendations) {
					myitem=itemId+"";
					myrecom=recommendation.getItemID()+"";
					myval=recommendation.getValue()+"";
						
					bw.append(myitem+","+myrecom+","+myval);
					bw.append("\n");
					bw.flush();
				System.out.println(itemId + "," + recommendation.getItemID() + "," + recommendation.getValue());
				}
				
			}
						
			
			bw.close();
		} catch (IOException e) {
			System.out.println("There was an error.");
			e.printStackTrace();
		} catch (TasteException e) {
			System.out.println("There was a Taste Exception");
			e.printStackTrace();
		}
		

	}

}