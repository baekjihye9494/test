package com.test.sample.mapper;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;

import com.test.sample.vo.MemberVO;

public interface MemberMapper {

	// 회원로그인
	int loginChk(String member_id, String member_pw);

	//로그 아웃
	//void logout(HttpSession session);
}
