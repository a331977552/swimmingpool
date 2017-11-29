package uk.co.jsmondswimmingpool.service;

import java.util.List;

import uk.co.jsmondswimmingpool.entity.Course;
import uk.co.jsmondswimmingpool.entity.CourseChoosing;
import uk.co.jsmondswimmingpool.entity.Courseitem;
import uk.co.jsmondswimmingpool.entity.custom.CommonEntity;
import uk.co.jsmondswimmingpool.entity.custom.CourseChangeVo;
import uk.co.jsmondswimmingpool.entity.custom.CourseItemVo;
import uk.co.jsmondswimmingpool.entity.custom.CourseVo;


public interface ICourseService {
	/** 
	 * update course
	 * delete course
	 * get a all the course  ,and click it, go to new activity. show this course achievement and edit it.
	 * get a course by search
	 * get all the courses by student
	 * get all the achievements by student.
	 *  
	 * confirm a student has finished a certain course;
	 * 
	*/


	//add course
	CommonEntity addCourse(CourseVo course);
	//update course
	CommonEntity updateCourse(Course choose);
	//delete course
	CommonEntity deleteCourse(Long id);
	
	//get a all the course  ,and click it, go to new activity. show this course achievement and edit it.
	CommonEntity getAll(CourseVo vo) ;
	CommonEntity  getCourseById(Long id) ;
	CommonEntity getCourseByStudentId(Long id) ;
	//choose course
	CommonEntity chooseCourse(CourseChoosing choose) ;
	//show this course achievement and edit it.
	CommonEntity getAllItemByCourseId(Long id) ;
	//update
	CommonEntity updateItem(Courseitem achievement);
	
	//change course
	CommonEntity changeCourse(CourseChangeVo choose);
	CommonEntity addItems(CourseItemVo item);
	CommonEntity deleteItem(Long id);

}
