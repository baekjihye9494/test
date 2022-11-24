package com.test.sample.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.sample.dao.NoticeDAO;
import com.test.sample.service.NoticeService;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {	
	
	@Autowired
	private NoticeDAO noticeDao;
	
	
	@Override
	@Transactional
	public String selectNotice() throws Exception {
		return noticeDao.selectNotice();
	}

}