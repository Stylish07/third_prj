package kr.co.sist.aws.team2.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import kr.co.sist.aws.team2.dao.SignInDAO;
import kr.co.sist.aws.team2.vo.UserVO;

@Component
public class AccountsService {
	
	@Autowired
	private SignInDAO signInDAO;

	public UserVO signIn(String id, String password) throws SQLException, EmptyResultDataAccessException {
		UserVO userVO = new UserVO();

		userVO = signInDAO.signIn(id, password);

		return userVO;
	}
}
