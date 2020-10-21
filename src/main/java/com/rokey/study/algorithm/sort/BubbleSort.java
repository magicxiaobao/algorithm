package com.rokey.study.algorithm.sort;

import java.util.stream.IntStream;

/**
 * 冒泡排序
 * @author chenyuejun
 * @date 2020-10-21 10:18 下午
 **/
public class BubbleSort {

	public static void sort(int[] array) {

		for (int i = array.length - 1; i > 0; i--) {
			for (int k = 0; k < i; k++) {
				if (array[k] > array[k + 1]) {
					int temp = array[k + 1];
					array[k + 1] = array[k];
					array[k] = temp;
				}
			}
		}
	}

	public static void sortJava8(int[] array) {

		int n = array.length;
		IntStream.range(0, n - 1).flatMap(i -> IntStream.range(0, n - i - 1))
			.forEach(j -> {
				if (array[j] > array[j + 1]) {
					int temp = array[j + 1];
					array[j + 1] = array[j];
					array[j] = temp;
				}
			});
	}
}
