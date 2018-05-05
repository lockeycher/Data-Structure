/* Student name: Lavinia Wang */

package assignment5;

import java.util.ArrayList;
import java.util.List;
import algs13.Queue;
import algs31.SimplerBST;

public class A5ReorganizingBST<K extends Comparable<K>, V> {
	private SimplerBST<K, V> bstree;
		
	// public A5ReorganizingBST() {}
	SimplerBST<K, V> myBST = new SimplerBST<>();
		
	// get() method
	public void get(K key) {
		myBST.get(key);
	}
	
	/* *************************************************************************************
	 * Helper function
	 * ************************************************************************************* 
	 * Whenever the number of keys is divisible by 100, 
	 * it will create a new simpler BST 
	 * and insert the keys from the current one into the new one 
	 * in such a way that the new one is balanced.
	 * *************************************************************************************
	 * This can be done by inserting the keys using the medians algorithm.
	 */
	
	// This listByMedians() method to get an iterable list of the keys in median order
	private Iterable<K> listByMedians(List<K> keys) {
		algs13.Queue<K> medianQueue = new algs13.Queue<>();
		algs13.Queue<Integer> queueLeft = new algs13.Queue<>();
		algs13.Queue<Integer> queueRight = new algs13.Queue<>();
		queueLeft.enqueue(0);
		queueRight.enqueue(keys.size()-1);
		while (!queueLeft.isEmpty()) {
			int left = queueLeft.dequeue();
			int right = queueRight.dequeue();
			if (left <= right) {
				int medianIndex = (right+left)/2;
				K median = keys.get(medianIndex);
				medianQueue.enqueue(median);
				queueLeft.enqueue(left);
				queueRight.enqueue(medianIndex-1);
				queueLeft.enqueue(medianIndex+1);
				queueRight.enqueue(right);
			}
		}
		return medianQueue;
	}

	
	// reorganize() method
	private void reorganize() {
		
		// Creates a new simpler BST
		SimplerBST<K, V> New_bst = new SimplerBST<>();
		
		// Creates an array list of the keys in the current BST
		ArrayList<K> al = new ArrayList<K>();
		for (K key : myBST.keys() ) {
			al.add(key);
		}
		
		// Iterates through a call to the listByMedians method which has been passed the array list
		// In that loop, put the key and its value into the new BST
		Iterable<K> listMedians = listByMedians(al);
		for (K listMedian : listMedians) {
			New_bst.put(listMedian, myBST.get(listMedian));
		}
		// After the loop, assign the new BST to the current BST (this will automatically deallocate the old BST)
		myBST = New_bst;
	}

	
	// get the number of keys
	private int keysNum() {
	int keysNum = 0;
	for (K key : myBST.keys()) {
		keysNum++;
	}
	return keysNum;
	}
	
	// Modified put() method
	public void put(K key, V value) {
		if (!myBST.contains(key)) {
			myBST.put(key,value);
			if((keysNum() % 100) == 0) {
				reorganize(); 
			}
		} else {
			myBST.put(key,value);
		}
	}
	
	// Modified delete() method
	public void delete(K key) {
		if (myBST.contains(key)) {
			myBST.delete(key);
			if((keysNum() % 100) == 0) {
				reorganize();
			}
		}
	}
	
	// height() method
	public int height() {
		return myBST.height();
	}

}
