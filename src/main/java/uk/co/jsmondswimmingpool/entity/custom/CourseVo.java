package uk.co.jsmondswimmingpool.entity.custom;

import java.util.List;

import uk.co.jsmondswimmingpool.entity.Course;
import uk.co.jsmondswimmingpool.entity.Courseitem;
import uk.co.jsmondswimmingpool.entity.Coursetimetable;

public class CourseVo {

	private Course course;
	private List<Courseitem> courseitem;
	private List<Coursetimetable> coursetimetable;
	
	
	public List<Courseitem> getCourseitem() {
		return courseitem;
	}
	public void setCourseitem(List<Courseitem> courseitem) {
		this.courseitem = courseitem;
	}
	public List<Coursetimetable> getCoursetimetable() {
		return coursetimetable;
	}
	public void setCoursetimetable(List<Coursetimetable> coursetimetable) {
		this.coursetimetable = coursetimetable;
	}
	private Integer currentPage;
	private Integer pageSize;
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
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
}
