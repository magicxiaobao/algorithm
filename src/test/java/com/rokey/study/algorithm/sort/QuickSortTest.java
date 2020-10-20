package com.rokey.study.algorithm.sort;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author chenyuejun
 * @create 2020-10-21 12:09 上午
 **/
@Slf4j
public class QuickSortTest {

	@Test
	public void sort() {

		int[] array = new int[] {1, 6, 3, 8, 2, 10, 7};
		QuickSort.sort(array);
		log.info(JSONUtil.toJsonStr(array));
	}
}
