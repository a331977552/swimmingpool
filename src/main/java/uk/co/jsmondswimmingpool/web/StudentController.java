package uk.co.jsmondswimmingpool.web;

import javax.annotation.Resource;

import org.apache.xmlbeans.impl.validator.ValidatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import uk.co.jsmondswimmingpool.entity.Student;
import uk.co.jsmondswimmingpool.entity.custom.CommonEntity;
import uk.co.jsmondswimmingpool.entity.custom.PageBean;
import uk.co.jsmondswimmingpool.entity.custom.StudentVo;
import uk.co.jsmondswimmingpool.entity.custom.TutorVo;
import uk.co.jsmondswimmingpool.service.IStudentService;

@Controller
@RequestMapping(value = "/api/student")
public class StudentController {

	@Autowired
	IStudentService service;

	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public @ResponseBody CommonEntity getAllStudents(@RequestBody StudentVo vo) {

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
	public @ResponseBody CommonEntity getStudentById(Long id) {
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

	@RequestMapping(value = "/tutor/{id}", method = RequestMethod.GET)
	public @ResponseBody CommonEntity getStudentsByTutorId(TutorVo toturVo) {
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
			commonEntity.setMsg("failue");
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
	public @ResponseBody CommonEntity deleteStudent(@RequestBody Student student) {
		CommonEntity commonEntity = new CommonEntity();
		try {
			
			service.deleteStudent(student);
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
