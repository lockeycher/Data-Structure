package algs24;

import stdlib.StdIn;
import stdlib.StdOut;

import algs12.Node;


/**
 *  The <tt>PtrHeap</tt> class is the priorityQ class from Question 2.4.24.
 *  It represents a priority queue of generic keys.
 *  
 *  It supports the usual <em>insert</em> and <em>delete-the-maximum</em>
 *  operations, along with methods for peeking at the maximum key,
 *  testing if the priority queue is empty, and iterating through
 *  the keys.
 *  For additional documentation, see <a href="http://algs4.cs.princeton.edu/24pq">Section 2.4</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 */

public class PtrHeap<K extends Comparable<? super K>> {
	private class Node{
		int N;
		K data;
		Node parent, left, right;
		public Node(K data, int N) {
			this.data = data;
			this.N = N;
		}
		public void displayNode() {
	        System.out.println(data + " ");
	    }
	}
	private Node root;
	private Node lastInserted;
	
	//helper methods
    private int size(Node x){
        if(x == null) return 0;
        return x.N;
	}
    
    private void swim(Node x){
        if(x == null) return;
        if(x.parent == null) return; // we're at root
        int cmp = x.data.compareTo(x.parent.data);
        if(cmp > 0){
            swapNodeData(x, x.parent);
            swim(x.parent);
        }
	}
    
    private void sink(Node x){
        if(x == null) return;
        Node swapNode;
        if(x.left == null && x.right == null){
            return;
        }
        else if(x.left == null){
            swapNode = x.right;
            int cmp = x.data.compareTo(swapNode.data);
            if(cmp < 0)
                swapNodeData(swapNode, x);
        } else if(x.right == null){
            swapNode = x.left;
            int cmp = x.data.compareTo(swapNode.data);
            if(cmp < 0)
                swapNodeData(swapNode, x);
        } else{
            int cmp = x.left.data.compareTo(x.right.data);
            if(cmp >= 0){
                swapNode = x.left;
            } else{
                swapNode = x.right;
            }
            int cmpParChild = x.data.compareTo(swapNode.data);
            if(cmpParChild < 0) {
                swapNodeData(swapNode, x);
                sink(swapNode);
            }
        }
    }
    private void swapNodeData(Node x, Node y){
        K temp = x.data;
        x.data = y.data;
        y.data = temp;
    }
    private Node insert(Node x, K data){
        if(x == null){
            lastInserted = new Node(data, 1);
            return lastInserted;
        }
        // compare left and right sizes see where to go
        int leftSize = size(x.left);
        int rightSize = size(x.right);

        if(leftSize <= rightSize){
            // go to left
            Node inserted = insert(x.left, data);
            x.left = inserted;
            inserted.parent = x;
        } else{
            // go to right
            Node inserted = insert(x.right, data);
            x.right = inserted;
            inserted.parent = x;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }
    private Node resetLastInserted(Node x){
        if(x == null) return null;
        if(x.left == null && x.right == null) return x;
        if(size(x.right) < size(x.left))return resetLastInserted(x.left);
        else                            return resetLastInserted(x.right);
    }
		
	@SuppressWarnings("unchecked")
	/** Create an empty priority queue  */
	public PtrHeap() {
		int N = 0;
		K data = null;
		Node parent = null;
		Node left = null;
		Node right = null;
		
	}

	/** Is the priority queue empty? */
	public boolean isEmpty() { return size() == 0; }

	/** Is the priority queue full? */
	public boolean isFull()  { 
		int depth = size() + 1;
		return (depth & (depth-1)) == 0; 
		}

	/** Return the number of items on the priority queue. */
	public int size() { return size(root);}

	/**
	 * Return the largest key on the priority queue.
	 * Throw an exception if the priority queue is empty.
	 */
	public K max() {
		if(root == null) return null;
        return root.data;
		
	}

	/** Add a new key to the priority queue. */
	public void insert(K x) {
		root = insert(root, x);
        swim(lastInserted);
	}

	/**
	 * Delete and return the largest key on the priority queue.
	 * Throw an exception if the priority queue is empty.
	 */
	public K delMax() {
		if(size() == 1){
            K max = root.data;
            root = null;
            return max;
        }
        swapNodeData(root, lastInserted);
        Node lastInsParent = lastInserted.parent;
        K lastInsData = lastInserted.data;
        if(lastInserted == lastInsParent.left){
            lastInsParent.left = null;
        } else{
            lastInsParent.right = null;
        }

        Node traverser = lastInserted;

        while(traverser != null){
            traverser.N--;
            traverser = traverser.parent;
        }

        lastInserted = resetLastInserted(root);

        sink(root);

        return lastInsData;
    }

	private void showHeap() {
	    // a method to print out the heap
		// useful for debugging
		// Hint: use a queue. If you just want to google for it, google BFS (breadth first search)
//		if (root == null) return;
//		if (root.left == null && root.right == null)
//			StdOut.println(root.data);
	}

	public static void main(String[] args) {
		PtrHeap<String> pq = new PtrHeap<>();
		StdIn.fromString("10 20 30 40 50 - - - 05 25 35 - - - 70 80 05 - - - - ");
//		StdIn.fromString("10 20 30 40 50 05 25 48 11 11 11 11 15 11");
		while (!StdIn.isEmpty()) {
			StdOut.print ("pq:  "); pq.showHeap();
			String item = StdIn.readString();
			if (item.equals("-")) StdOut.println("max: " + pq.delMax());
			else pq.insert(item);
		}
		StdOut.println("(" + pq.size() + " left on pq)");
//		System.out.println(pq.isFull());
	}

}

