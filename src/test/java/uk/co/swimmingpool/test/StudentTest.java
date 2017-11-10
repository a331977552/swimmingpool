package uk.co.swimmingpool.test;

import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import uk.co.jsmondswimmingpool.entity.Student;
import uk.co.jsmondswimmingpool.service.IStudentService;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"classpath:applicationContext.xml","classpath:springmvc.xml"})
public class StudentTest {


		@Resource(name="studentService")
		IStudentService studentService;
		
		
		@Test
		public void findById() {
			try {
				Student student = studentService.findById(new Long(1));
				System.out.println(student.getName());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
		
	
	
}
