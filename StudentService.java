package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository srepo;
	
	//save student into database
	public Student createStudent(Student student) {
		return srepo.save(student);
	}
	//get all students
	public List<Student> getAllStudents(){
		return srepo.findAll();
	}
   //update student
	public Student updateStudent(int sid, Student student){
		Optional<Student> opst=srepo.findById(sid);
		if(opst.isPresent()) {
			Student st=opst.get();
			st.setSname(student.getSname());
			st.setCourse(student.getCourse());
			st.setFees(student.getFees());
			return srepo.save(st);
		   }
		else {
			throw new RuntimeException ("No Id Is Found To Update");
		  }	
	}
	//get student by id
	public Student getById(int sid) {
		Optional<Student> getById=srepo.findById(sid);
		if(getById.isPresent()) {
		return getById.get();
	}
		return null;
	}
	//delete by id
	public String deleteById(int sid) {
		Optional<Student> deleteById=srepo.findById(sid);
		return "delete_success";
	}
}




