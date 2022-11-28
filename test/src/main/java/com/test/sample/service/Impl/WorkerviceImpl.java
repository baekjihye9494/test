package com.test.sample.service.Impl;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.sample.service.WorkService;
import com.test.sample.dao.WorkDAO;

@Service("workService")
public class WorkerviceImpl implements WorkService {
	/*
	 * @Autowired private TestDAO testDao;
	 * 
	 * @Override
	 * 
	 * @Transactional public String test() throws Exception { return
	 * testDao.selectTest(); }
	 */
	
	
	@Autowired private WorkDAO workDAO;
	
	@Override
	public List<Map<String, Object>> selectWorkList (Map<String, Object> map) {
		
		return workDAO.selectWorkList(map);
		
	}
}
