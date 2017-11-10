package uk.co.jsmondswimmingpool.entity.custom;

import java.util.List;

import uk.co.jsmondswimmingpool.entity.Student;

public class StudentVo {
	
	private Integer currentPage;
	private Integer pageSize;
	private Student student;
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}

	
}
