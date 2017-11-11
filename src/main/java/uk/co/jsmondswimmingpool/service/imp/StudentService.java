package uk.co.jsmondswimmingpool.service.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.co.jsmondswimmingpool.entity.Course;
import uk.co.jsmondswimmingpool.entity.CourseChoosing;
import uk.co.jsmondswimmingpool.entity.CourseChoosingExample;
import uk.co.jsmondswimmingpool.entity.CourseExample;
import uk.co.jsmondswimmingpool.entity.Student;
import uk.co.jsmondswimmingpool.entity.StudentExample;
import uk.co.jsmondswimmingpool.entity.StudentExample.Criteria;
import uk.co.jsmondswimmingpool.entity.custom.PageBean;
import uk.co.jsmondswimmingpool.entity.custom.StudentVo;
import uk.co.jsmondswimmingpool.entity.custom.TutorVo;
import uk.co.jsmondswimmingpool.exception.NullIdException;
import uk.co.jsmondswimmingpool.mapper.CourseChoosingMapper;
import uk.co.jsmondswimmingpool.mapper.CourseMapper;
import uk.co.jsmondswimmingpool.mapper.StudentMapper;
import uk.co.jsmondswimmingpool.service.IStudentService;
import uk.co.jsmondswimmingpool.utils.TextUtils;




@Service
public class StudentService implements IStudentService {

	
	@Autowired
	StudentMapper mapper;
	@Autowired
	CourseChoosingMapper mapperchoosing;
	@Autowired
	CourseMapper courseMapper;
	
	@Override
	public PageBean<Student> getAll(StudentVo vo) {
	
		
		StudentExample example = new StudentExample();

		if (vo != null) {
			Criteria criteria = example.createCriteria();
			if (vo.getStudent() != null) {
				if (!TextUtils.isEmpty(vo.getStudent().getName()))
					criteria.andNameLike("%" + vo.getStudent().getName() + "%");				
			}
		
		}
		Long numberOfStudent = getNumberOfStudent(example);
		
		PageBean<Student> bean =null;
		if(vo!=null) {
			bean= new PageBean<>(vo.getCurrentPage(), numberOfStudent.intValue(), vo.getPageSize());
		}else {
			bean= new PageBean<>(0, numberOfStudent.intValue(), 10);
		}
		
		// bean.getStartCount(), bean.getPageSize();
		Integer startCount = bean.getStartCount();
		example.setOrderByClause("id desc limit " + startCount + "," + bean.getPageSize());
		List<Student> students = mapper.selectByExample(example);
		
	
	
		bean.setBeans(students);


		
		
		
		
		return bean;
	}

	
	@Override
	public Student findById(Long id) {
		Student result = mapper.selectByPrimaryKey(id);
		
		return result;
	}

	@Override
	public PageBean<Student> getStudentsByTutorId(TutorVo tutorVo) {

		if(tutorVo==null || tutorVo.getTutor()==null || tutorVo.getTutor().getId()==null)
			
			return null;

		List<Long> studentIds = courseMapper.getCourseIdsByTutorId(tutorVo.getTutor().getId());
		
	
		
		Integer numberOfStudent=studentIds.size();
		
		PageBean<Student> bean= new PageBean<>(tutorVo.getCurrentPage(), numberOfStudent.intValue(), tutorVo.getPageSize());

		
		
		Integer startCount = bean.getStartCount();
		Integer endPage=null;
		if(startCount+bean.getPageSize()> numberOfStudent) {
			endPage=numberOfStudent;
			
		}else {
			endPage=startCount+bean.getPageSize();
		}
		List<Student> beans=new ArrayList<>();
		
		for(int i =startCount;i<endPage;i++) {
			
			Student student = findById(studentIds.get(i));
			beans.add(student);
			
		}
		bean.setBeans(beans);
		return bean;
	}

	

	@Override
	public Student addStudent(Student student) {
		if(student==null)
			return null;
		mapper.insert(student);
		
		return student;
	}

	@Override
	public Student updateStudent(Student student) throws Exception  {
		if(student==null || student.getId()==null || student.getId()<0)
			throw new NullIdException("id = null");
		
		 mapper.updateByPrimaryKey(student);
		return student;
	}

	@Override
	public void deleteStudent(Student student) throws Exception {
		if(student==null || student.getId()==null || student.getId()<0)
			throw new NullIdException("id = null");
		
		mapper.deleteByPrimaryKey(student.getId());
		
	}


	@Override
	public Long getNumberOfStudent(StudentExample example) {
		int countByExample = mapper.countByExample(example);
		
		
		return (long) countByExample;
	}




}
