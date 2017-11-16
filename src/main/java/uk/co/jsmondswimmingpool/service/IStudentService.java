package uk.co.jsmondswimmingpool.service;

import java.util.List;

import uk.co.jsmondswimmingpool.entity.Achievement;
import uk.co.jsmondswimmingpool.entity.Student;
import uk.co.jsmondswimmingpool.entity.StudentExample;
import uk.co.jsmondswimmingpool.entity.custom.PageBean;
import uk.co.jsmondswimmingpool.entity.custom.SignVo;
import uk.co.jsmondswimmingpool.entity.custom.StudentVo;
import uk.co.jsmondswimmingpool.entity.custom.TutorVo;

public interface IStudentService {

	PageBean<Student> getAll(StudentVo vo) throws Exception;

	Student findById(Long id) throws Exception;

	PageBean<Student> getStudentsByTutorId(TutorVo toturVo) throws Exception;

	Student addStudent(Student student) throws Exception;

	Student updateStudent(Student student) throws Exception;

	void deleteStudent(Long id) throws Exception;
	Long getNumberOfStudent(StudentExample example) throws Exception;

	List<SignVo> geStudentsSignStatusByTutorId(Long id);

	List<Achievement> getAchievement(Long id);

}
