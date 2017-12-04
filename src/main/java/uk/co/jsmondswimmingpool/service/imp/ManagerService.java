package uk.co.jsmondswimmingpool.service.imp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.co.jsmondswimmingpool.entity.Tutor;
import uk.co.jsmondswimmingpool.entity.TutorExample;
import uk.co.jsmondswimmingpool.entity.TutorExample.Criteria;
import uk.co.jsmondswimmingpool.entity.custom.CommonEntity;
import uk.co.jsmondswimmingpool.entity.custom.ErrorBean;
import uk.co.jsmondswimmingpool.mapper.TutorMapper;
import uk.co.jsmondswimmingpool.service.IManagerService;
import uk.co.jsmondswimmingpool.utils.TextUtils;

@Service
public class ManagerService implements IManagerService {

	@Autowired
	TutorMapper mapper;
	private String errorDir;


	public ManagerService() {
		Properties properties=new Properties();
		try {
			InputStream resourceAsStream = getClass().getResourceAsStream("/db.properties");
			properties.load(resourceAsStream);
			errorDir = properties.getProperty("errorInfo");
		} catch (IOException e) {
			e.printStackTrace();
		}
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



	@Override
	public CommonEntity error(ErrorBean tutor) {
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyy-MM-dd HH_mm_ss");
		String format = dateFormat.format(new Date());
		try {
			File fileD=new File(errorDir);
			if(!fileD.exists()) {
				fileD.mkdir();
			}
			
			File file=new File(errorDir,format+".txt");
			System.out.println(file);
			if(!file.exists()) {
				file.createNewFile();
			}
			FileOutputStream fileOutputStream=new FileOutputStream(file);
			fileOutputStream.write(tutor.getErrorInfo().getBytes());
			fileOutputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		CommonEntity commonEntity=new CommonEntity();
		return commonEntity;
	}

}
