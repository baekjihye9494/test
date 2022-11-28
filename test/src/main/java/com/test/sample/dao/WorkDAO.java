package com.test.sample.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;


public interface WorkDAO {

	
	//작업신청 리스트조회
	List<Map<String, Object>> selectWorkList(Map<String, Object> map);
}
