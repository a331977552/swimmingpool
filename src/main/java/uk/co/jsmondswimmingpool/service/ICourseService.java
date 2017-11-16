package uk.co.jsmondswimmingpool.service;

import java.util.List;

import uk.co.jsmondswimmingpool.entity.Course;
import uk.co.jsmondswimmingpool.entity.CourseChoosing;
import uk.co.jsmondswimmingpool.entity.Student;
import uk.co.jsmondswimmingpool.entity.custom.CommonEntity;
import uk.co.jsmondswimmingpool.entity.custom.CourseVo;
import uk.co.jsmondswimmingpool.entity.custom.PageBean;
import uk.co.jsmondswimmingpool.entity.custom.TutorVo;

public interface ICourseService {

	PageBean<Student> getAll(CourseVo vo) throws Exception;


	CommonEntity deleteCourse(Course course) throws Exception;


	CommonEntity changeCourseTutorBytutorId(Course course) throws Exception;

	CourseChoosing chooseCourse(CourseChoosing choose) throws Exception;

	CourseChoosing changeCourse(CourseChoosing choose) throws Exception;

	CommonEntity updateCourse(Course choose);

	CommonEntity addCourse(CourseVo course) throws Exception;


	List<Course> getCourseByStudentId(Long id);



}
