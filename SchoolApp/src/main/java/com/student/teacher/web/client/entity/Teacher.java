package com.student.teacher.web.client.entity;

import java.util.HashSet;
import java.util.Set;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="teacher")
public class Teacher {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="t_id")
	private Long tId;
	private String name;
	@Column(unique=true)
	private String email;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "TEACHER_STUDENT",
            joinColumns = {
                    @JoinColumn(name = "teacher_id", referencedColumnName = "t_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "student_id", referencedColumnName = "s_id")
            }
    )
	private Set<Student> students= new HashSet<Student>();
	
		
	public Teacher(Long tId, String name, String email) {
		super();
		this.tId = tId;
		this.name = name;
		this.email = email;
	}
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long gettId() {
		return tId;
	}
	public void settId(Long tId) {
		this.tId = tId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
	
	/*
	 * public void addStudent(Student student) { this.students.add(student);
	 * student.getTeachers().add(this); }
	 * 
	 * public void removeStudent(long studentId) { Student student =
	 * this.students.stream().filter(t -> t.getsId() ==
	 * studentId).findFirst().orElse(null); if (student != null) {
	 * this.students.remove(student); student.getTeachers().remove(this); } }
	 */


}
