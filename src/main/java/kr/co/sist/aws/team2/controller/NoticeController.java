package kr.co.sist.aws.team2.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.sist.aws.team2.service.NoticeService;
import kr.co.sist.aws.team2.vo.NoticeVO;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService ns;

	@RequestMapping(value = "notice/notice.do", method = RequestMethod.GET)
	public String notice(Model model) {
		
		try {
			List<NoticeVO> list = ns.loadNotice();
			model.addAttribute("notice", list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "notice/notice";
	}
	
	@RequestMapping(value = "notice/notice_view.do", method = RequestMethod.GET)
	public String noticeView(@RequestParam String idx, Model model) {
		try {
			NoticeVO noticeVO = ns.viewNotice(idx);
			model.addAttribute("noticeVO", noticeVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "notice/notice_view";
	}

}
