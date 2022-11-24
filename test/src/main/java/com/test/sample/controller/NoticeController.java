package com.test.sample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.sample.service.NoticeService;

@RestController
@RequestMapping(value = "/notice")
public class NoticeController {
	
	
	@Autowired
	private NoticeService noticeService;

	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	
	
	@RequestMapping(value = "/noticeList")
	@ResponseBody
	public String testList(Model model) throws Exception {
		

		String test =  String.valueOf(noticeService.selectNotice());

	    logger.info(test);

	    return test;
	}
	

}
