package com.rokey.study.algorithm.cache;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author chenyuejun
 * @create 2020-10-07 10:53 下午
 **/
public class LruCachePrimitiveTest {

	@Test
	public void get() {

		LruCachePrimitive cache = new LruCachePrimitive(2);
		cache.set(1,2);
		System.out.println(cache.get(1));
		cache.set(3,4);
		cache.set(5,6);
		System.out.println(cache.get(1));
		System.out.println(cache.get(3));
		cache.set(7,8);
		System.out.println(cache.get(5));
	}

	@Test
	public void set() {
	}
}