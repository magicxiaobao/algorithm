package com.rokey.study.algorithm.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/**
 * 要求 get set 方法 O(1)
 * 用 map 来保证get O(1)
 * 用 带有头，尾节点的链表保证 add remove O(1)
 * @author chenyuejun
 * @date 2020-10-07 10:50 下午
 **/
public class LruCachePrimitiveThreadSafe<K, V> {

	private int capacity;
	private Map<K, Node<K, V>> map;
	private Node<K,V> head,tail;
	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	private ReadLock readLock = lock.readLock();
	private WriteLock writeLock = lock.writeLock();

	public LruCachePrimitiveThreadSafe(int cap) {

		this.capacity = cap;
		map = new HashMap<>();
	}

	public V get(K key) {
		if (key == null) {
			return null;
		}
		readLock.lock();
		try {
			if (map.containsKey(key)) {
				Node<K, V> node = map.get(key);
				deleteNode(node);
				offerNode(node);
				return node.value;
			}
			return null;
		} finally {
			readLock.unlock();
		}
	}

	private void deleteNode(Node<K, V> node) {

		if (node == null) {
			return;
		}
		if (node.prev != null) {
			node.prev.next = node.next;
		} else {
			this.head = node.next;
		}
		if (node.next != null) {
			node.next.prev = node.prev;
		} else {
			this.tail = node.prev;
		}
	}

	/**
	 * 新元素放入队列尾部
	 * @param node
	 */
	private void offerNode(Node<K, V> node) {

		if (node == null) {
			return;
		}
		if (head == null) {
			head = tail = node;
		} else {
			tail.next = node;
			node.prev = tail;
			node.next = null;
			tail = node;
		}
	}

	public void set(K key, V value) {

		writeLock.lock();
		try {
			if (map.containsKey(key)) {

				Node<K, V> originalNode = map.get(key);
				this.deleteNode(originalNode);
				Node<K, V> newNode = new Node(key, value);
				map.put(key, newNode);
				this.offerNode(newNode);
			} else {
				if (size() == capacity) {
					// 数量达到上线，删除队列头
					map.remove(head.key);
					deleteNode(head);
				}
				Node<K, V> newNode = new Node(key, value);
				map.put(key, newNode);
				this.offerNode(newNode);
			}
		} finally {
			writeLock.unlock();
		}
	}

	public int size() {

		readLock.lock();
		try {
			return this.map.size();
		} finally {
			readLock.unlock();
		}
	}

	private static class Node<K,V> {

		private K key;
		private V value;
		private Node<K, V> prev;
		private Node<K, V> next;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public String toString() {
			return value.toString();
		}
	}
}
