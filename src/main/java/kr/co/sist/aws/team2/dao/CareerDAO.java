package kr.co.sist.aws.team2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import kr.co.sist.aws.team2.vo.CareerVO;

@Component
public class CareerDAO {

	@Autowired(required = false)
	private JdbcTemplate jt;

	public CareerVO selectCareer(String id) throws SQLException, EmptyResultDataAccessException {
		CareerVO careerVO = new CareerVO();

		String query = "select * from career where id = ?";

		careerVO = jt.queryForObject(query, new Object[] { id }, new RowMapper<CareerVO>() {

			@Override
			public CareerVO mapRow(ResultSet rs, int rowCnt) throws SQLException {
				CareerVO careerVO = new CareerVO();

				careerVO.setIdx(rs.getInt("idx"));
				careerVO.setCompany(rs.getString("company"));
				careerVO.setTask(rs.getString("task"));
				careerVO.setPeriod(rs.getString("period"));
				careerVO.setDescription(rs.getString("description"));
				careerVO.setTech(rs.getString("tech"));

				return careerVO;
			}
		});

		return careerVO;
	}

	public void insertCareer(CareerVO careerVO) {
		String query = "insert into career(idx, company, task, period, description, tech, id) values(career_seq.nextval, ?, ?, ?, ?, ?, ?)";
		
		jt.update(query, careerVO.getCompany(), careerVO.getTask(), careerVO.getPeriod(), careerVO.getDescription(), careerVO.getTech(), careerVO.getId());
	}
	
	public void updateCareer(CareerVO careerVO) {
		String query = "update career set company = ?, task = ?, period = ?, description = ?, tech = ? where id = ?";
		
		jt.update(query, careerVO.getCompany(), careerVO.getTask(), careerVO.getPeriod(), careerVO.getDescription(), careerVO.getTech(), careerVO.getId());
	}
	
	public void deleteCareer(String id) {
		System.out.println();
		System.out.println();
		System.out.println(id);
		System.out.println();
		System.out.println();
		
		String query = "delete career where id = ?";
		
		jt.update(query, id);
	}
	
}
