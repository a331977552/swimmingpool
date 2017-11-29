package uk.co.jsmondswimmingpool.entity.custom;

import java.util.List;

import uk.co.jsmondswimmingpool.entity.Courseitem;

public class CourseItemVo {
	 List<Courseitem> items;
	 Long courseId;
	public List<Courseitem> getItems() {
		return items;
	}
	public void setItems(List<Courseitem> items) {
		this.items = items;
	}
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	
}
