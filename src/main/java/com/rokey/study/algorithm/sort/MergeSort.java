package com.rokey.study.algorithm.sort;

/**
 * 时间复杂度 nLog(n)
 * 空间复杂度 (n)
 * @author chenyuejun
 * @date 2020-10-25 7:48 下午
 **/
public class MergeSort {

	public static void sort(int[] array, int length) {

		if (length < 2) {
			return;
		}
		int mid = length / 2;
		int[] left = new int[mid];
		int[] right = new int[length - mid];
		for (int i = 0; i < mid; i++) {
			left[i] = array[i];
		}
		for (int i = 0; i < length - mid; i++) {
			right[i] = array[i + mid];
		}
		sort(left, mid);
		sort(right, length - mid);
		merge(array, left, right, mid, length - mid);
	}

	private static void merge(int[] array, int[] left, int[] right, int leftLength, int rightLength) {

		int leftIndex = 0;
		int rightIndex = 0;
		int arrayIndex = 0;
		while (leftIndex < leftLength && rightIndex < rightLength) {
			if (left[leftIndex] < right[rightIndex]) {
				array[arrayIndex++] = left[leftIndex++];
			} else {
				array[arrayIndex++] = right[rightIndex++];
			}
		}
		while (leftIndex < leftLength) {
			array[arrayIndex++] = left[leftIndex++];
		}
		while (rightIndex < rightLength) {
			array[arrayIndex++] = right[rightIndex++];
		}
	}

}
