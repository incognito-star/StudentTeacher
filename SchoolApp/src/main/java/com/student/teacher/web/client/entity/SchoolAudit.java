package com.student.teacher.web.client.entity;

import java.sql.Timestamp;
import java.util.Set;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

public class SchoolAudit {
	
	private long id;
	private String requestedBy;
	private String reason;
	@Temporal(TemporalType.DATE)
	private Timestamp createdDate;
	@Temporal(TemporalType.DATE)
	private Timestamp uptedDate;
	private String action;
	private String isProcessed;
	private String teacher;
	private String student;
	private Set<String> students;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRequestedBy() {
		return requestedBy;
	}
	public void setRequestedBy(String requestedBy) {
		this.requestedBy = requestedBy;
	}
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	public Timestamp getUptedDate() {
		return uptedDate;
	}
	public void setUptedDate(Timestamp uptedDate) {
		this.uptedDate = uptedDate;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getIsProcessed() {
		return isProcessed;
	}
	public void setIsProcessed(String isProcessed) {
		this.isProcessed = isProcessed;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public Set<String> getStudents() {
		return students;
	}
	public void setStudents(Set<String> students) {
		this.students = students;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getStudent() {
		return student;
	}
	public void setStudent(String student) {
		this.student = student;
	}

}
 