package com.test.sample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.sample.service.TestService;

@Controller
public class TestController {
	
	@Autowired
	private TestService testService;

	private static final Logger logger = LoggerFactory.getLogger(TestController.class);
	
	
	@RequestMapping(value = "/test")
	public String testList(Model model) throws Exception {

		String test =  String.valueOf(testService.selectTest());

	    logger.info(test);

	    return test;
	}
	
}
