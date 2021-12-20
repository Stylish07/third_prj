package kr.co.sist.aws.team2.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import kr.co.sist.aws.team2.dao.AccountsDAO;
import kr.co.sist.aws.team2.dao.SignInDAO;
import kr.co.sist.aws.team2.vo.UserVO;

@Component
public class AccountsService {
	
	@Autowired
	private SignInDAO signInDAO;
	@Autowired
	private AccountsDAO accountsDAO;

	public UserVO signIn(String id, String password) throws SQLException, EmptyResultDataAccessException {
		UserVO userVO = new UserVO();

		userVO = signInDAO.signIn(id, password);

		return userVO;
	}
	
	public List<UserVO> loadAllUser() throws SQLException {
		List<UserVO> list = null;
		
		list = accountsDAO.selectAllUser();
		
		return list;
	}
	
	
}
