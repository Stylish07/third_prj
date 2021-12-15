package kr.co.sist.aws.team2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import kr.co.sist.aws.team2.vo.CareerVO;

@Component
public class CareerDAO {

	@Autowired(required = false)
	private JdbcTemplate jt;

	public CareerVO selectCareer(String id) throws SQLException {
		CareerVO cVO = new CareerVO();

		String query = "select * from career where id = '" + id + "'";

		cVO = jt.queryForObject(query, new RowMapper<CareerVO>() {

			@Override
			public CareerVO mapRow(ResultSet rs, int rowCnt) throws SQLException {
				CareerVO cVO = new CareerVO();

				cVO.setIdx(rs.getInt("idx"));
				cVO.setCompany(rs.getString("company"));
				cVO.setTask(rs.getString("task"));
				cVO.setPeriod(rs.getString("period"));
				cVO.setDescription(rs.getString("description"));
				cVO.setTech(rs.getString("tech"));

				return cVO;
			}
		});

		return cVO;
	}

}
