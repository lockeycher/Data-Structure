/* Student name: Lavinia Wang */

package assignment1;

import stdlib.StdIn;
import algs31.BinarySearchST;
import stdlib.StdAudio;

public class PlaySimpleChords {
	
	public static void playChord(double duration, double... frequencies) { // varargs is easier for arrays of same type
		final int sliceCount = (int) (StdAudio.SAMPLE_RATE * duration);
		final double[] slices = new double[sliceCount+1];
		for (int i = 0; i <= sliceCount; i++) {
			for (double frequency: frequencies) {
				slices[i] += Math.sin(2 * Math.PI * i * frequency / StdAudio.SAMPLE_RATE);
				}
			slices[i] /= frequencies.length;
			}
		StdAudio.play(slices);
	}
	
	
	 public static void main(String[] args) {

		 // declares and creates a symbol table
		 algs31.BinarySearchST<String, Double> TonesTable = new BinarySearchST<String, Double>();
		 
		 
		 // reads from file "notes_frequencies.txt"
		 StdIn.fromFile("data/notes_frequencies.txt");
		
		 while (StdIn.hasNextLine()) {
			 String line1 = StdIn.readLine();
			 String[] fields1 = line1.split("\\s+");
			 String musicalNote = fields1[0];
			 double pianoFrequency = Double.parseDouble(fields1[1]);
			 TonesTable.put(musicalNote, pianoFrequency);	
		 }
		 
		 
		 // reads from file "sample_simple_chords.txt"
		 StdIn.fromFile("data/sample_simple_chords.txt");

		 while (StdIn.hasNextLine()) {
			 String line2 = StdIn.readLine();
			 String[] fields2 = line2.split("\\s+");
			 String noteName1 = fields2[0];
			 String noteName2 = fields2[1];
			 double duration = Double.parseDouble(fields2[2]);	
			 double frequency1 = TonesTable.get(noteName1);
			 double frequency2 = TonesTable.get(noteName2);
			 PlaySimpleChords.playChord(duration, frequency1, frequency2);
		 }
		 
	}
}
