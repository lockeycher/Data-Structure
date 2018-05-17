/* Student name: Lavinia Wang */

package assignment6;

import stdlib.*;
import algs31.BinarySearchST;
import algs41.BreadthFirstPaths;
import algs41.Graph;

public class ShortestDistances {
	
	public static void main(String[] args) {
		
		/* Reads in the list of cities and builds a symbol table 
		 * where the key is the name of a city and 
		 * the value is an integer from 0 to the number of cities minus one. 
		 */
		StdIn.fromFile("data/a6cities.txt");
		
		BinarySearchST<String, Integer> cities = new BinarySearchST<String, Integer>();
		
		int n = 0;
		while (!StdIn.isEmpty()) {
			String[] names = StdIn.readAllStrings();
			for (int i = 0; i < names.length; i++) {
				cities.put(names[i], i);	
				}
			n = names.length;
			}
		//System.out.println(cities.height());
		
		
		/* Creates an empty undirected graph using the class algs41.Graph. 
		 * In this graph, each vertex represents a city.
		 */
		Graph cityGraph = new Graph(n);

		
		/* Reads in each connection from the second data file, one line at a time. 
		 * As it reads in each line, it adds an edge to the graph. 
		 * It will have to translate from the cities given on each connection line 
		 * to their corresponding vertex numbers.
		 */
		StdIn.fromFile("data/a6connections.txt");
		
		while (StdIn.hasNextLine()) {
			 String line = StdIn.readLine();
			 String[] fields = line.split("\\s+");
			 String cityName = fields[0];
			 String cityConnection = fields[1];
			 int city = cities.get(cityName);
			 int connect = cities.get(cityConnection);
			 cityGraph.addEdge(city, connect);	 
		}
		
		/* Creates a algs41.BreadthFirstPaths object from the graph 
		 * just constructed and with Chicago as the starting point.
		 */
		int chicago = cities.get("Chicago");
		BreadthFirstPaths chi = new BreadthFirstPaths(cityGraph, chicago);
		
		
		/* Using the BFS object, prints a two-dimensional table 
		 * listing the shortest distances (by way of Chicago) 
		 * between each pair of cities in the following list:
		 * Chicago
		 * KansasCity
		 * Minneapolis
		 * Wausau
		 * LaCrosse
		 */
		String[] toPrint = {"Chicago", "KansasCity", "Minneapolis", "Wausau", "LaCrosse"};
		for(String header: toPrint) {
			StdOut.print("\t\t" + header + " ");
		}
		StdOut.println();
		for(String row : toPrint) {
			StdOut.printf("%-15s\t", row);
			for(String col: toPrint) {
				int route = chi.distTo(cities.get(row)) + chi.distTo(cities.get(col));
				StdOut.printf("%-17d\t", route);
			}
			StdOut.println();
		}
		
		
	}
}
