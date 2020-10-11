package com.rokey.study.datastructure.tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 *  字典树
 * @author chenyuejun
 * @date 2020-10-10 12:00 上午
 **/
public class Trie {

	private Node root;

	public Trie() {
		this.root = new Node(null, false, "");
	}

	public void addString(String key) {
		if (Objects.nonNull(key) && key.trim().length() > 0) {
			Node node = root;
			for (char c : key.toCharArray()) {
				if (!node.hasChild(c)) {
					node = node.addChild(c);
				} else {
					node = node.getChild(c);
				}
			}
			if (!node.isValid()) {
				node.setValid();
			}
		}
	}

	public boolean findString(String key) {

		Node node = root;
		for (char c : key.toCharArray()) {
			Node temp = node.getChild(c);
			if (Objects.isNull(temp)) {
				return false;
			}
			node = temp;
		}
		return node.isValid();
	}

	@Override
	public String toString() {
		return "Trie{" + "root=" + root.toString() + '}';
	}

	private static class Node {

		private Character key;
		private String content;
		private boolean valid;
		private Collection<Node> children;

		public Node(Character key, boolean valid, String content) {
			this.key = key;
			this.valid = valid;
			this.content = content;
			children = new ArrayList<>();
		}

		public Collection<Node> getChildren() {
			return children;
		}

		public char getKey() {
			return key;
		}

		public boolean hasChild(char c) {

			return children.stream().anyMatch(cl -> cl.getKey() == c);
		}

		public Node getChild(char c) {

			return children.stream().filter(cl -> cl.getKey() == c)
				.findFirst().orElse(null);
		}

		public Node addChild(char c) {
			Node newNode = new Node(c, false, this.content + c);
			this.children.add(newNode);
			return newNode;
		}

		public boolean isValid() {
			return valid;
		}

		public void setValid() {
			this.valid = true;
		}

		public void setContent(String content) {
			this.content = content;
		}

		@Override
		public String toString() {
			return "Node{" + "key=" + key + ", content='" + content + '\'' + ", valid=" + valid + ", children="
				+ children.toString() + '}';
		}
	}
}
