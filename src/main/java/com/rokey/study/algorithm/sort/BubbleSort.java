package com.rokey.study.algorithm.sort;

/**
 * 冒泡排序
 * @author chenyuejun
 * @date 2020-10-21 10:18 下午
 **/
public class BubbleSort {

	public static void sort(int[] array) {
		// 边界
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
}
