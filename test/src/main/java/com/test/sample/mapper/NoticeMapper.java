package com.test.sample.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.org.apache.bcel.internal.generic.ATHROW;
import com.test.sample.vo.AuthorityVO;
import com.test.sample.vo.CompanyVO;
import com.test.sample.vo.NoticeVO;
import com.test.sample.vo.SiteVO;

public interface NoticeMapper {
	
	// 회원로그인
	int loginChk(String member_id, String member_pw);
	
	// 멤버 권한확인 메서드
	HashMap<String, Object> ahType(String memberId);

	// 페이징 처리 게시글 조회
	ArrayList<NoticeVO> list(HashMap<String, Object> info);
	
	//사이트리스트
	ArrayList<SiteVO> site(HashMap<String, Object> ahType);
	
	//내가 일하는 업체리스트
	ArrayList<CompanyVO> company(HashMap<String, Object> ahType);
	
	// 게시물 총 갯수
	int allCount(HashMap<String, Object> info);

	// 공지사항 상세보기
	NoticeVO noticeOne(int noticeNo);
	
	// 공지사항 조회수
	void updateNoticeCount(int noticeNo);
	
	// 전체공지사항 추가
	int addNotice(HashMap<String, Object> params);
		
	// 공지사항 수정
	int updateNotice(HashMap<String, Object> params);

	//공지사항 삭제
	int deleteNotice(int noticeNo);
	
	
}
