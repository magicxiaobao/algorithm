package com.rokey.study.datastructure.linkedlist;

/**
 * 圆形单向列表
 * @author chenyuejun
 * @date 2020-10-11 11:28 下午
 **/
public class CircularLinkedList {

	private Node head;
	private Node tail;

	public CircularLinkedList() {
		this.head = null;
		this.tail = null;
	}

	public void addNode(int value) {

		if (head == null) {
			head = tail = new Node(value);
		} else {
			Node node = new Node(value);
			tail.next = node;
			tail = node;
		}
		tail.next = head;
	}

	public boolean containsNode(int value) {

		if (head == null) {
			return false;
		}
		Node node = head;
		do {
			if (node.getValue() == value) {
				return true;
			}
			node = head.next;
		} while (node != head);
		return false;
	}

	public void deleteNode(int value) {

		Node node = head;
		if (node != null) {
			if (node.getValue() == value) {
				head = head.next;
				tail.next = head;
			} else {
				do {
					Node temp = node.next;
					if (temp.getValue() == value) {
						node.next = temp.next;
						break;
					} else {
						node = temp;
					}
				} while (node != head);
			}
		}
	}

	private class Node {

		private int value;
		private Node next;

		public Node(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

	}
}
