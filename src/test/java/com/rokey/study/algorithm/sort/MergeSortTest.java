package com.rokey.study.algorithm.sort;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author chenyuejun
 * @create 2020-10-25 11:05 下午
 **/
@Slf4j
public class MergeSortTest {

	@Test
	public void sort() {

		int[] ints = {4, 9, 5, 2, 7, 8, 3};
		int[] expected = {2, 3, 4, 5, 7, 8, 9};
		MergeSort.sort(ints, ints.length);
		log.info("merge sort result: {}", JSONUtil.toJsonStr(ints));
		Assert.assertArrayEquals(ints, expected);
	}
}
