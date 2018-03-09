package algs15.perc;

import algs15.UF;
import algs15.WeightedUF;

//import com.sun.glass.ui.Size;

//import stdlib.*;
//import algs15.*;

// Uncomment the import statements above.

// You can test this using InteractivePercolationVisualizer and PercolationVisualizer
// All methods should make at most a constant number of calls to the UF data structure,
// except percolates(), which may make up to N calls to the UF data structure.
public class Percolation {
	int N;
	boolean[] open;
	// TODO: more fields to add here
	private UF uf;
	
	/* 
	 * Declare a UF data structure
	 * Creates N-by-N grid, with all sites blocked.
	 */
	public Percolation(int N) {
		this.N = N;
		this.open = new boolean[N*N];
		// TODO: more to do here
		this.uf = new WeightedUF(N*N + 2);
	    for(int i = 0; i < N*N; i++) {
	    	this.open[i] = false; 
	     }
	}
	// open site (row i, column j) if it is not already
	public void open(int i, int j) {
		open[i*N+j] = true;
		//connect to all open neighbors
		// TODO: more to do here.
		int position = ((i*N + j) + 1);
			
		if (i == 0) {
			uf.union(0, position);	//connecting with source	
		}
		
		if (i > 0) { 
			if (isOpen(i-1, j)) {
				uf.union(position, position - N);	//connecting with its top grid
			}
		}
		       
		if (i == (N -1)) {
			uf.union(N*N + 1, position);	//connecting with sink			
		}
		
		if (i < N-1) { 
			if (isOpen(i+1, j)) {
				uf.union(position, position + N); 	//connecting with its bottom grid
		    }
		} 
		       
		if (j > 0 && isOpen(i, j-1)) { 
			uf.union(position, position - 1);	//connecting with left grid
		}
		       
		if (j < N-1 && isOpen(i, j+1)) { 
			uf.union(position, position + 1);	//connecting with right grid
		}
	}
		
	// is site (row i, column j) open?
	public boolean isOpen(int i, int j) {
		return open[i*N+j];
	}
	// is site (row i, column j) full?
	public boolean isFull(int i, int j) {
		// TODO
		return uf.connected(0, i*N+j+1);
	}
	// does the system percolate?
	public boolean percolates() {
		// TODO
		return uf.connected(0, N*N + 1);
	}
}