package com.latihan.repository;

import java.util.List;

import com.latihan.model.StudentModel;



public interface IStudentRepository {
	
	public StudentModel insertStudent(StudentModel student);
	public StudentModel updateStudent(int Id, StudentModel student);
	public StudentModel deleteStudent(int Id);
	public StudentModel getIdStudent(int Id);
	public List<StudentModel> getAllStudent();
}
