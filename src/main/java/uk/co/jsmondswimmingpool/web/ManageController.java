package uk.co.jsmondswimmingpool.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import uk.co.jsmondswimmingpool.entity.Tutor;
import uk.co.jsmondswimmingpool.entity.custom.CommonEntity;
import uk.co.jsmondswimmingpool.service.IManagerService;

@Controller
@RequestMapping(value = "/api/")
public class ManageController {

	
	@Autowired
	IManagerService service;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public @ResponseBody CommonEntity login(@RequestBody(required=false) Tutor tutor) {
		return service.login(tutor);
	}
	@RequestMapping(value="/error",method=RequestMethod.POST)
	public @ResponseBody CommonEntity error(@RequestBody(required=true) uk.co.jsmondswimmingpool.entity.custom.ErrorBean error) {
		return service.error(error);
	}
	
}
