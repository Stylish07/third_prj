package kr.co.sist.aws.team2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import kr.co.sist.aws.team2.vo.CertificateVO;

@Component
public class CertificateDAO {
	
	@Autowired(required = false)
	private JdbcTemplate jt;
	
	public CertificateVO selectCertificate(String id) throws SQLException, EmptyResultDataAccessException {
		CertificateVO certificateVO = new CertificateVO();
		String query = "select * from certificate where id = ?";

		certificateVO = jt.queryForObject(query, new Object[] { id }, new RowMapper<CertificateVO>() {

			@Override
			public CertificateVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				CertificateVO certificateVO = new CertificateVO();

				certificateVO.setIdx(rs.getInt("idx"));
				certificateVO.setTitle(rs.getString("title"));
				certificateVO.setGet_date(rs.getString("get_date"));
				certificateVO.setDescription(rs.getString("description"));
				
				return certificateVO;
			}

		});

		return certificateVO;
	}
	
	public void insertCertificate(CertificateVO certificateVO) {
		String query = "insert into certificate(idx, title, get_date, description, id) values(cert_seq.nextval, ?, ?, ?, ?)";
		
		jt.update(query, certificateVO.getTitle(), certificateVO.getGet_date(), certificateVO.getDescription(), certificateVO.getId());
	}
	
	public void updateCertificate(CertificateVO certificateVO) {
		String query = "update certificate set title = ?, get_date = ?, description = ? where id = ?";
		
		jt.update(query, certificateVO.getTitle(), certificateVO.getGet_date(), certificateVO.getDescription(), certificateVO.getId());
	}
	
	public void deleteCertificate(String id) {
		String query = "delete certificate where id =?";
		
		jt.update(query, id);
	}
	
}
