package com.rokey.study.datastructure.tree;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author chenyuejun
 * @create 2020-10-11 7:35 下午
 **/
@Slf4j
public class TrieTest {


	@Test
	public void addString() {

		Trie trie = this.createExampleData();
		log.info(trie.toString());
	}

	@Test
	public void findString() {

		Trie tire = this.createExampleData();
		assertTrue(tire.findString("bcd"));
		assertTrue(tire.findString("abc"));
		assertTrue(tire.findString("dfe"));
		assertFalse(tire.findString("abd"));
		assertFalse(tire.findString("abcd"));
	}

	private Trie createExampleData() {

		Trie trie = new Trie();
		trie.addString("abc");
		trie.addString("bcd");
		trie.addString("dfe");
		return trie;
	}
}
