package uk.co.jsmondswimmingpool.service;

import uk.co.jsmondswimmingpool.entity.Course;
import uk.co.jsmondswimmingpool.entity.CourseChoosing;
import uk.co.jsmondswimmingpool.entity.Student;
import uk.co.jsmondswimmingpool.entity.custom.PageBean;
import uk.co.jsmondswimmingpool.entity.custom.TutorVo;

public interface ICourseService {

	PageBean<Student> getAll(Course vo);

	Course addCourse(Course course);

	Course deleteCourse(Course course);

	PageBean<Student> assignTutor(Long id);

	Course assignTutorBytutorId(Course course);

	CourseChoosing chooseCourse(CourseChoosing choose);

	CourseChoosing changeCourse(CourseChoosing choose);

	PageBean<Student> getAllByTutor(TutorVo vo);

}
