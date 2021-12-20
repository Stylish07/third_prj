package kr.co.sist.aws.team2.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import kr.co.sist.aws.team2.dao.AdminAccountDAO;
import kr.co.sist.aws.team2.vo.AdminVO;

@Component
public class AdminAccountsService {

	@Autowired
	private AdminAccountDAO accountDAO;

	public AdminVO adminLogin(String id, String password) throws EmptyResultDataAccessException, SQLException {
		AdminVO adminVO = new AdminVO();

		adminVO = accountDAO.adminLogin(id, password);

		return adminVO;
	}

}
