package com.student.teacher.web.client.service;

import java.util.HashSet;
import java.util.Set;

import com.student.teacher.web.client.entity.Student;
import com.student.teacher.web.client.entity.Teacher;

public interface SchoolAppService {
		
	public Student addNewStudent(Student student);
	
	public Teacher addNewTeacher(Teacher teacher);
	
	public Teacher registerStudent(String teacherMailId, Set<String> studentsMailId);

	public Teacher deRegisterStudent(String teacher, String students, String reason);

	public Set<Student> findCommonStudents(Set<String> teachers);

	public Set<Teacher> findAllTeachers();

}
