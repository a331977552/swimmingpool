package uk.co.swimmingpool.test;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import uk.co.jsmondswimmingpool.entity.Course;
import uk.co.jsmondswimmingpool.entity.CourseChoosing;
import uk.co.jsmondswimmingpool.entity.Courseitem;
import uk.co.jsmondswimmingpool.entity.Coursetimetable;
import uk.co.jsmondswimmingpool.entity.Student;
import uk.co.jsmondswimmingpool.entity.custom.CommonEntity;
import uk.co.jsmondswimmingpool.entity.custom.CourseVo;
import uk.co.jsmondswimmingpool.entity.custom.PageBean;
import uk.co.jsmondswimmingpool.service.ICourseService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"classpath:applicationContext.xml","classpath:springmvc.xml"})
public class CourseTest {
	
	@Resource(name="courseService")
	ICourseService courseService;
	
	
	@Test
	public void getCourseByStudentID() {
		
		List<Course> courseByStudentId = courseService.getCourseByStudentId((long)1);
		
		System.out.println(courseByStudentId);
		
	}
	
	@Test
	public void getStudentsByCourseId() {
		
		
		CourseVo vo=new CourseVo();
		Course co=new Course();
		co.setId((long)1);
		vo.setCourse(co);
		try {
			PageBean<Student> all = courseService.getAll(vo);
			vo.setCurrentPage(1);
			PageBean<Student> al2l = courseService.getAll(vo);
			
			System.out.println(all.getBeans().size());
			System.out.println(al2l.getBeans().size());
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	@Test
	public void deleteCourse() {
		
		
		Course co=new Course();
	
		co.setId((long)3);
		
		try {
			CommonEntity all = courseService.deleteCourse(co);
			
			System.out.println(all);
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Test
	public void chooseCourse() {
		
	
		try {
			CourseChoosing choose=new CourseChoosing();
			choose.setCourseid((long)1);
			choose.setStudentid((long)30);
			
			CourseChoosing all = courseService.chooseCourse(choose);
			
			System.out.println(all);
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	@Test
	public void changeCourse() {
		
		
		try {
			CourseChoosing choose=new CourseChoosing();
			choose.setId((long)19);
			choose.setCourseid((long)2);
			choose.setStudentid((long)30);
			
			CourseChoosing all = courseService.changeCourse(choose);
			
			
			
			System.out.println(all);
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void assignTutorBytutorId() {
		
		
		try {
			Course choose=new Course();
			choose.setId((long)1);
			choose.setTutorid((long)2);
				
			CommonEntity all = courseService.changeCourseTutorBytutorId(choose);
			
			
			System.out.println(all);
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	public void addCourse() {
		
		CourseVo courseVo=new CourseVo();
		Course course=new Course();
		List<Courseitem> courseitem=new  ArrayList<>();
		for(int i=0;i<4;i++) {
			Courseitem item=new Courseitem();
			item.setName("item"+i);
			courseitem.add(item);
			
		}
		List<Coursetimetable> timetable=new  ArrayList<>();
		for(int i=0;i<8;i++) {
			Coursetimetable item=new Coursetimetable();
			item.setCoursedate("2017-11-1"+i);
			timetable.add(item);
			
		}
		courseVo.setCourseitem(courseitem);
		courseVo.setCoursetimetable(timetable);
		course.setNote("this is a new type of course");
		course.setName("BIG BANG");
		course.setTutorid((long)1);
		courseVo.setCourse(course);
		try {
			CommonEntity addCourse = courseService.addCourse(courseVo);
			
			System.out.println(addCourse);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	
	
}
