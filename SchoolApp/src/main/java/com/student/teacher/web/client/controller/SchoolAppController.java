package com.student.teacher.web.client.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.teacher.web.client.common.Constants;
import com.student.teacher.web.client.entity.SchoolAudit;
import com.student.teacher.web.client.entity.Student;
import com.student.teacher.web.client.entity.Teacher;
import com.student.teacher.web.client.exception.ResourceNotFoundException;
import com.student.teacher.web.client.service.SchoolAppService;
import com.student.teacher.web.client.util.SchoolUtil;

@RestController
@RequestMapping("/api")
public class SchoolAppController {
	
	static final Logger logger = LoggerFactory.getLogger(SchoolAppController.class);
	
	@Autowired
	SchoolAppService schoolService;
	
	@Autowired
	SchoolUtil util;
	
	@PostMapping("/students")
	public ResponseEntity<?> addStudent(@RequestBody Student student) throws ResourceNotFoundException {
		
		logger.info(this.getClass().getName()+Constants.Starts);
		Student newStudent = null;
		
		if(util.isStudentEntity(student.getEmail())) 
		  newStudent = schoolService.addNewStudent(student);
		logger.info(this.getClass().getName()+Constants.Ends);
		if (newStudent == null) {
	        return ResponseEntity.notFound().build();
	    } else {
	        return ResponseEntity.status(HttpStatus.CREATED).build();
	    }
		
	}
	
	@RequestMapping(value = "/teachers", method = RequestMethod.POST, consumes="application/json")
	public ResponseEntity<?> addTeacher(@RequestBody Teacher teacher) throws ResourceNotFoundException {
		Teacher newTeacher = null;
		logger.info(this.getClass().getName()+Constants.Starts);
		if(util.isTeacherEntity(teacher.getEmail())) 
			newTeacher = schoolService.addNewTeacher(teacher);
		logger.info(this.getClass().getName()+Constants.Ends);
		if (newTeacher == null) {
	        return ResponseEntity.notFound().build();
	    } else {
	        return ResponseEntity.status(HttpStatus.CREATED).build();
	    }
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> resigterStudentsToTeacher(@RequestBody SchoolAudit schoolAudit) {//throws ResourceNotFoundException {
		Teacher newTeacher = null;
		
		String teacher = schoolAudit.getTeacher();
		Set<String> students = schoolAudit.getStudents();
		
		if(util.isTeacherEntity(teacher) && util.isValidMultiStudent(students))
			newTeacher = schoolService.registerStudent(teacher, students);
		
		if (newTeacher == null) {
	        return ResponseEntity.notFound().build();
	    } else {
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	    }
	}
	
	@PostMapping("/deregister")
	public ResponseEntity<?> deResigterStudentsToTeacher(@RequestBody SchoolAudit schoolAudit) {//throws ResourceNotFoundException {
		Teacher newTeacher = null;
		
		String teacher = schoolAudit.getTeacher();
		String student = schoolAudit.getStudent();
		
		if(util.isTeacherEntity(teacher) && util.isStudentEntity(student))
			newTeacher = schoolService.deRegisterStudent(teacher, student,schoolAudit.getReason() );
		
		if (newTeacher == null) {
	        return ResponseEntity.notFound().build();
	    } else {
	        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	    }
	}
	
	
	@GetMapping("/commonstudents")
	@ResponseBody
	public ResponseEntity<Set<Student>> retrieveCommonStudents(@RequestParam String[] teacher) throws ResourceNotFoundException {
		
		Set<Student> studentList = null;
		if(teacher.length> 0 && util.isValidMultiTeacher(teacher))
			studentList = schoolService.findCommonStudents(new HashSet<String>(Arrays.asList(teacher)));
		
		return ResponseEntity.ok().body(studentList);
	    
	}
	
	
	@GetMapping("/teachers")
	@ResponseBody
	public ResponseEntity<Set<Teacher>> retrieveAllTeachers() throws ResourceNotFoundException {
		
		Set<Teacher> teacherList = schoolService.findAllTeachers();
		
		return ResponseEntity.ok().body(teacherList);
	    
	}
	
	
	
	

}
