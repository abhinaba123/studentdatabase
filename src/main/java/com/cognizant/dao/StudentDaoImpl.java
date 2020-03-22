package com.cognizant.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cognizant.model.Student;

@Repository
@Service("studentDao")
public class StudentDaoImpl implements StudentDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public String insert(Student s) {

		String sql = "insert into students values(?,?,?)";
		int result = jdbcTemplate.update(sql, s.getId(), s.getName(), s.getMarks());
		if(result>0)
		{
			return "SUCCESS";
		}
		return "FAILURE";
	}

	@Override
	public List<Student> getAll() {
		String query = "select * from students";
		return jdbcTemplate.query(query,
				(rs, rowNum) -> new Student(rs.getInt(1), rs.getString(2), rs.getFloat(3)));

	}

}
