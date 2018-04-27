/* Student name: Lavinia Wang */

package assignment4;

import java.util.ArrayList;

import stdlib.*;

public class A4TestGeneticSequences {
	
	public static void main (String[] args) {
		
		// Creates an A4GeneticSequences object
		A4GeneticSequences a4Sequences = new A4GeneticSequences();
		
		/* Reads in data from a file called "data/sequences.txt", 
		 * in which each line contains a species name, a tab character, and a genetic sequence. 
		 * As it reads each line of the input file, 
		 * it adds that species and sequence to the genetic sequence object. */
		StdIn.fromFile("data/sequences.txt");
		
		while (StdIn.hasNextLine()) {
			 String line = StdIn.readLine();
			 String[] fields = line.split("\\s+");
			 String speciesName = fields[0] + " " + fields[1];
			 String geneticSequence = fields[2];
			 a4Sequences.addSpecies(speciesName, geneticSequence);
			 //StdOut.println(speciesName + ": " + geneticSequence);
		}
		
		// Prints the number of species in the object
		int speciesNum1 = a4Sequences.size();
		StdOut.println("Currently there are " + speciesNum1 + " species in the collection.");
		
		/* Prints an alphabetized list of all of the species and, 
		 * for each, the first 20 characters of its genetic sequence */
		ArrayList<String> list = a4Sequences.speciesList();
		
		for (String speciesList : list) {
			String shortSequence = a4Sequences.sequence(speciesList).substring(0,20);
			StdOut.println("Species name is: " + speciesList + "\n" + "Its genetic sequence is(display in 20 characters): " + shortSequence);
		}
		
		// Deletes every species in the object
		for (String speciesList : list) {
			a4Sequences.removeSpecies(speciesList);
		}
		
		// Prints the number of species in the object
		int speciesNum2 = a4Sequences.size();
		StdOut.println("After deletion there are " + speciesNum2 + " species in the collection.");
	}
	

}
