package uk.co.jsmondswimmingpool.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import uk.co.jsmondswimmingpool.entity.Course;
import uk.co.jsmondswimmingpool.entity.CourseChoosing;
import uk.co.jsmondswimmingpool.entity.Student;
import uk.co.jsmondswimmingpool.entity.custom.CommonEntity;
import uk.co.jsmondswimmingpool.entity.custom.PageBean;
import uk.co.jsmondswimmingpool.entity.custom.TutorVo;
import uk.co.jsmondswimmingpool.service.ICourseService;

@Controller
@RequestMapping(value = "/api/course")
public class CourseController {

	@Autowired
	ICourseService service;
	
	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public @ResponseBody CommonEntity getAll(@RequestBody(required=false) Course vo) {
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
	
	
	@RequestMapping(value = "/tutor/students", method = RequestMethod.POST)
	public @ResponseBody CommonEntity getAllByTutor(@RequestBody(required=true) TutorVo vo) {
		CommonEntity commonEntity = new CommonEntity();
		try {
			PageBean<Student> result = service.getAllByTutor(vo);
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
	
	@RequestMapping( method = RequestMethod.POST)
	public @ResponseBody CommonEntity addCourse(@RequestBody Course course) {
		
		CommonEntity commonEntity = new CommonEntity();
		try {
			Course result = service.addCourse(course);
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
	@RequestMapping( method = RequestMethod.DELETE)
	public @ResponseBody CommonEntity deleteCourse(@RequestBody Course course) {
		
		CommonEntity commonEntity = new CommonEntity();
		try {
			Course result = service.deleteCourse(course);
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
	
	/**
	 * 
	 * @param id tutor's ID
	 * @return
	 */
	@RequestMapping(value = "/tutor", method = RequestMethod.POST)
	public @ResponseBody CommonEntity assignTutorBytutorId(@RequestBody Course course) {
		
		CommonEntity commonEntity = new CommonEntity();
		try {
			Course result = service.assignTutorBytutorId(course);
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

	/**
	 * 
	 * @param id tutor's ID
	 * @return
	 */
	@RequestMapping(value = "/choose", method = RequestMethod.POST)
	public @ResponseBody CommonEntity chooseCourse(@RequestBody CourseChoosing choose) {
		
		CommonEntity commonEntity = new CommonEntity();
		try {
			CourseChoosing result = service.chooseCourse(choose);
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
	/**
	 * 
	 * @param id tutor's ID
	 * @return
	 */
	@RequestMapping(value = "/change", method = RequestMethod.POST)
	public @ResponseBody CommonEntity changeCourse(@RequestBody CourseChoosing choose) {
		
		CommonEntity commonEntity = new CommonEntity();
		try {
			CourseChoosing result = service.changeCourse(choose);
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
	/**
	 * 
	 * @param id tutor's ID
	 * @return
	 */
	@RequestMapping( method = RequestMethod.PATCH)
	public @ResponseBody CommonEntity updateCourse(@RequestBody Course choose) {
		
		CommonEntity commonEntity = new CommonEntity();
		try {
			Course 	result = service.deleteCourse(choose);
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
	
	
	
	
}
