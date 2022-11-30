package com.test.sample.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;


public interface WorkMapper {

	
	//작업신청 리스트조회
	List<Map<String, Object>> selectWorkList(Map<String, Object> map);

	//현장별 


}
