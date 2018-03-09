package algs13;

import stdlib.*;

// PROBLEM 2.2.17
// No new node created
// Allowed new linked list
public class MyLinkedSort {
	// Linked list Node
    static class Node {
        public Node() { }
        public double item;
        public Node next;
    }

    int N;	// Number of elements on list
    Node first;
    
    // Constructor
    public MyLinkedSort () {
        first = null;
        N = 0;
        checkInvariants ();
    }

    // My assertion
    private void myassert (String s, boolean b) { if (!b) throw new Error ("Assertion failed: " + s); }
    private void checkInvariants() {
        myassert("Empty <==> first==null", (N == 0) == (first == null));
        Node x = first;
        for (int i = 0; i < N; i++) {
            if (x==null) {
                throw new Error ("List too short!");
            }
            x = x.next;
        }
        myassert("EndOfList == null", x == null);
    }

    public boolean isEmpty () { return first == null; }
    
    public int size () { return N; }
    
    public void add (double item) {
        Node newfirst = new Node ();
        newfirst.item = item;
        newfirst.next = first;
        first = newfirst;
        N++;
    }

    private static void print (String s, MyLinkedSort b) {
        StdOut.print (s + ": ");
        for (Node x = b.first; x != null; x = x.next)
            StdOut.print (x.item + " ");
        StdOut.println ();
    }
    private static void print (String s, MyLinkedSort b, double i) {
        StdOut.print (s + ": ");
        for (Node x = b.first; x != null; x = x.next)
            StdOut.print (x.item + " ");
        StdOut.println (": " + i);
    }

    // TODO - sort
    static public MyLinkedSort sort(MyLinkedSort l ){ // 
	   // Base case: list is of size 1. return
    	if (l.size() == 1) {
    		return l;
    	}
    	
	   // Otherwise use split to create two lists
    	MyLinkedSort[] splittedNode = split(l);
    	
	   // Recursively sort each of them
    	splittedNode[0] = sort(splittedNode[0]);
//        print("Merging sorted splittedNode0", splittedNode[0]);

        splittedNode[1] = sort(splittedNode[1]);
//        print("Merging sorted splittedNode1", splittedNode[1]);
        
	   // Use merge to combine them, and return the result
        return merge(splittedNode[0], splittedNode[1]);
	}
	
    // TODO - split
	static public MyLinkedSort[] split(MyLinkedSort l){
      // Parameter is a List
//		print("Split() has", l);
		
	  // Initialization
        double mid = Math.floor(l.size()) / 2;
        int counter = 0;

	  // It returns an array of size 2
      // Creating array of size 2
        MyLinkedSort[] arrayList = new MyLinkedSort[2];
        arrayList[0] = new MyLinkedSort();
        arrayList[1] = new MyLinkedSort();

        Node tempNode = l.first;
        while (tempNode != null) {
            if (counter < mid){
                // Left list
                arrayList[0].add(tempNode.item);
            } else {
                // Right List
                arrayList[1].add(tempNode.item);
            }

            // advance to next node
            tempNode = tempNode.next;
            counter++;
        }

        // Print list for debugging
//        System.out.println("In SPLIT()");
//        MyLinkedSort.print("array[0]: ", arrayList[0]);
//        System.out.println(arrayList[0].N);
//        MyLinkedSort.print("array[1]: ", arrayList[1]);
//        System.out.println(arrayList[1].N);

        // the [0] element is the left list
        // the [1] element is the right list
        return arrayList;
    }

	//TODO - merge
	static public MyLinkedSort merge(MyLinkedSort lt, MyLinkedSort rt){
	// merge creates a new LinkedList
	// whose elements come from the lt and rt MyLinkedLists
        MyLinkedSort temp = new MyLinkedSort();
        Node dummyHead = new Node();
        Node curr = dummyHead;
        Node tempNodeLeft = lt.first;
        Node tempNodeRight = rt.first;

//        print("merge() tempLeft", lt);
//        print("merge() tempRight", rt);

        while ((tempNodeLeft != null) && (tempNodeRight != null)){
            if (tempNodeLeft.item <= tempNodeRight.item) {
                curr.next = tempNodeLeft;
                tempNodeLeft = tempNodeLeft.next;
            } else {
                curr.next = tempNodeRight;
                tempNodeRight = tempNodeRight.next;
            }
            curr = curr.next;
        }

        // clean up the end
        if (tempNodeLeft == null){
            curr.next = tempNodeRight;
        } else {
            curr.next = tempNodeLeft;
        }

        temp.first = dummyHead.next;

//        print("Merge() result", temp);
        return temp;
//        while ((tempNodeLeft != null) || (tempNodeRight != null)){
//            if (tempNodeLeft == null) {
//                temp.add(tempNodeRight.item);
//                tempNodeRight = tempNodeRight.next;
//            } else if (tempNodeRight == null) {
//                temp.add(tempNodeLeft.item);
//                tempNodeLeft = tempNodeLeft.next;
//            } else if (tempNodeLeft.item < tempNodeRight.item) {
//                // push left node to result node and advance to next node
//                temp.add(tempNodeLeft.item);
//                tempNodeLeft = tempNodeLeft.next;
//            } else if (tempNodeRight.item < tempNodeLeft.item) {
//                // push right node to result node and advance to next node
//                temp.add(tempNodeRight.item);
//                tempNodeRight = tempNodeRight.next;
//            }
//        }
//        return null;

}

    public static void main (String args[]) {
        int[] a1 = new int[20];
		for (int i = 0; i < a1.length; i++)
			a1[i] = i;
		StdRandom.shuffle (a1);
        MyLinkedSort b1 = new MyLinkedSort ();
        for (int i:a1) b1.add(i);
        MyLinkedSort.print("before sort",b1);
        MyLinkedSort res1 = MyLinkedSort.sort(b1);
        MyLinkedSort.print("after sort",res1);

        int[] a2 = new int[200];
		for (int i = 0; i < a2.length; i++)
			a2[i] = i;
		StdRandom.shuffle (a2);
        MyLinkedSort b2 = new MyLinkedSort ();
        for (int i:a1) b2.add(i);
        MyLinkedSort.print("before sort",b2);
        MyLinkedSort res2 = MyLinkedSort.sort(b2);
        MyLinkedSort.print("after sort",res2);
         
    }
}



