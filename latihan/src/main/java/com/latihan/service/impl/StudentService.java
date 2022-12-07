package com.latihan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.latihan.model.StudentModel;
import com.latihan.repository.IStudentRepository;
import com.latihan.service.IStudentService;

@Service
public class StudentService implements IStudentService{
@Autowired
 IStudentRepository StudentRepository;
	@Override
	public StudentModel insertStudent(StudentModel student) {
		// TODO Auto-generated method stub
		return StudentRepository.insertStudent(student);
	}

	@Override
	public StudentModel updateStudent(int id, StudentModel student) {
		// TODO Auto-generated method stub
		return StudentRepository.updateStudent(id,student);
	}

	@Override
	public StudentModel deleteStudent(int id) {
		// TODO Auto-generated method stub
		return StudentRepository.deleteStudent(id);
	}

	@Override
	public StudentModel getIdStudent(int Id) {
		// TODO Auto-generated method stub
		
		return StudentRepository.getIdStudent(Id);
	}



	@Override
	public List<StudentModel> getAllStudent() {
		return StudentRepository.getAllStudent();
	
	}

}
