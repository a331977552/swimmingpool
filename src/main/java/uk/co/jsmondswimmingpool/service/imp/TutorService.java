package uk.co.jsmondswimmingpool.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.co.jsmondswimmingpool.entity.Tutor;
import uk.co.jsmondswimmingpool.entity.TutorExample;
import uk.co.jsmondswimmingpool.entity.TutorExample.Criteria;
import uk.co.jsmondswimmingpool.entity.custom.CommonEntity;
import uk.co.jsmondswimmingpool.entity.custom.PageBean;
import uk.co.jsmondswimmingpool.entity.custom.TutorVo;
import uk.co.jsmondswimmingpool.mapper.TutorMapper;
import uk.co.jsmondswimmingpool.service.ITutorService;
import uk.co.jsmondswimmingpool.utils.TextUtils;

@Service
public class TutorService implements ITutorService {

	@Autowired
	TutorMapper mapper;
	@Override
	public CommonEntity addTutor(Tutor tutor) {
		CommonEntity commonEntity=new CommonEntity();
		tutor.setPower(1);
		if(TextUtils.isEmpty(tutor.getName(),tutor.getUsername(),tutor.getPassword())) {
			commonEntity.setMsg("failure : name, username, password cannot be empty");
			commonEntity.setStatus(1);
			return commonEntity;
		}
		TutorExample example=new TutorExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andUsernameEqualTo(tutor.getUsername());
		List<Tutor> selectByExample = mapper.selectByExample(example);
		if(selectByExample!=null && selectByExample.size()>0)
		{
			commonEntity.setMsg("failure : username already exists");
			commonEntity.setStatus(1);
			return commonEntity;
		}
		tutor.setId(null);
		mapper.insert(tutor);
		commonEntity.setBean(tutor);
		commonEntity.setMsg("success");
		commonEntity.setStatus(0);
		return commonEntity;
	}

	@Override
	public CommonEntity deleteTutor(Long id) {
		
		CommonEntity commonEntity=new CommonEntity();
		if(TextUtils.isNullId(id)) {
			commonEntity.setMsg("failure :id cannot be empty");
			commonEntity.setStatus(1);
			return commonEntity;
		}
		mapper.deleteByPrimaryKey(id);
		commonEntity.setMsg("success");
		commonEntity.setStatus(0);
		return commonEntity;
	}

	@Override
	public CommonEntity updateTutor(Tutor tutor) {
		CommonEntity commonEntity=new CommonEntity();
		if(TextUtils.isNullId(tutor.getId())) {
			commonEntity.setMsg("failure :id cannot be empty");
			commonEntity.setStatus(1);
			return commonEntity;
		}
		tutor.setPower(1);
		mapper.updateByPrimaryKey(tutor);
		commonEntity.setBean(tutor);
		commonEntity.setMsg("success");
		commonEntity.setStatus(0);
		return commonEntity;
	}

	@Override
	public CommonEntity getTutor(Long id) {
		
		
		CommonEntity commonEntity=new CommonEntity();
		if(TextUtils.isNullId(id)) {
			commonEntity.setMsg("failure :id cannot be empty");
			commonEntity.setStatus(1);
			return commonEntity;
		}
		Tutor bean = mapper.selectByPrimaryKey(id);
		commonEntity.setBean(bean);
		commonEntity.setMsg("success");
		commonEntity.setStatus(0);
		return commonEntity;
	}

	@Override
	public CommonEntity getAllTutor(TutorVo vo) {
		
		CommonEntity commonEntity=new CommonEntity();
		TutorExample example=new TutorExample();
		if(vo!=null && vo.getTutor()!=null &&!TextUtils.isEmpty(vo.getTutor().getName())) {
			Criteria criteria = example.createCriteria();
			criteria.andNameLike("%" +vo.getTutor().getName() +"%");
			
		}
		int countByExample = mapper.countByExample(example);
		
		
		
		if(vo==null)
			vo=new TutorVo();
		PageBean<Tutor> pageBean=new PageBean<>(vo.getCurrentPage(), countByExample, vo.getPageSize());
		
		example.setOrderByClause("id desc limit "+pageBean.getStartCount()+","+pageBean.getPageSize());
		List<Tutor> beans = mapper.selectByExample(example);
		pageBean.setBeans(beans);
		commonEntity.setMsg("success");
		commonEntity.setStatus(0);
		commonEntity.setBean(pageBean);
		
		return commonEntity;
	}

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
			entity.setMsg("faliure, tutor's username or password cannot be null");
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
			entity.setMsg("login faiure,incorrect username or password");
			entity.setStatus(1);			
		}
		return entity;
	}

}
