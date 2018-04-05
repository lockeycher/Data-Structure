/* Student name: Lavinia Wang */

package assignment1;

import stdlib.StdIn;
import algs31.BinarySearchST;

public class ComputeARR {

	public static void main(String[] args) {
		
		// creates a symbol table and fills it with names and ratings.
		String[] stars = { "********", "*******",  "******", "*****", "****",  "***", "**", "*" };
        double[] ratings =  { 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.5 };
        
        algs31.BinarySearchST<String, Double> starRatings = new BinarySearchST<String, Double>();
        for (int i = 0; i < stars.length; i++) {
            starRatings.put(stars[i], ratings[i]);
        }
        
        
        // reads star ratings from file "a1ratings.txt", computes and prints the average rating.
        StdIn.fromFile("data/a1ratings.txt");
        String[] starLists = StdIn.readAllStrings();
        double sum = 0.0;
      
        for (String starList: starLists) {
			double starRating = starRatings.get(starList);
			sum += starRating;
		}
        
        double averageRating = sum / starLists.length;
        System.out.println("The average rating is: " + averageRating + ".");
	}

}