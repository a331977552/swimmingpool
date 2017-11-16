package uk.co.swimmingpool.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import uk.co.jsmondswimmingpool.entity.Tutor;
import uk.co.jsmondswimmingpool.entity.custom.CommonEntity;
import uk.co.jsmondswimmingpool.entity.custom.PageBean;
import uk.co.jsmondswimmingpool.entity.custom.TutorVo;
import uk.co.jsmondswimmingpool.service.ITutorService;
import uk.co.jsmondswimmingpool.service.imp.TutorService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"classpath:applicationContext.xml","classpath:springmvc.xml"})
public class TutorTest {
	
	
	@Autowired
	ITutorService service;
	@Test
	public void  insertTutor() {
		Tutor tutor=new Tutor();
		tutor.setName("heihei2");
		tutor.setUsername("a123456");
		tutor.setPassword("a123456");
		
		CommonEntity addTutor = service.addTutor(tutor);
		
		System.out.println(addTutor);
		
		
		
	}
	@Test
	public void  deleTutor() {
		
		CommonEntity addTutor = service.deleteTutor((long)2);
		
		System.out.println(addTutor);
		
		
		
	}
	@Test
	public void  updateTutor() {
		
		Tutor tutor=new Tutor();
		tutor.setId((long)1);
		tutor.setName("Lida");
		tutor.setNote("this is a new teacher");
		tutor.setUsername("a1111111");
		tutor.setPassword("111111");
		CommonEntity addTutor = service.updateTutor(tutor);
		
		System.out.println(addTutor);
		
		
		
	}
	@Test
	public void  getTutor() {

		CommonEntity addTutor = service.getTutor((long)1);
		
		System.out.println(addTutor);
		
		
		
	}
	@Test
	public void  getTutors() {
		
		TutorVo vo=new TutorVo();
		Tutor tutor=new Tutor();
		tutor.setName("ha");
		vo.setTutor(tutor);
		CommonEntity addTutor = service.getAllTutor(vo);
		PageBean bean = (PageBean) addTutor.getBean();
		
		System.out.println(bean.getBeans());
		
		
		
	}
	@Test
	public void  login() {
		
		Tutor tutor=new Tutor();
		tutor.setUsername("a1234561");
		tutor.setPassword("a123456");
		CommonEntity ce = service.login(tutor);
		
		
		System.out.println(ce.getMsg());
		
		
		
	}

}
