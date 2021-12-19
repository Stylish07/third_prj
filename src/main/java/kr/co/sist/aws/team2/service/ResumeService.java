package kr.co.sist.aws.team2.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import kr.co.sist.aws.team2.dao.CareerDAO;
import kr.co.sist.aws.team2.dao.CertificateDAO;
import kr.co.sist.aws.team2.dao.EducationDAO;
import kr.co.sist.aws.team2.dao.LanguageDAO;
import kr.co.sist.aws.team2.vo.CareerVO;
import kr.co.sist.aws.team2.vo.CertificateVO;
import kr.co.sist.aws.team2.vo.EducationVO;
import kr.co.sist.aws.team2.vo.LanguageVO;

@Component
public class ResumeService {
	
	@Autowired
	private CareerDAO careerDAO;
	@Autowired
	private EducationDAO educationDAO; 
	@Autowired
	private CertificateDAO certificateDAO; 
	@Autowired
	private LanguageDAO languageDAO;
	
	public CareerVO loadCareer(String id) throws SQLException, EmptyResultDataAccessException {
		CareerVO careerVO = new CareerVO();
		
		careerVO = careerDAO.selectCareer(id);
		
		return careerVO;
	}
	
	public EducationVO loadEducation(String id) throws SQLException, EmptyResultDataAccessException {
		EducationVO educationVO = new EducationVO();
		
		educationVO = educationDAO.selectEducation(id);
		
		return educationVO;
	}
	
	public CertificateVO loadCertificate(String id) throws SQLException, EmptyResultDataAccessException {
		CertificateVO certificateVO = new CertificateVO();
		
		certificateVO = certificateDAO.selectCertificate(id);
		
		return certificateVO;
	}
	
	public LanguageVO loadlanguage(String id) throws SQLException, EmptyResultDataAccessException {
		LanguageVO languageVO = new LanguageVO();
		
		languageVO = languageDAO.selectLanguage(id);
		
		return languageVO;
	}
	
	public void saveCareer(CareerVO careerVO) {
		try {
			careerDAO.selectCareer(careerVO.getId());
			
			// 저장된 career가 DB에 있을 때
			careerDAO.updateCareer(careerVO);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (EmptyResultDataAccessException e) {
			// 저장된 career가 DB에 없을 때
			careerDAO.insertCareer(careerVO);
		}
	}
	
	public void saveEducation(EducationVO educationVO) {
		try {
			educationDAO.selectEducation(educationVO.getId());
			
			// 저장된 career가 DB에 있을 때
			educationDAO.updateEducation(educationVO);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (EmptyResultDataAccessException e) {
			// 저장된 career가 DB에 없을 때
			educationDAO.insertEducation(educationVO);
		}
	}
	
	public void saveCertificate(CertificateVO certificateVO) {
		try {
			certificateDAO.selectCertificate(certificateVO.getId());
			
			// 저장된 career가 DB에 있을 때
			certificateDAO.updateCertificate(certificateVO);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (EmptyResultDataAccessException e) {
			// 저장된 career가 DB에 없을 때
			certificateDAO.insertCertificate(certificateVO);
		}
	}
	
	public void saveLanguage(LanguageVO languageVO) {
		try {
			languageDAO.selectLanguage(languageVO.getId());
			
			// 저장된 career가 DB에 있을 때
			languageDAO.updateLanguage(languageVO);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (EmptyResultDataAccessException e) {
			// 저장된 career가 DB에 없을 때
			languageDAO.insertLanguage(languageVO);
		}
	}
	
	public void resetCareer(String id) {
		careerDAO.deleteCareer(id);
	}
	
	public void resetEducatino(String id) {
		educationDAO.deleteEducation(id);
	}
	
	public void resetCertificate(String id) {
		certificateDAO.deleteCertificate(id);
	}
	
	public void resetLanguage(String id) {
		languageDAO.deleteLanguage(id);
	}
	
}
