package com.rokey.study.algorithm.sort;

/**
 * 插入排序
 * 数组氛围 一个有序，一个无序，将无序的元素以插入的方式加入到有序的数组中
 * @author chenyuejun
 * @date 2020-10-28 11:10 下午
 **/
public class InsertSort {

	public static void sort(int[] array) {

		for (int i = 1; i < array.length; i++) {

			int current = array[i];
			int j = i - 1;
			while (j >= 0 && array[j] > current) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = current;
		}
	}
}
