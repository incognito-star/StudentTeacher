package com.student.teacher.web.client.util;

import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class SchoolUtil {
	
	public boolean isStudentEntity(String input) {
		if(!input.isEmpty() && input.contains("student"))
			return true;
		else return false;
	}
	
	public boolean isTeacherEntity(String input) {
		if(!input.isEmpty() && input.contains("teacher"))
			return true;
		else return false;
	}
	
	public boolean isValidMultiStudent(Set<String> input) {
		boolean isValid = false;
		for(String mail : input)
		{
			isValid = isStudentEntity(mail);
		}
		return isValid;
	}
	
	
	public boolean isValidMultiTeacher(String[] input) {
		boolean isValid = false;
		for(String mail : input)
		{
			isValid = isTeacherEntity(mail);
		}
		return isValid;
	}

}
