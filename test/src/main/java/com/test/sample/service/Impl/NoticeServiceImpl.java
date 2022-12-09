package com.test.sample.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.sample.mapper.NoticeMapper;
import com.test.sample.service.NoticeService;
import com.test.sample.vo.AuthorityVO;
import com.test.sample.vo.CompanyVO;
import com.test.sample.vo.NoticeVO;
import com.test.sample.vo.SiteVO;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {
	
	
	
	@Autowired private NoticeMapper noticeMapper;

	
	@Override
	// 전체공지사항 목록 리스트
	public ArrayList<NoticeVO> selectNoticeList(HashMap<String, Object> map) {
		return noticeMapper.selectNoticeList(map);
	}
	
	@Override
	// 리스트 총 개수
	public int countBoard(Map<String, Object> map) {
		return noticeMapper.countBoard(map);
	}
	
	@Override
	// 상세보기 or 조회수 증가
	public NoticeVO selectTotalNoticeOne(int noticeNo) {
        return noticeMapper.selectTotalNoticeOne(noticeNo);
    }
	
	@Override
	public void updateTotalNoticeCount(int noticeNo) {
		noticeMapper.updateTotalNoticeCount(noticeNo);
    }
	
	@Override
    // 공지사항 입력
    public int addTotalNotice(NoticeVO Notice) {
        return noticeMapper.addTotalNotice(Notice);
    }

	@Override
    // 수정
    public int updateTotalNotice(NoticeVO Notice) {
        return noticeMapper.updateTotalNotice(Notice);
    }
    
	@Override
    // 삭제
    public int deleteTotalNotice(int noticeNo) {
        return noticeMapper.deleteTotalNotice(noticeNo);
    }
    
	@Override
	// 현장별 게시판 조회
	public ArrayList<NoticeVO> selectBoardSt(HashMap<String, Object> map) {
		return noticeMapper.selectBoardSt(map);
	}
	
	@Override
	// 현장별 , 게시물 갯수
	public int countBoardSt(Map<String, Object> map) {
		return noticeMapper.countBoardSt(map);
	}
	
	
	@Override
	// 업체별 게시판 조회 
	public ArrayList<NoticeVO> selectBoardCp(HashMap<String, Object> map) {
		return noticeMapper.selectBoardCp(map);
	}
	
	@Override	
	// 업체별 , 게시물 갯수
	public int countBoardCp(HashMap<String, Object> map) {
		return noticeMapper.countBoardCp(map);
	}
	

	@Override
	// 멤버 권한 확인 메서드
	public HashMap<String, Object> ahType(String memberId) {
		return noticeMapper.ahType(memberId);
	}

	//전체현장 리스트
	@Override
	public ArrayList<Map<String, Object>> stList() {
		// TODO Auto-generated method stub
		return noticeMapper.stList();
	}
	//내가 근무하는 현장
	@Override
	public ArrayList<Map<String, Object>> mySt(String loginId) {
		// TODO Auto-generated method stub
		return noticeMapper.mySt(loginId);
	}

	//업체 전체 리스트
	@Override
	public ArrayList<Map<String, Object>> cpList() {
		// TODO Auto-generated method stub
		return noticeMapper.cpList();
	}

	//내가 근무하는 업체
	@Override
	public ArrayList<Map<String, Object>> myCp(String loginId) {
		// TODO Auto-generated method stub
		return noticeMapper.myCp(loginId);
	}

	
	
	
}
