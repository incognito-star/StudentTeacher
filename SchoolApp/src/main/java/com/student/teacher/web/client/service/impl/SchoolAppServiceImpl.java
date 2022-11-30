package com.student.teacher.web.client.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.teacher.web.client.entity.Student;
import com.student.teacher.web.client.entity.Teacher;
import com.student.teacher.web.client.repo.StudentRepository;
import com.student.teacher.web.client.repo.TeacherRepository;
import com.student.teacher.web.client.service.SchoolAppService;

@Service
public class SchoolAppServiceImpl implements SchoolAppService{
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	TeacherRepository teacherRepository;
	
	@Override
	public Student addNewStudent(Student student) {
		return studentRepository.save(student);
		
	}
	
	@Override
	public Teacher addNewTeacher(Teacher teacher) {
		return teacherRepository.save(teacher);
	}
	
	@Override
	public Teacher registerStudent(String teacherMailId, Set<String> studentsMailId) {
		
		Teacher teacher = teacherRepository.findbyEmail(teacherMailId);
		Set<Student> studentList = studentRepository.findStudentByEmailList(studentsMailId);
		
		studentList.addAll(teacher.getStudents());
		teacher.setStudents(studentList);
		
		return teacherRepository.save(teacher);
		
	}

	@Override
	public Teacher deRegisterStudent(String teacherMailId, String studentsMailId, String reason) {
		
		Teacher teacher = teacherRepository.findbyEmail(teacherMailId);
		Student studenttoDeRegister = studentRepository.findStudentByEmail(studentsMailId);
		
		teacher.getStudents().remove(studenttoDeRegister);
		
		return teacherRepository.save(teacher);
	}

	@Override
	public Set<Student> findCommonStudents(Set<String> teachers) {
		
		Set<Student> studentList = studentRepository.findCommonStudents(teachers);
				
		return studentList;
		
	}

	@Override
	public Set<Teacher> findAllTeachers() {
		
		return new HashSet(teacherRepository.findAll());
	}

}
