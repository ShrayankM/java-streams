package org.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LeetCodeMain {
	public static void main(String [] args) {
		MultiLevelListNode<Integer> n1 = new MultiLevelListNode<>();
		MultiLevelListNode<Integer> n2 = new MultiLevelListNode<>();
		MultiLevelListNode<Integer> n3 = new MultiLevelListNode<>();
		MultiLevelListNode<Integer> n4 = new MultiLevelListNode<>();
		MultiLevelListNode<Integer> n5 = new MultiLevelListNode<>();
		MultiLevelListNode<Integer> n6 = new MultiLevelListNode<>();

		n1.val = 1; n2.val = 2; n3.val = 3;
		n4.val = 4; n5.val = 5; n6.val = 6;

		// Main list: 1 -> 2 -> 3
		n1.next = n2; n2.next = n3;
		// Child of 1: 4 -> 5
		n1.child = n4; n4.next = n5;
		// Child of 3: 6
		n3.child = n6;

		MultiLevelListNode<Integer> result = flatten_multi_level_list(n1);

		// Print flattened list
		while (result != null) {
			System.out.print(result.val + " -> ");
			result = result.next;
		}
		System.out.println("null");
		// Expected: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
	}

	public static MultiLevelListNode<Integer> flatten_multi_level_list(MultiLevelListNode<Integer> head) {
		// Write your code here
		Queue<MultiLevelListNode<Integer>> queue = new LinkedList<>();

		MultiLevelListNode<Integer> t = head;
		while (t != null) {
			if (t.next == null && queue.isEmpty()) break;

			if (t.next == null) {
				t.next = queue.poll();
			}

			if (t.child != null) {
				queue.offer(t.child);
				t.child = null;
			}

			t = t.next;
		}
		return head;
	}

//	 Definition of MultiLevelListNode:
	 public static class MultiLevelListNode<T> {
	      T val;
	      MultiLevelListNode<T> next;
	      MultiLevelListNode<T> child;
	 }
}

