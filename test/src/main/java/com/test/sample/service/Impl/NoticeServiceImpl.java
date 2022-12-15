package com.test.sample.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired private NoticeMapper noticeMapper;
	
	//로그인
	@Override
    public boolean loginChk(String member_id, String member_pw) {
		boolean success = false;
        
        if(noticeMapper.loginChk(member_id,member_pw) != 0) {
        	success = true;
        }
        return success;
    }

	//로그인 아이디의 권한과 업체 가져오기
	@Override
	public HashMap<String, Object> ahType(String memberId) {
		// TODO Auto-generated method stub
		return noticeMapper.ahType(memberId);
	}

	@Override
	public ArrayList<NoticeVO> list(HashMap<String, Object> info) {
		logger.info("리스트 호출 서비스 진입======");
		logger.info("권한"+info.get("AUTHORITY_TYPE"));
		logger.info(String.valueOf(info.get("company_code")));//소문자로 했더니 안나옴
		logger.info("아이디"+info.get("loginId"));
		return noticeMapper.list(info);
	}
	

	//현장리스트
	@Override
	public ArrayList<SiteVO> site(HashMap<String, Object> ahType) {
		// TODO Auto-generated method stub
		return noticeMapper.site(ahType);
	}

	//업체리스트
	@Override
	public ArrayList<CompanyVO> company(HashMap<String, Object> ahType) {
		// TODO Auto-generated method stub
		return noticeMapper.company(ahType);
	}
	
	//게시글 갯수
	@Override
	public int allCount(HashMap<String, Object> info) {
		// TODO Auto-generated method stub
		return noticeMapper.allCount(info);
	}

	//상세보기
	@Override
	public NoticeVO noticeOne(int notice_no) {
		logger.info("noticeOne 상세보기 서비스 진입===?");
		logger.info("notice_no===>"+notice_no);
		// TODO Auto-generated method stub
		return noticeMapper.noticeOne(notice_no);
		
	}

	
	
	
	
	@Override
	public void updateTotalNoticeCount(int noticeNo) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public int addTotalNotice(NoticeVO Notice) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateTotalNotice(NoticeVO Notice) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteTotalNotice(int noticeNo) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
}
