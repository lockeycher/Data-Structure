/* Student name: Lavinia Wang */

package assignment4;

import stdlib.*;

import java.util.ArrayList;

import algs33.RedBlackBST;


public class A4GeneticSequences {
		
	RedBlackBST<String, String> geneticSequences = new RedBlackBST<String, String>();
	
	// adds a species and its sequence to the collection
	public void addSpecies(String species, String sequence) {
		geneticSequences.put(species, sequence);
	}
	
	// removes the given species and its sequence from the collection
	public void removeSpecies(String species) {
		geneticSequences.delete(species);
	}
	
	// returns a sorted array list of the species names in the collection
	public ArrayList<String> speciesList() {
		ArrayList<String> al = new ArrayList<String>();
		for (String key : geneticSequences.keys() ) {
			al.add(key);
		}
		return al;
		}
	
	/* returns the sequence associated with the species passed as a parameter; 
	 * it returns null if that species is not in the collection */
	public String sequence(String species) {
		return geneticSequences.get(species);
		}
	
	// returns the number of species currently in the collection
	public int size() {
		return geneticSequences.size();
	}

}


