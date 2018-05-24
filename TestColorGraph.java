/* Student name: Lavinia Wang */

package assignment7;

import algs41.*;
import stdlib.*;

public class TestColorGraph {

	public static void main(String[] args) {
		
		String[] graphFilenames = {"data/evencycle.txt", "data/star.txt","data/oddcycle.txt","data/k7.txt" };
		
		for(String graphFilename:graphFilenames) {
			Graph G = new Graph(new In(graphFilename));
			ColorGraph cg = new ColorGraph(G);
			Color[] colors = cg.colors();
			StdOut.println("Vertex colors for " + graphFilename);
			for (int v = 0; v < G.V(); v++) {
				StdOut.println(v + ": " + colors[v]);
			}
		}
	}
}
