/* Student name: Lavinia Wang */

package assignment2;

import stdlib.StdIn;
import stdlib.StdOut;
import stdlib.Stopwatch;
import java.util.Formatter;

import algs31.*;
import algs32.*;

public class TimeSymbolTables {
	 
	public static void main(String[] args) {
		
		SequentialSearchST<String, Integer> wordCounts1 = new SequentialSearchST<String, Integer>();
		BST<String, Integer> wordCounts2 = new BST<String, Integer>();
		
		String header = "Symbol Table Type";
		String SequentialSearchSTTimes = "Sequential";
		String BSTTimes = "Binary";
		
		// reads file to fill in the symbol tables 
		StdIn.fromFile("data/tale.txt");
		
		String[] words = StdIn.readAllStrings();
		
		// tracks how long it takes to fill the SequentialSearchST
		Formatter format = new Formatter();
		Stopwatch timer = new Stopwatch();
		
		for (String word: words) {
			if (wordCounts1.get(word) == null) {
					// A null entry in an ST means that no value is stored for that key.
					wordCounts1.put(word, 1);
				} else {
					wordCounts1.put(word, wordCounts1.get(word)+1);
				}
		}
		SequentialSearchSTTimes += format.format("%8.4f", timer.elapsedTime()).toString();
		
		
		// tracks how long it takes to fill the BST
		format = new Formatter();
		timer = new Stopwatch();
		
		for (String word: words) {
			if (wordCounts2.get(word) == null) {
					// A null entry in an ST means that no value is stored for that key.
					wordCounts2.put(word, 1);
				} else {
					wordCounts2.put(word, wordCounts2.get(word)+1);
				}
		}
		BSTTimes += format.format("%8.4f", timer.elapsedTime()).toString();
		
		StdOut.println(header);
		StdOut.println("--------");
		StdOut.println(SequentialSearchSTTimes);
		StdOut.println(BSTTimes);
	}
}
