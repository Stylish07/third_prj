package kr.co.sist.aws.team2.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.sist.aws.team2.service.JobPostService;
import kr.co.sist.aws.team2.service.ProfileService;
import kr.co.sist.aws.team2.service.TechStackService;
import kr.co.sist.aws.team2.vo.JobPostVO;
import kr.co.sist.aws.team2.vo.ProfileVO;
import kr.co.sist.aws.team2.vo.TechStackVO;
import kr.co.sist.aws.team2.vo.UserVO;

@Controller
public class JobPostController {

	@Autowired
	JobPostService js;
	@Autowired
	TechStackService ts;
	@Autowired
	ProfileService ps;

	@RequestMapping(value = "job_post/job_post.do", method = RequestMethod.GET)
	public String jobPost(Model model, HttpSession session,
			@RequestParam(value = "tech_idx", required = false) String tech_idx) {
		try {
			List<TechStackVO> tList = ts.SearchAllTech();
			model.addAttribute("tList", tList);

			if (session.getAttribute("userVO") != null) {
				String id = ((UserVO) session.getAttribute("userVO")).getId();
				ProfileVO profileVO = ps.loadProfile(id);
				model.addAttribute("profileVO", profileVO);
				
				if (tech_idx == null) {
					tech_idx = String.valueOf(profileVO.getTech_idx());
				}
			}
			
			if (tech_idx != null) {
				List<JobPostVO> jobList = js.loadJobTech(tech_idx);
				model.addAttribute("jobList", jobList);
				model.addAttribute("tech_idx", tech_idx);
			} else {
				List<JobPostVO> jobList = js.loadJobList();
				model.addAttribute("jobList", jobList);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "job_post/job_post";
	}

	@RequestMapping(value = "job_post/job_post_view.do", method = RequestMethod.GET)
	public String jobPostView(Model model, @RequestParam String idx) {
		JobPostVO jobPostVO = new JobPostVO();

		try {
			jobPostVO = js.loadJobPost(idx);
			model.addAttribute("jobPostVO", jobPostVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "job_post/job_post_view";
	}

}
