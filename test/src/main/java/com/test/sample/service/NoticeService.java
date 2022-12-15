package com.test.sample.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.test.sample.vo.AuthorityVO;
import com.test.sample.vo.CompanyVO;
import com.test.sample.vo.NoticeVO;
import com.test.sample.vo.SiteVO;

@Service
public interface NoticeService {
	
	// 회원로그인
	boolean loginChk(String member_id, String member_pw);
	
	// 멤버 권한 확인메서드
	HashMap<String, Object> ahType(String memberId);
	
	// 페이징 처리 게시글 조회
	ArrayList<NoticeVO> list(HashMap<String, Object> info);
		
	//현장리스트
	ArrayList<SiteVO> site(HashMap<String, Object> ahType);

	//업체리스트
	ArrayList<CompanyVO> company(HashMap<String, Object> ahType);
	
	// 게시물 총 갯수
	int allCount(HashMap<String, Object> info);

	// 공지사항 상세보기
	NoticeVO noticeOne(int notice_no);
	
	
	
	
	
	
	
	// 공지사항 조회수
	void updateTotalNoticeCount(int noticeNo);
	
	// 전체공지사항 추가
	int addTotalNotice(NoticeVO Notice);

		
	// 공지사항 수정
	int updateTotalNotice(NoticeVO Notice);

	//공지사항 삭제
	int deleteTotalNotice(int noticeNo);
	
	
	
	/**
	
	//현장별 게시판 조회 , 게시물 갯수
	ArrayList<NoticeVO> selectBoardSt(HashMap<String, Object> map);
	int countBoardSt(Map<String, Object> map);
	
	//업체별 게시판 조회 , 게시물 갯수
	ArrayList<NoticeVO> selectBoardCp(HashMap<String, Object> map);
	int countBoardCp(HashMap<String, Object> map);
	


	// 현장전체리스트 / 내가 근무하는 현장
	ArrayList<Map<String, Object>> stList();
	ArrayList<Map<String, Object>> mySt(String loginId);

	// 업체전체리스트 / 내가 근무하는 업체
	ArrayList<Map<String, Object>> cpList();
	ArrayList<Map<String, Object>> myCp(String loginId);

	**/


}
