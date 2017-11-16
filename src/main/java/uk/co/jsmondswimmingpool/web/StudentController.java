package uk.co.jsmondswimmingpool.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import uk.co.jsmondswimmingpool.entity.Achievement;
import uk.co.jsmondswimmingpool.entity.Student;
import uk.co.jsmondswimmingpool.entity.custom.CommonEntity;
import uk.co.jsmondswimmingpool.entity.custom.PageBean;
import uk.co.jsmondswimmingpool.entity.custom.SignVo;
import uk.co.jsmondswimmingpool.entity.custom.StudentVo;
import uk.co.jsmondswimmingpool.entity.custom.TutorVo;
import uk.co.jsmondswimmingpool.service.IStudentService;

@Controller
@RequestMapping(value = "/api/student")
public class StudentController {

	@Autowired
	IStudentService service;

	@RequestMapping(value = "/students", method = RequestMethod.POST)
	public @ResponseBody CommonEntity getAllStudents(@RequestBody(required=false) StudentVo vo) {

		CommonEntity commonEntity = new CommonEntity();
		try {
			PageBean<Student> result = service.getAll(vo);
			commonEntity.setBean(result);
			commonEntity.setMsg("success");
			commonEntity.setStatus(0);
		} catch (Exception e) {
			String message = e.getMessage();
			e.printStackTrace();
			commonEntity.setMsg("failue :"+ message);			
			commonEntity.setStatus(1);
			commonEntity.setBean(null);
		}

		return commonEntity;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody CommonEntity getStudentById(@PathVariable(name="id") Long id) {
		CommonEntity commonEntity = new CommonEntity();
			
		try {
			Student stu = service.findById(id);
			commonEntity.setBean(stu);
			commonEntity.setMsg("success");
			commonEntity.setStatus(0);
		} catch (Exception e) {
			String message = e.getMessage();
			e.printStackTrace();
			commonEntity.setMsg("failue :"+ message);
			
			commonEntity.setStatus(1);
			commonEntity.setBean(null);
		}

		return commonEntity;
	}

	@RequestMapping(value = "/tutor/students", method = RequestMethod.POST)
	public @ResponseBody CommonEntity getStudentsByTutorId(@RequestBody TutorVo toturVo) {
		CommonEntity commonEntity = new CommonEntity();
		
		try {
			PageBean<Student> stu = service.getStudentsByTutorId(toturVo);
			
			commonEntity.setBean(stu);
			commonEntity.setMsg("success");
			commonEntity.setStatus(0);
		
		} catch (Exception e) {
			String message = e.getMessage();
			e.printStackTrace();
			commonEntity.setMsg("failue :"+ message);
			commonEntity.setStatus(1);
			commonEntity.setBean(null);
		}
		
		return commonEntity;
	}



	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody CommonEntity addStudent(@RequestBody Student student) {
		CommonEntity commonEntity = new CommonEntity();
		try {
			
			Student result = service.addStudent(student);
			commonEntity.setBean(result);
			commonEntity.setMsg("success");
			commonEntity.setStatus(0);
		
		} catch (Exception e) {
			String message = e.getMessage();
			e.printStackTrace();
			commonEntity.setMsg("add failue :"+ message);
			commonEntity.setStatus(1);
			commonEntity.setBean(null);
		}
		return commonEntity;
	}

	@RequestMapping(method = RequestMethod.PATCH)
	public @ResponseBody CommonEntity updateStudent(@RequestBody Student student) {
		CommonEntity commonEntity = new CommonEntity();
		try {
			
			Student result = service.updateStudent(student);
			commonEntity.setBean(result);
			commonEntity.setMsg("success");
			commonEntity.setStatus(0);
		
		} catch (Exception e) {
			String message = e.getMessage();
			e.printStackTrace();
			commonEntity.setMsg("update failue :"+ message);
			commonEntity.setStatus(1);
			commonEntity.setBean(null);
		}
		return commonEntity;
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public @ResponseBody CommonEntity deleteStudent(@PathVariable(name="id") Long id) {
		CommonEntity commonEntity = new CommonEntity();
		try {
			
			service.deleteStudent(id);
			commonEntity.setMsg("success");
			commonEntity.setStatus(0);
		
		} catch (Exception e) {
			String message = e.getMessage();
			e.printStackTrace();
			commonEntity.setMsg("delete failue :"+ message);
			commonEntity.setStatus(1);
			commonEntity.setBean(null);
		}
		return commonEntity;
	}
	//TODO 
	@RequestMapping(value="/achievement/{id}",method = RequestMethod.GET)
	public @ResponseBody CommonEntity getAchievement(@PathVariable(name="id") Long id) {
		CommonEntity commonEntity = new CommonEntity();
		try {
		
			List<Achievement> achievement = service.getAchievement(id);
			commonEntity.setBean(achievement);
			commonEntity.setMsg("success");
			commonEntity.setStatus(0);
			
		} catch (Exception e) {
			String message = e.getMessage();
			e.printStackTrace();
			commonEntity.setMsg("failed to get achievements: "+ message);
			commonEntity.setStatus(1);
			commonEntity.setBean(null);
		}
		return commonEntity;
	}
	
	

	
	@RequestMapping(value="/signin/{id}",method = RequestMethod.GET)
	public @ResponseBody CommonEntity signIn(@PathVariable(name="id") Long id) {
		CommonEntity commonEntity = new CommonEntity();
		try {
			
			List<SignVo>  signVo= service.geStudentsSignStatusByTutorId(id);
			commonEntity.setBean(signVo);
			commonEntity.setMsg("success");
			commonEntity.setStatus(0);
			
		} catch (Exception e) {
			String message = e.getMessage();
			e.printStackTrace();
			commonEntity.setMsg("delete failue :"+ message);
			commonEntity.setStatus(1);
			commonEntity.setBean(null);
		}
		return commonEntity;
	}
	
	
	
	
	
}
