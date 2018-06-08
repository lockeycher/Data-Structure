/* Student name: Lavinia Wang */

package finalexam;

import algs41.Graph;
import stdlib.In;
import stdlib.StdOut;

public class DFSTrace {
	
	/* ***************************************************************************
	 *  What is the pattern formed by the "First visit" and "Finished" messages?
	 * "First visit" and "Finished" has the same indent value.
	 * ***************************************************************************
	 */
	
	public static void dfsPrintTrace(Graph g) {
	    // *** Declare and initialize the marked array.
		boolean[] marked = new boolean[g.V()];
		dfsPrintTrace(g, 0, marked, 0);
	}
	
	/* All references to a method below refer to this second method. 
	 * Every message printed should be preceded by the number of spaces specified by the indent parameter. 
	 * A recursive call should pass an indent value with 1 added.
	 */
	private static void dfsPrintTrace(Graph g, int start, boolean[] marked, int indent) {
		/* The first time the method visits a vertex, 
		 * it should print the message "First time at vertex n", 
		 * where n is the integer label of the vertex.
		 */
		if (!marked[start]) {
			StdOut.println(printSpace(indent) + "First visit to " + start +".");
		}
		marked[start] = true;
		indent ++;
		
		/* Every other time it visits a vertex, 
		 * it should print the message "Visiting vertex n again".
		 */
		for (int w : g.adj(start)) {
			if (!marked[w]) {
				dfsPrintTrace(g, w, marked, indent);
			}
			else {
				StdOut.println(printSpace(indent) + "Visited " + w + " again.");
			}
		}
		
		/* When it exits, it should print the message "Finished searching from n". */
		indent--;
		StdOut.println(printSpace(indent) + "Finished with " + start + ".");

		
	}
	
	private static String printSpace (int s) {
		String space = "";
		for (int i = 0; i < s; i++) {
			space = space.concat(" ");
		}
		return space;
		
	}

	// test client
	public static void main(String[] args) {
		In input = new In("data/tinyG.txt");
		Graph g = new Graph(input);

		dfsPrintTrace(g);
	}

}
