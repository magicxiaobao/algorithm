package com.rokey.study.algorithm.cache;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author chenyuejun
 * @create 2020-10-07 10:53 下午
 **/
public class LruCachePrimitiveTest {

	private LruCachePrimitive<Integer, Integer> cache;

	@Before
	public void setup() {

		cache = new LruCachePrimitive(3);
	}

	@Test
	public void testGetHappyCase() {

		cache.set(1, 2);
		assertEquals(2, cache.get(1).intValue());
		assertNull(cache.get(2));
	}

	@Test
	public void testGetWhenValueHasUpdated() {

		cache.set(1, 2);
		cache.set(3, 4);
		cache.set(1, 10);
		assertEquals(10, cache.get(1).intValue());
		assertEquals(4, cache.get(3).intValue());
	}

	@Test
	public void testGetWhenValueExpired() {

		cache.set(1, 2);
		cache.set(3, 4);
		cache.set(5, 6);
		cache.set(7, 8);
		assertNull(cache.get(1));
		assertEquals(4, cache.get(3).intValue());
		cache.set(9, 10);
		assertEquals(10, cache.get(9).intValue());
		assertNull(cache.get(5));
	}

	@Test
	public void setHappyCase() {

		cache.set(1, 2);
		assertEquals(1, cache.size());
		assertEquals(2, cache.get(1).intValue());
		cache.set(1, 3);
		assertEquals(1, cache.size());
		assertEquals(3, cache.get(1).intValue());
		cache.set(3,4);
		cache.set(5,6);
		cache.set(7,8);
		assertEquals(3, cache.size());
	}
}
