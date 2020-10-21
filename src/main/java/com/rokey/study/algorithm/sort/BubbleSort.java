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

	/**
	 * 如果是已经排好序的数组，可以只遍历一次
	 * @param arr
	 */
	public static void optimizedBubbleSort(int[] arr) {
		int i = 0, n = arr.length;
		boolean swapNeeded = true;
		while (i < n - 1 && swapNeeded) {
			swapNeeded = false;
			for (int j = 1; j < n - i; j++) {
				if (arr[j - 1] > arr[j]) {
					int temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
					swapNeeded = true;
				}
			}
			if(!swapNeeded) {
				break;
			}
			i++;
		}
	}
}
