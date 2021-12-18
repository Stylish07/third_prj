package kr.co.sist.aws.team2.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import kr.co.sist.aws.team2.dao.ProfileDAO;
import kr.co.sist.aws.team2.vo.ProfileVO;

@Component
public class ProfileService {

	@Autowired
	private ProfileDAO profileDAO;

	public ProfileVO loadProfile(String id) throws SQLException, EmptyResultDataAccessException {
		ProfileVO profileVO = new ProfileVO();

		profileVO = profileDAO.loadProfile(id);

		return profileVO;
	}
	
	public void saveProfile(ProfileVO profileVO) {
		try {
			profileDAO.loadProfile(profileVO.getId());
			
			// ����� �������� DB�� ���� ��
			profileDAO.updateProfile(profileVO);
		} catch (EmptyResultDataAccessException e) {
			// ����� �������� DB�� ������
			profileDAO.insertProfile(profileVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void saveImg(ProfileVO profileVO) {
		try {
			profileDAO.loadProfile(profileVO.getId());
			
			// ����� �������� DB�� ���� ��
			profileDAO.updateImg(profileVO);
		} catch (EmptyResultDataAccessException e) {
			// ����� �������� DB�� ������
			profileDAO.insertImg(profileVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
