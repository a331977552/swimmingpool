package uk.co.jsmondswimmingpool.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import uk.co.jsmondswimmingpool.entity.Achievement;
import uk.co.jsmondswimmingpool.entity.Attendance;
import uk.co.jsmondswimmingpool.entity.Finishstatus;
import uk.co.jsmondswimmingpool.entity.Student;
import uk.co.jsmondswimmingpool.entity.custom.CommonEntity;
import uk.co.jsmondswimmingpool.entity.custom.StudentVo;
import uk.co.jsmondswimmingpool.service.IStudentService;

@Controller
@RequestMapping(value = "/api/student")
public class StudentController {

	@Autowired
	IStudentService service;

	@RequestMapping(value = "/students", method = RequestMethod.POST)
	public @ResponseBody CommonEntity getAllStudents(@RequestBody(required=false) StudentVo vo) {
			
		CommonEntity result = service.getAll(vo);
		
		return result;
	}
	@RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
	public @ResponseBody CommonEntity getAllStudentsByCourseId(@PathVariable("id") Long id) {
		
		CommonEntity result = service.getAllByCourseId(id);
		
		return result;
	}

	
	
	@RequestMapping(value = "/attendance", method = RequestMethod.POST)
	public @ResponseBody CommonEntity getAttendanceRecord(@RequestBody(required=true) Attendance vo) {
		CommonEntity result = service.getAttendanceRecord(vo);
		
		return result;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody CommonEntity getStudentById(@PathVariable(name="id") Long id) {
			
			
			CommonEntity stu = service.findById(id);

		return stu;
	}




	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody CommonEntity addStudent(@RequestBody Student student) {
			
			CommonEntity result = service.addStudent(student);
		
		return result;
	}

	@RequestMapping(method = RequestMethod.PATCH)
	public @ResponseBody CommonEntity updateStudent(@RequestBody Student student) {
	
			CommonEntity result = service.updateStudent(student);
		
		return result;
	}

	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public @ResponseBody CommonEntity deleteStudent(@PathVariable(name="id") Long id) {
	
			CommonEntity commonEntity = service.deleteStudent(id);
		
		return commonEntity;
	}

	@RequestMapping(value="/achievement/{id}",method = RequestMethod.GET)
	public @ResponseBody CommonEntity getAchievement(@PathVariable(name="id") Long id) {
	
			
			
		
		return service.getAchievement(id);
	}
	
	


	
	
	//TODO finish a course
	

	@RequestMapping(value="/finishcourse",method = RequestMethod.POST)
	public @ResponseBody CommonEntity finishCourse(@RequestBody Finishstatus finish) {
	
			CommonEntity commonEntity = service.finishCourse(finish);
		
		return commonEntity;
	}
	
	
	@RequestMapping(value="/signin",method = RequestMethod.POST)
	public @ResponseBody CommonEntity signIn(@RequestBody Attendance attendance) {
		
		CommonEntity commonEntity = service.signIn(attendance);
		
		return commonEntity;
	}
	
	@RequestMapping(value="/achievemnt",method = RequestMethod.POST)
	public @ResponseBody CommonEntity signIn(@RequestBody Achievement achievement) {
		
		CommonEntity commonEntity = service.achieve(achievement);
		
		return commonEntity;
	}
	
}
