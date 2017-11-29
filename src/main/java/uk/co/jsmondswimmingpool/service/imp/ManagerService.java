package uk.co.jsmondswimmingpool.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.co.jsmondswimmingpool.entity.Tutor;
import uk.co.jsmondswimmingpool.entity.TutorExample;
import uk.co.jsmondswimmingpool.entity.TutorExample.Criteria;
import uk.co.jsmondswimmingpool.entity.custom.CommonEntity;
import uk.co.jsmondswimmingpool.mapper.TutorMapper;
import uk.co.jsmondswimmingpool.service.IManagerService;
import uk.co.jsmondswimmingpool.utils.TextUtils;

@Service
public class ManagerService implements IManagerService {

	@Autowired
	TutorMapper mapper;

	@Override
	public CommonEntity login(Tutor tutor) {
		CommonEntity entity=new CommonEntity();
		
		if(tutor==null)
		{
			entity.setBean(null);
			entity.setMsg("faliure, tutor entity cannot be null");
			entity.setStatus(1);
			return entity;
		}	
		
		if(TextUtils.isEmpty(tutor.getUsername(),tutor.getPassword()))
		{
			entity.setBean(null);
			entity.setMsg("username or password cannot be null");
			entity.setStatus(1);
			return entity;
		}	
		TutorExample example=new TutorExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andUsernameEqualTo(tutor.getUsername());
		createCriteria.andPasswordEqualTo(tutor.getPassword());
		
		List<Tutor> selectByExample = mapper.selectByExample(example);
		if(selectByExample!=null && selectByExample.size()>0) {
			entity.setBean(selectByExample.get(0));
			entity.setMsg("login success");
			entity.setStatus(0);			
		}else {
			entity.setBean(null);
			entity.setMsg("faiure,incorrect username or password");
			entity.setStatus(1);			
		}
		return entity;
	}

}
