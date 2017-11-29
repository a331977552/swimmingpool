package uk.co.jsmondswimmingpool.web;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import uk.co.jsmondswimmingpool.entity.Course;
import uk.co.jsmondswimmingpool.entity.CourseChoosing;
import uk.co.jsmondswimmingpool.entity.Courseitem;
import uk.co.jsmondswimmingpool.entity.custom.CommonEntity;
import uk.co.jsmondswimmingpool.entity.custom.CourseChangeVo;
import uk.co.jsmondswimmingpool.entity.custom.CourseItemVo;
import uk.co.jsmondswimmingpool.entity.custom.CourseVo;
import uk.co.jsmondswimmingpool.service.ICourseService;

@Controller
@RequestMapping(value = "/api/course")
public class CourseController {

	/**
	 * get all student related to today's course;
	 * get a student's attendance history 
	 * add student
	 * update student
	 * delete student
	 * get a student from search
	 * 
	 * add course
	 * update course
	 * delete course
	 * get a all the course  ,and click it, go to new activity. show this course achievement and edit it.
	 * get a course by search
	 * get all the courses by student
	 * get all the achievements by student.
	 * 
	 * 
	 * 
	 * confirm a student has finished a certain course;
	 * change course
	 *  
	 * 
	 * 
	 * 
	 */
	
	@Autowired
	ICourseService service;
	
	@RequestMapping(value = "/courses", method = RequestMethod.POST)
	public @ResponseBody CommonEntity getAll(@RequestBody(required=false) CourseVo vo) {
		CommonEntity result = service.getAll(vo);	
		return result;
	}

	
	/*@RequestMapping(value = "/tutor/students", method = RequestMethod.POST)
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
	}*/
	
	
	
	
	
	@RequestMapping( method = RequestMethod.POST)
	public @ResponseBody CommonEntity addCourse(@RequestBody CourseVo course) {

		return service.addCourse(course);
		
	}
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public @ResponseBody CommonEntity deleteCourse(@PathVariable("id") Long id) {
		
		CommonEntity commonEntity = service.deleteCourse(id);

		return commonEntity;
		
	}
	
		

	/**
	 * 
	 * @param id tutor's ID
	 * @return
	 */
	@RequestMapping(value = "/choose", method = RequestMethod.POST)
	public @ResponseBody CommonEntity chooseCourse(@RequestBody CourseChoosing choose) {
		

	
		return service.chooseCourse(choose);
		
	}
	
			
	
	/**
	 * 
	 * @param id tutor's ID
	 * @return
	 */
	@RequestMapping(value = "/change", method = RequestMethod.POST)
	public @ResponseBody CommonEntity changeCourse(@RequestBody CourseChangeVo choose) {
			System.out.println(choose.toString());
			CommonEntity result = service.changeCourse(choose);
		
		return result;
		
	}
	

	/**
	 * 
	 * @param id tutor's ID
	 * @return
	 */
	@RequestMapping( method = RequestMethod.PATCH)
	public @ResponseBody CommonEntity updateCourse(@RequestBody Course choose) {
		
		CommonEntity commonEntity=null;
		try {
			commonEntity = service.updateCourse(choose);
			
		} catch (Exception e) { 
			String message = e.getMessage();
			e.printStackTrace();
			commonEntity.setMsg("failue :"+ message);			
			commonEntity.setStatus(1);
			commonEntity.setBean(null);
		}

		return commonEntity;
		
	}
	//get a all the course  ,and click it, go to new activity. show this course achievement and edit it.
		
		
		
		/**
		 * 
		 * @param id tutor's ID
		 * @return
		 */
		@RequestMapping(value="/{id}", method = RequestMethod.GET)
		public @ResponseBody CommonEntity getCourseById(@PathVariable("id") Long id) {
			
			CommonEntity commonEntity=null;
			
				commonEntity = service.getCourseById(id);
			return commonEntity;
			
		}
	
		/**
		 * 
		 * @param id tutor's ID
		 * @return
		 */
		@RequestMapping(value="/student/{id}", method = RequestMethod.GET)
		public @ResponseBody CommonEntity getCourseByStudentId(@PathVariable("id") Long id) {
			
			CommonEntity commonEntity=null;
			
			commonEntity = service.getCourseByStudentId(id);
			return commonEntity;
			
		}
		
		/**
		 * 
		 * @param id tutor's ID
		 * @return
		 */
		@RequestMapping(value="/items/{id}", method = RequestMethod.GET)
		public @ResponseBody CommonEntity getAllItemByCourseId(@PathVariable("id") Long id) {
			
			CommonEntity commonEntity=null;
			
			commonEntity = service.getAllItemByCourseId(id);
			return commonEntity;
			
		}
		/**
		 * 
		 * @param id tutor's ID
		 * @return
		 */
		@RequestMapping(value="/item", method = RequestMethod.PATCH)
		public @ResponseBody CommonEntity updateItem(@RequestBody Courseitem item) {
			
			CommonEntity commonEntity=null;
			
			commonEntity = service.updateItem(item);
			return commonEntity;
			
		}
		/**
		 * 
		 * @param id tutor's ID
		 * @return
		 */
		@RequestMapping(value="/item/{id}", method = RequestMethod.DELETE)
		public @ResponseBody CommonEntity deleteItem(@PathVariable("id")Long id) {
			
			CommonEntity commonEntity=null;
			
			commonEntity = service.deleteItem(id);
			return commonEntity;
			
		}
		/**
		 * 

		 * @return
		 */
		@RequestMapping(value="/items", method = RequestMethod.POST)
		public @ResponseBody CommonEntity addItems(@RequestBody CourseItemVo item) {			
			CommonEntity commonEntity=null;
			commonEntity = service.addItems(item);
			return commonEntity;
			
		}
	
	

	
	
	
}
