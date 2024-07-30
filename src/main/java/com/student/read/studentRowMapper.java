package com.student.read;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class studentRowMapper implements RowMapper<students> {

	@Override
	public students mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		students stud = new students();
		
		stud.setStudentId(rs.getInt("studentId"));
		stud.setStudentName(rs.getString("studentName"));
		stud.setStudentCourse(rs.getString("studentCourse"));
		stud.setStudentPhone(rs.getString("studentPhone"));
		stud.setStudentAddress(rs.getString("studentAddress"));
		
		
		
		return stud;
	}

}
