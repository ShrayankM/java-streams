package org.example;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
	private ListNode<Integer> head;
	private ListNode<Integer> tail;
	private Map<Integer, ListNode<Integer>> keyNodeMap;
	int capacity = 0;

	public LRUCache(Integer capacity) {
		this.capacity = capacity;
		this.head = new ListNode<>(0, 0);
		this.tail = new ListNode<>(0, 0);
		this.keyNodeMap = new HashMap<>();

		this.head.next = this.tail;
		this.tail.prev = this.head;
	}

	public Integer get(Integer key) {
		// Write your code here
		if (!keyNodeMap.containsKey(key)) return -1;
		ListNode<Integer> keyNode = keyNodeMap.get(key);

		deleteNode(keyNode);
		insertNodeAtStart(keyNode);
		return keyNode.val;
	}

	public void put(Integer key, Integer value) {
		// Write your code here
		if (keyNodeMap.containsKey(key)) {
			// update
			ListNode<Integer> keyNode = keyNodeMap.get(key);

			deleteNode(keyNode);
			keyNode.val = value;
			insertNodeAtStart(keyNode);
		} else {
			// insert
			if (keyNodeMap.size() == capacity) {
				ListNode<Integer> leastRecentlyUsedNode = this.tail.prev;
				keyNodeMap.remove(leastRecentlyUsedNode.key);

				deleteNode(leastRecentlyUsedNode);
			}

			ListNode<Integer> newNode = new ListNode<>(value, key);
			insertNodeAtStart(newNode);
			keyNodeMap.put(key, newNode);
		}
	}

	private void insertNodeAtStart(ListNode<Integer> node) {
		node.prev = head;
		node.next = this.head.next;

		this.head.next.prev = node;
		this.head.next = node;
	}

	private void deleteNode(ListNode<Integer> node) {
		ListNode<Integer> prevNode = node.prev;
		ListNode<Integer> nextNode = node.next;

		prevNode.next = nextNode;
		nextNode.prev = prevNode;
	}

	public static void main(String [] args) {
		LRUCache lruCache = new LRUCache(3);

		System.out.println(lruCache.get(1));
		lruCache.put(1, 10);
		lruCache.put(2, 20);
		lruCache.put(3, 30);

		System.out.println(lruCache.get(1));
		lruCache.put(4, 40);

		System.out.println(lruCache.get(2));
	}

	public class ListNode<T> {
		T val;
		T key;
		ListNode next;
		ListNode prev;
		ListNode(T val, T key) {
			this.val = val;
			this.key = key;
			this.next = null;
			this.prev = null;
		}
	}
}

