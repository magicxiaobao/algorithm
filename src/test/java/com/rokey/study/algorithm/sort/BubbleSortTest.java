package com.rokey.study.algorithm.sort;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author chenyuejun
 * @create 2020-10-21 10:28 下午
 **/
@Slf4j
public class BubbleSortTest {

	@Test
	public void sort() {

		int[] array = {4, 5, 2, 9, 8, 1, 10, 6};
		BubbleSort.sort(array);
		log.info("after bubbleSort, result: {}", JSONUtil.toJsonStr(array));
		int[] emptyArray = {};
		BubbleSort.sort(emptyArray);
		log.info("after bubbleSort, result: {}", JSONUtil.toJsonStr(emptyArray));
		int[] oneEleArray = {2};
		BubbleSort.sort(oneEleArray);
		log.info("after bubbleSort, result: {}", JSONUtil.toJsonStr(oneEleArray));
		int[] twoEleArray = {4, 2};
		BubbleSort.sort(twoEleArray);
		log.info("after bubbleSort, result: {}", JSONUtil.toJsonStr(twoEleArray));
	}

	@Test
	public void sortJava8() {

		int[] array = {4, 5, 2, 9, 8, 1, 10, 6};
		BubbleSort.sortJava8(array);
		log.info("after bubbleSort, result: {}", JSONUtil.toJsonStr(array));
		int[] emptyArray = {};
		BubbleSort.sortJava8(emptyArray);
		log.info("after bubbleSort, result: {}", JSONUtil.toJsonStr(emptyArray));
		int[] oneEleArray = {2};
		BubbleSort.sortJava8(oneEleArray);
		log.info("after bubbleSort, result: {}", JSONUtil.toJsonStr(oneEleArray));
		int[] twoEleArray = {4, 2};
		BubbleSort.sortJava8(twoEleArray);
		log.info("after bubbleSort, result: {}", JSONUtil.toJsonStr(twoEleArray));
	}
}
