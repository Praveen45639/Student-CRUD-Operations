package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/api/stu")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@PostMapping("/create")
	public Student createStudent(@RequestBody Student student) {
		return service.createStudent(student);
	}
  @GetMapping("/getstudents")
  public List<Student> getAllStudents(){
	  return service.getAllStudents();
  }
  @PutMapping("/update/{sid}")
  public ResponseEntity<Student> updateStudent(@PathVariable int sid,@RequestBody Student student) {
	  Student update=service.updateStudent(sid, student);
	return ResponseEntity.ok(update);  
  }
  @GetMapping("/get/{sid}")
  public Student getById(@PathVariable int sid) {
	  return service.getById(sid);
  }
  @GetMapping("/delete/{sid}")
  public String deleteById(@PathVariable int sid) {
	  service.deleteById(sid);
	  return "student deleted successfully";
  }
}
