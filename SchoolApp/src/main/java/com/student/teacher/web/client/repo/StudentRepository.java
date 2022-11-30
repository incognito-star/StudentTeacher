package com.student.teacher.web.client.repo;

import java.util.Collection;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.student.teacher.web.client.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	
	@Query(value = "SELECT * FROM student u WHERE u.email IN ?1", nativeQuery = true)
	Set<Student> findStudentByEmailList(Collection<String> email);
	
	@Query(value = "SELECT * FROM student u WHERE u.email = ?1", nativeQuery = true)
	Student findStudentByEmail(String email);
	
	//@Query(value = "SELECT s.* FROM student s JOIN teacherStudent ts JOIN ts.teacher t where t.email IN (?)", nativeQuery = true)
	
	@Query(value = "SELECT s.* FROM student s INNER JOIN s.teachers t AND t.email IN (?)", nativeQuery = true) 
	Set<Student> findCommonStudents(Collection<String> email);
	
	
	

}
