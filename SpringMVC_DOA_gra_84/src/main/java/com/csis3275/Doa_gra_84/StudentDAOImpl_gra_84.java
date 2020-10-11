package com.csis3275.Doa_gra_84;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.csis3275.Model_gra_84.StudentMapper_gra_84;
import com.csis3275.Model_gra_84.Student_gra_84;


@Component
public class StudentDAOImpl_gra_84 {

	JdbcTemplate jdbcTemplate;
	
	private final String SQL_GET_ALL = "SELECT * FROM students";
	private final String SQL_CREATE_STUDENT = "INSERT INTO students (name, email) VALUES (?,?)";
	private final String SQL_DELETE_STUDENT = "DELETE FROM students WHERE id = ?";

	@Autowired
	public StudentDAOImpl_gra_84(DataSource dataSource)	{
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Student_gra_84> getAllStudents()	{
		return jdbcTemplate.query(SQL_GET_ALL, new StudentMapper_gra_84());
		
	}
	
	public boolean createStudent(Student_gra_84 newStudent) {
		return jdbcTemplate.update(SQL_CREATE_STUDENT, newStudent.getName(), newStudent.getEmail()) > 0;
	}
	
	public boolean deleteStudent(int idToDelete) {
		return jdbcTemplate.update(SQL_DELETE_STUDENT, idToDelete) > 0;
	}
	
	
	
	
	
}
