package com.latihan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.latihan.model.StudentModel;
import com.latihan.service.IStudentService;

@RestController
@CrossOrigin(origins ="http://localhost:8080")
@RequestMapping("/api/student")
public class StudentController {
  @Autowired
  IStudentService StudentService;
  
  @PostMapping("/insert")
  public StudentModel insertStudent(@RequestBody StudentModel student) {
	return StudentService.insertStudent(student);
	  
  }
  
  @PutMapping("/update/{Id}")
  public StudentModel updateStudent( @PathVariable int Id, @RequestBody StudentModel student) {
	return StudentService.updateStudent(Id, student);
	  
  }
  @DeleteMapping("/delete/{Id}")
  public StudentModel deleteStudent(@PathVariable int Id) {
	  return StudentService.deleteStudent(Id);
  }
  
  @GetMapping("/getById/{Id}")
  public StudentModel getIdStudent(@PathVariable int Id) {
	  return StudentService.getIdStudent(Id);
  }

	@GetMapping("/getAll")
	public List<StudentModel> getAllStudent(){
		return StudentService.getAllStudent();
	}
}
