package com.test.sample.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.sample.dao.MemberDAO;
import com.test.sample.service.MemberService;
import com.test.sample.vo.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	@Autowired MemberDAO memberDAO;
	
	
	@Override
	// 회원로그인
	public MemberVO getMemberLogin(MemberVO paramMember) {	
		MemberVO resultMember = memberDAO.selectMemberLogin(paramMember);
		
		
		return memberDAO.selectMemberLogin(paramMember);
	}
	

}
