package com.csis3275.Model_gra_84;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StudentMapper_gra_84 implements RowMapper<Student_gra_84> {
	
	public Student_gra_84 mapRow(ResultSet resultSet, int i) throws SQLException	{
	
		Student_gra_84 student = new Student_gra_84();
		student.setId(resultSet.getInt("id"));
		student.setName(resultSet.getString("name"));
		student.setEmail(resultSet.getString("email"));
		return student;
		
	}

}
