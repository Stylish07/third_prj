package kr.co.sist.aws.team2.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.sist.aws.team2.service.CareerService;

@Controller
public class ResumeController {

	@Autowired
	private CareerService cs;

	@RequestMapping(value = "resume/resume.do", method = RequestMethod.GET)
	public String resume() {
		return "resume/resume";
	}

	@RequestMapping(value = "resume/career_process.do", method = RequestMethod.POST)
	public String useJdbcTemplate(Model model, String id) throws SQLException {
		model.addAttribute("careerVO", cs.selectCareer(id));
		
		System.out.println("프로세스두");
		
		return "resume/resume";
	}
	
}
