/* Student name: Lavinia Wang */

package assignment8;

import algs31.BinarySearchST;
import algs42.BreadthFirstDirectedPaths;
import algs42.Digraph;
import stdlib.*;
import week8examples.SimplerDirectedCycle;

public class IndependentCourses {
	
	public static void main(String[] args) {
		
		/* Reads from file "a8courses.txt"
		 * Builds a symbol table to link a course name to a vertex number in the digraph.
		 */
		StdIn.fromFile("data/a8courses.txt");
		
		BinarySearchST<String, Integer> courses = new BinarySearchST<String, Integer>();
		
		int n = 0;
		while (!StdIn.isEmpty()) {
			String[] courseNames = StdIn.readAllStrings();
			StdOut.println("Listing all the courses:");
//			for (String courseName: courseNames) {
//				StdOut.println(courseName);
//			}
			for (int i = 0; i < courseNames.length; i++) {
				courses.put(courseNames[i], i);	
				StdOut.println(courseNames[i] + " vertex: " + i);
			}
			n = courseNames.length;
		}
		
		/* Read from file "a8prereqs.txt"
		 * Builds a digraph representing the prerequisite structure of this set of courses.
		 */
		Digraph dg = new Digraph(n);
		
		StdIn.fromFile("data/a8prereqs.txt");
		
		while (StdIn.hasNextLine()) {
			 String line = StdIn.readLine();
			 String[] fields = line.split("\\s+");
			 String prereq = fields[0];
			 String next = fields[1];
			 int prereqNo = courses.get(prereq);
			 int nextNo = courses.get(next);
			 dg.addEdge(prereqNo, nextNo);	 
		}
		
		/* Check whether it's a DAG 
		 * If not, print a message that it's not and terminate the program.
		 */
		SimplerDirectedCycle dagCheck = new SimplerDirectedCycle(dg);
		if (dagCheck.hasCycle()) {
			StdOut.println("The graph is not a DAG.");
			return;
		} else { // It is a DAG
			StdOut.println("The graph is a DAG and has no cycle.");
		
		
			/* Reads from file "a8independence.txt"
			 * Determines for each pair whether they're independent
			 * Print out a report listing all of the courses, 
			 * followed by each of the course pairs in the third file 
			 * and a message as to whether they are independent.
			 */
			StdIn.fromFile("data/a8independence.txt");
		
			while (StdIn.hasNextLine()) {
				String line1 = StdIn.readLine();
				String[] fields1 = line1.split("\\s+");
				String course1 = fields1[0];
				String course2 = fields1[1];
				int course1No = courses.get(course1);
				int course2No = courses.get(course2);
				BreadthFirstDirectedPaths path1 = new BreadthFirstDirectedPaths(dg,course1No);
				BreadthFirstDirectedPaths path2 = new BreadthFirstDirectedPaths(dg,course2No);
				if (path1.hasPathTo(course2No) || path2.hasPathTo(course1No) ){
					StdOut.println(course1 + " " + course2 + " are not indepedent");
				} else {
				 StdOut.println(course1 + " " + course2 + " are indepedent");
				}
			} 
		}
	}
}
