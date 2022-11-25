package com.test.sample.service.Impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.sample.service.TestService;
import com.test.sample.dao.TestDAO;

@Service("testService")
public class TestServiceImpl implements TestService {
	@Autowired
	private TestDAO testDao;

	@Override
	@Transactional
	public String test() throws Exception {
		return testDao.selectTest();
	}

}
