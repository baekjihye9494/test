package com.test.sample.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.sample.mapper.MemberMapper;
import com.test.sample.vo.MemberVO;

@Service
public interface MemberService {
	

	// 회원로그인
	boolean loginChk(String member_id, String member_pw);

	
}
