package uk.co.jsmondswimmingpool.entity.custom;

public class CourseChangeVo {
	
	private Long studentId;
	private Long courseId;
	private Long previousCourseId;
	

	
	
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public Long getPreviousCourseId() {
		return previousCourseId;
	}
	public void setPreviousCourseId(Long previousCourseId) {
		this.previousCourseId = previousCourseId;
	}
	
}
