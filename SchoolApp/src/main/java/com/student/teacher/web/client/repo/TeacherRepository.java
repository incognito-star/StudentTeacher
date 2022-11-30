package com.student.teacher.web.client.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.student.teacher.web.client.entity.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long>{
	
	
	@Query(value = "SELECT * FROM teacher u WHERE u.email = ?1", 
			  nativeQuery = true)
	Teacher findbyEmail(String email);

}
