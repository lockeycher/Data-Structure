/* Student name: Lavinia Wang */

package assignment2;

import stdlib.StdIn;
import stdlib.StdOut;


public class FileMaxMin {
	
	public static void main (String[] args) {
		
		// reads from file "100ints.txt"
		StdIn.fromFile("data/100ints.txt");
		
		String[] fields = StdIn.readAllStrings();
		int[] vals = new int[fields.length];
		for (int i = 0; i < fields.length; i++) {
			vals[i] = Integer.parseInt(fields[i]);
			}
		     
		int min = vals[0];
		int max = vals[0];
		for (int i = 0; i < vals.length; i++) {
			if (vals[i] <= min) {
				min = vals[i];
			} if (vals[i] > max) {
				max = vals[i];
			}
		}
		System.out.println("The maximum number is " + max +" " + "and the minimum number is " + min + ".");
	}
}
