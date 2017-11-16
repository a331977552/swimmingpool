package uk.co.jsmondswimmingpool.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import uk.co.jsmondswimmingpool.entity.Tutor;
import uk.co.jsmondswimmingpool.entity.custom.CommonEntity;
import uk.co.jsmondswimmingpool.entity.custom.TutorVo;
import uk.co.jsmondswimmingpool.service.ITutorService;

@RestController
@RequestMapping(value = "/api/tutor")
public class TutorController {

	
	@Autowired
	ITutorService service;
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody CommonEntity addTutor(@RequestBody Tutor tutor ) {
		
				
		return service.addTutor(tutor);
	}
	
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public @ResponseBody CommonEntity login(@RequestBody Tutor tutor ) {
			
		return service.login(tutor);
	}
	
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public @ResponseBody CommonEntity deleteTutor(@PathVariable(name="id")  Long id ) {
		
		
		return service.deleteTutor(id);
	}
	@RequestMapping(method = RequestMethod.PATCH)
	public @ResponseBody CommonEntity updateTutor(@RequestBody Tutor tutor ) {
		
		
		return service.updateTutor(tutor);
	}
	
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public @ResponseBody CommonEntity getTutor(@PathVariable(name="id") Long id ) {
		System.out.println("ddd"+id);
		return service.getTutor(id);
	}
	
	@RequestMapping(value="/tutors",  method = RequestMethod.POST)
	public @ResponseBody CommonEntity getAllTutor(@RequestBody(required=false) TutorVo vo) {
		
		return service.getAllTutor(vo);
	}
	
	
	
	
	
	

	
	
	
	
}
