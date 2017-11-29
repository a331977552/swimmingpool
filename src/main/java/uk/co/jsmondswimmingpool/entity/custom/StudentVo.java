package uk.co.jsmondswimmingpool.entity.custom;

import java.util.List;

import uk.co.jsmondswimmingpool.entity.Attendance;
import uk.co.jsmondswimmingpool.entity.Course;
import uk.co.jsmondswimmingpool.entity.Finishstatus;
import uk.co.jsmondswimmingpool.entity.Student;

public class StudentVo {

	Student student;
	Attendance attendance;
	public Attendance getAttendance() {
		return attendance;
	}

	public void setAttendance(Attendance attendance) {
		this.attendance = attendance;
	}

	List<Course> courses;
	List<Finishstatus> finishstatus;
	public List<Finishstatus> getFinishstatus() {
		return finishstatus;
	}

	public void setFinishstatus(List<Finishstatus> finishstatus) {
		this.finishstatus = finishstatus;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	Boolean getFinished;
	
	

	public Boolean getGetFinished() {
		return getFinished;
	}

	public void setGetFinished(Boolean getFinished) {
		this.getFinished = getFinished;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	
}
