package com.test.sample.service;

import org.springframework.stereotype.Service;

import com.test.sample.vo.MemberVO;

@Service
public interface MemberService {

	
	 MemberVO getMemberLogin(MemberVO paramMember);


}
