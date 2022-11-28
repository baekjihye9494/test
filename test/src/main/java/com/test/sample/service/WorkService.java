package com.test.sample.service;

import java.util.List;
import java.util.Map;


public interface WorkService {
	
	/*
	 * String test() throws Exception;
	 */

	//리스트
	List<Map<String, Object>> selectWorkList(Map<String, Object> map);

}
