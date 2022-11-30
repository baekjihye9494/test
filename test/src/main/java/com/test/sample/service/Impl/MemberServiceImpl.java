package com.test.sample.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.sample.mapper.MemberMapper;
import com.test.sample.service.MemberService;
import com.test.sample.vo.MemberVO;

import lombok.Data;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	@Autowired MemberMapper memberMapper;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
    public boolean loginChk(String member_id, String member_pw) {
        boolean success = false;
        
        if(memberMapper.loginChk(member_id,member_pw) > 0) {
            success = true;
        }
        return success;
    }
}
	
	/*
	// 회원로그인
	public MemberVO selectMemberLogin(MemberVO paramMember) {
		// 파라미터 디버깅
		logger.info("paramMember (service) > " + paramMember);

		// 매퍼메서드 호출 후 리턴값 디버깅
		MemberVO resultMember = memberDAO.selectMemberLogin(paramMember);
		logger.info("resultMember (service) > " + resultMember);

		
		return resultMember;
		*/
	