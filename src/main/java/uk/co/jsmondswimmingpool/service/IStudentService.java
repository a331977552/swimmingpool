package uk.co.jsmondswimmingpool.service;

import uk.co.jsmondswimmingpool.entity.Student;
import uk.co.jsmondswimmingpool.entity.StudentExample;
import uk.co.jsmondswimmingpool.entity.custom.PageBean;
import uk.co.jsmondswimmingpool.entity.custom.StudentVo;
import uk.co.jsmondswimmingpool.entity.custom.TutorVo;

public interface IStudentService {

	PageBean<Student> getAll(StudentVo vo) throws Exception;

	Student findById(Long id) throws Exception;

	PageBean<Student> getStudentsByTutorId(TutorVo toturVo) throws Exception;

	Student addStudent(Student student) throws Exception;

	Student updateStudent(Student student) throws Exception;

	void deleteStudent(Student student) throws Exception;
	Long getNumberOfStudent(StudentExample example) throws Exception;

}
