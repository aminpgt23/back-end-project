package com.latihan.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.latihan.model.StudentModel;
import com.latihan.repository.IStudentRepository;

@Repository
public class StudentRepository implements IStudentRepository{
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public StudentModel insertStudent(StudentModel student) {
		// TODO Auto-generated method stub
		String query ="INSERT INTO tb_student(deskripsi_diri,email,hard_skill,interest,jenis_kelamin,nama,soft_skill,umur)"
				+"VALUES(?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(query,new Object[] {student.getDeskripsi_diri(),student.getEmail(),student.getHard_skill(),student.getInterest(),
				student.getJenis_kelamin(),student.getNama(),student.getSoft_skill(),student.getUmur()
		});
		return student;
	}

	@Override
	public StudentModel updateStudent(int Id, StudentModel student) {
		// TODO Auto-generated method stub
		String query =" UPDATE tb_student SET deskripsi_diri  = ?,email = ?,hard_skill = ?,interest = ?,jenis_kelamin  =?,nama = ?,"
				+ " soft_skill = ?,umur = ? WHERE id = ?";
		jdbcTemplate.update(query,new Object[] {student.getDeskripsi_diri(),student.getEmail(),student.getHard_skill(),student.getInterest(),
				student.getJenis_kelamin(),student.getNama(),student.getSoft_skill(),student.getUmur(),Id});
		
		return student;
	}

	@Override
	public StudentModel deleteStudent(int Id) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_student WHERE id = ?";
		var result = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(StudentModel.class), Id);
		query = " DELETE FROM tb_student WHERE id = ?";
		jdbcTemplate.update(query, Id);
		return result;
	}

	@Override
	public StudentModel getIdStudent(int Id) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_student WHERE id = ?";
		var result = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(StudentModel.class), Id);
		return result;
	}


	@Override
	public List<StudentModel> getAllStudent() {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_student";
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(StudentModel.class));
	
	}
	


}
