package uk.co.swimmingpool.test;

import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import uk.co.jsmondswimmingpool.entity.Student;
import uk.co.jsmondswimmingpool.entity.Tutor;
import uk.co.jsmondswimmingpool.entity.custom.PageBean;
import uk.co.jsmondswimmingpool.entity.custom.TutorVo;
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
		
		
		@Test
		public void getStudentsByTutorId() {
			try {
				TutorVo tutorVo=new TutorVo();
				Tutor tutor=new Tutor();
				tutor.setId((long) 1);
				tutorVo.setTutor(tutor);
				
				PageBean<Student> student = studentService.getStudentsByTutorId(tutorVo);
				tutorVo.setCurrentPage(student.getCurrentPage()+1);
				PageBean<Student> student2 = studentService.getStudentsByTutorId(tutorVo);
				tutorVo.setCurrentPage(student.getCurrentPage()+1);
				PageBean<Student> student3 = studentService.getStudentsByTutorId(tutorVo);
				
				
				System.out.println(student.getBeans().size());
				System.out.println(student2.getBeans().size());
				System.out.println(student3.getBeans().size());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
		
		
		
		
		
	
	
}
