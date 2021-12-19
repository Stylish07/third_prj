package kr.co.sist.aws.team2.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.aws.team2.dao.NoticeDAO;
import kr.co.sist.aws.team2.vo.NoticeVO;

@Component
public class NoticeService {

	@Autowired
	private NoticeDAO noticeDAO;
	
	public List<NoticeVO> loadNotice() throws SQLException {
		List<NoticeVO> list = null;
		
		list = noticeDAO.selectAllNotice();
		
		return list;
	}
	
	public NoticeVO viewNotice(String idx) throws SQLException {
		NoticeVO noticeVO = new NoticeVO();
		
		noticeVO = noticeDAO.selectNotice(idx);
		
		return noticeVO;
	}
	
}
