package com.rokey.study.algorithm.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * 要求 get set 方法 O(1)
 * 用 map 来保证get O(1)
 * 用 带有头，尾节点的链表保证 add remove O(1)
 * @author chenyuejun
 * @date 2020-10-07 10:50 下午
 **/
public class LruCachePrimitive {

	private int capacity;
	private int count;
	private Map<Integer, Node> map;
	private Node head,tail;

	public LruCachePrimitive(int cap) {

		map = new HashMap<>();
		head = new Node(0, 0);
		tail = new Node(0, 0);
		head.next = tail;
		head.prev = null;
		tail.prev = head;
		tail.next = null;
		capacity = cap;
	}

	// This method works in O(1)
	public int get(int key) {
		// your code here
		if (map.containsKey(key)) {
			Node node = map.get(key);
			deleteNode(node);
			addNode2Head(node);
			return node.value;
		}
		return -1;
	}

	private void deleteNode(Node node) {

		Node next =  node.next;
		Node prev = node.prev;
		prev.next = next;
		next.prev = prev;
	}

	private void addNode2Head(Node node) {

		Node temp = head.next;
		head.next = node;
		node.prev = head;
		temp.prev = node;
		node.next = temp;
	}

	// This method works in O(1)
	public void set(int key, int value) {
		// your code here
		if (map.containsKey(key)) {
			Node newNode = new Node(key, value);
			Node originalNode = map.get(key);
			map.put(key, newNode);
			this.deleteNode(originalNode);
			this.addNode2Head(newNode);
		} else {
			if (count < capacity) {
				Node newNode = new Node(key, value);
				map.put(key, newNode);
				this.addNode2Head(newNode);
				count++;
			} else {
				Node node2Delete = tail.prev;
				map.remove(node2Delete.key);
				deleteNode(node2Delete);
				Node newNode = new Node(key, value);
				map.put(key, newNode);
				this.addNode2Head(newNode);
			}
		}
	}

	public int size() {
		return count;
	}

	static class Node {

		private int key, value;
		private Node prev;
		private Node next;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
}
