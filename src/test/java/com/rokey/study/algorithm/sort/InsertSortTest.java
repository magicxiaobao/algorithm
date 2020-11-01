package com.rokey.study.algorithm.sort;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;


/**
 * @author chenyuejun
 * @create 2020-11-01 12:29 下午
 **/
@Slf4j
public class InsertSortTest {

	@Test
	public void testInsertSort() {

		int[] array = {5,3,3,7,2,3};
		InsertSort.sort(array);
		log.debug("insertSort result: {}", JSONUtil.toJsonStr(array));
	}

}
