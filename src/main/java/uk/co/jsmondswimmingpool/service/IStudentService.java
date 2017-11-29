package uk.co.jsmondswimmingpool.service;

import uk.co.jsmondswimmingpool.entity.Achievement;
import uk.co.jsmondswimmingpool.entity.Attendance;
import uk.co.jsmondswimmingpool.entity.Finishstatus;
import uk.co.jsmondswimmingpool.entity.Student;
import uk.co.jsmondswimmingpool.entity.custom.CommonEntity;
import uk.co.jsmondswimmingpool.entity.custom.StudentVo;

public interface IStudentService {
/*
	 * get all student related to today's course;
	 * get a student's attendance history by course and date and student's id
	 * add student
	 * update student
	 * delete student
	 * get a student from search
	*/
	
	CommonEntity getAll(StudentVo vo) ;

	CommonEntity findById(Long id) ;

	CommonEntity addStudent(Student student) ;

	CommonEntity updateStudent(Student student)  ;

	CommonEntity deleteStudent(Long id) ;
	
	CommonEntity getAttendanceRecord(Attendance id) ;

	CommonEntity finishCourse(Finishstatus finish);

	CommonEntity getAchievement(Long id);

	CommonEntity getAllByCourseId(Long id);

	CommonEntity signIn(Attendance attendance);

	CommonEntity achieve(Achievement achievement);
	
	


}
