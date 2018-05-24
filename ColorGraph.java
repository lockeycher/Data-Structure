/* Student name: Lavinia Wang */

package assignment7;

import java.util.ArrayList;
import algs13.Queue;
import algs41.Graph;
import stdlib.*;

public class ColorGraph {
	
	/* The class will have two instance variables, 
	 * both arrays, one to hold the color assigned to each vertex 
	 * and one used to mark a vertex as visited. 
	 */
	private final boolean[] marked; 
	private Color[] colors;
	
	
	/* This constructor initializes the color and marked arrays. 
	 * By default, every entry in the color array will be null 
	 * and every entry in the marked array will be false. 
	 * The constructor then calls the method bfsColor.
	 */
	public ColorGraph(Graph G) {
		marked = new boolean[G.V()];
		colors = new Color[G.V()];
		bfsColor(G, 0);
	}
	
	
	/* When a vertex is marked, the method assigns a color to the vertex. 
	 * To find a color, it needs to choose a color not currently used by any of its neighbors. 
	 * It then makes the correct entry in the color array equal to that color.
	 */
	private void bfsColor(Graph G, int s) {
		Queue<Integer> q = new Queue<>();
		
		// Available colors to choose
		Color[] listOfColors = Color.values();
		
		// A temporary array list to store the colors have been assigned
		ArrayList<Color> colorUsed = new ArrayList<>(); 
		ArrayList<Color> colorNbrUsed = new ArrayList<>();
		
		// Assign the first color to the first vertex
		colors[s] = listOfColors[0];
		
		// Mark the first vertex 
		marked[s] = true;
		q.enqueue(s);
		
		while (!q.isEmpty()) {
			int v = q.dequeue();
			colorUsed.add(colors[v]);
			colorNbrUsed.add(colors[v]);
			StdOut.println("v is: " + v +" and color is: " + colors[v]);
			
			// Assign colors to the current vertex neighbor
			for (int w : G.adj(v)) {
				if (!marked[w]) {
					for (Color color: listOfColors) {
						if(!colorUsed.contains(color)) { // check if the color has been used
							//StdOut.println("the array list does NOT contain " + color);
							colors[w] = color;
							//StdOut.println(" neighbor color is " + color);
							break;
						}
					}
					marked[w] = true;
					q.enqueue(w);
					
				} else { // check if the neighbor of new marked vertex has the same color
					for (int x : G.adj(w)) {
						if (colors[w] == colors[x]) {
							colorNbrUsed.add(colors[w]);
							for (Color color: listOfColors) {
								if(!colorNbrUsed.contains(color)) { // check if the color has been used
									colors[w] = color;
									break;
								}
							}
						}
					}	
				}	
			}
			colorUsed.clear();
			colorNbrUsed.clear();
		}
	}
				
	
	/* This returns the array of colors assigned to G's vertices. */
	public Color[] colors() {
		return colors;
	}

}
