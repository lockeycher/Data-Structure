/* Student name: Lavinia Wang */

package finalexam;

import algs13.Queue;
import algs41.Graph;
import stdlib.*;

public class BFSTrace {
	
	
	public static void bfsPrintTrace(Graph g) {
		
		boolean[] marked = new boolean[g.V()];
		Queue<Integer> q = new Queue<>();
		int s = 0;
		marked[s] = true;
		q.enqueue(s);
		StdOut.println("Enqueued " + s + ".");

		while (!q.isEmpty()) {
			int v = q.dequeue();
			StdOut.println("Dequeued " + v + ".");
			for (int w : g.adj(v)) {
				if (!marked[w]) {
					marked[w] = true;
					q.enqueue(w);
					StdOut.println("Enqueued " + w + ".");
				}
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		In input = new In("data/tinyG.txt");
		Graph g = new Graph(input);

		bfsPrintTrace(g);
	}

}
