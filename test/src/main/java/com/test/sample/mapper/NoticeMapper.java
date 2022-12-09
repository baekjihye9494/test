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
	
	
	// 게시물 총 갯수
	int countBoard(Map<String, Object> map);

	// 페이징 처리 게시글 조회
	ArrayList<NoticeVO> selectNoticeList(HashMap<String, Object> map);
	
	// 공지사항 조회수
	void updateTotalNoticeCount(int noticeNo);
	
	// 전체공지사항 추가
	int addTotalNotice(NoticeVO Notice);

	// 공지사항 상세보기
	NoticeVO selectTotalNoticeOne(int noticeNo);
		
	// 공지사항 수정
	int updateTotalNotice(NoticeVO Notice);

	//공지사항 삭제
	int deleteTotalNotice(int noticeNo);
	
	
	//현장별 게시판 조회 , 게시물 갯수
	ArrayList<NoticeVO> selectBoardSt(HashMap<String, Object> map);
	int countBoardSt(Map<String, Object> map);
	
	//업체별 게시판 조회 , 게시물 갯수
	ArrayList<NoticeVO> selectBoardCp(HashMap<String, Object> map);
	int countBoardCp(Map<String, Object> map);
	
	// 멤버 권한확인 메서드
	HashMap<String, Object> ahType(String memberId);
	

	// 현장전체리스트 / 내가 근무하는 현장
	ArrayList<Map<String, Object>> stList();
	ArrayList<Map<String, Object>> mySt(String loginId);

	// 업체전체리스트 / 내가 근무하는 업체
	ArrayList<Map<String, Object>> cpList();
	ArrayList<Map<String, Object>> myCp(String loginId);

}
