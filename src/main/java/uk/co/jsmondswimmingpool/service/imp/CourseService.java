package uk.co.jsmondswimmingpool.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.co.jsmondswimmingpool.entity.Course;
import uk.co.jsmondswimmingpool.entity.CourseChoosing;
import uk.co.jsmondswimmingpool.entity.CourseChoosingExample;
import uk.co.jsmondswimmingpool.entity.CourseChoosingExample.Criteria;
import uk.co.jsmondswimmingpool.entity.Courseitem;
import uk.co.jsmondswimmingpool.entity.Coursetimetable;
import uk.co.jsmondswimmingpool.entity.Student;
import uk.co.jsmondswimmingpool.entity.StudentExample;
import uk.co.jsmondswimmingpool.entity.custom.CommonEntity;
import uk.co.jsmondswimmingpool.entity.custom.CourseVo;
import uk.co.jsmondswimmingpool.entity.custom.PageBean;
import uk.co.jsmondswimmingpool.exception.NullIdException;
import uk.co.jsmondswimmingpool.mapper.CourseChoosingMapper;
import uk.co.jsmondswimmingpool.mapper.CourseMapper;
import uk.co.jsmondswimmingpool.mapper.CourseitemMapper;
import uk.co.jsmondswimmingpool.mapper.CoursetimetableMapper;
import uk.co.jsmondswimmingpool.mapper.StudentMapper;
import uk.co.jsmondswimmingpool.service.ICourseService;
import uk.co.jsmondswimmingpool.utils.TextUtils;

@Service
public class CourseService implements ICourseService {
	
	@Autowired
	CourseMapper mapper;
	@Autowired
	StudentMapper studentMapper;
	
	@Autowired
	CourseChoosingMapper courseChoosingMapper;
	
	@Autowired
	CourseitemMapper itemMapper;
	
	@Autowired
	CoursetimetableMapper tableMapper;
	
	@Override
	public PageBean<Student> getAll(CourseVo vo)  throws Exception{
		if(vo==null || vo.getCourse()==null|| vo.getCourse().getId()==null)
			throw new NullIdException("course's Id cannot be null");
		
		CourseChoosingExample example=new CourseChoosingExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andCourseidEqualTo(vo.getCourse().getId());
		List<CourseChoosing> courseChoosingList = courseChoosingMapper.selectByExample(example);
		int numberOfStudent=courseChoosingList.size();
		
		
		PageBean<Student> bean=new PageBean<>(vo.getCurrentPage(),numberOfStudent,vo.getPageSize());
		Integer startCount = bean.getStartCount();
		
		
		StudentExample stuExample=new StudentExample();
		uk.co.jsmondswimmingpool.entity.StudentExample.Criteria stuCariteria = stuExample.createCriteria();
		List<Long> ids=new ArrayList<>();
		for (CourseChoosing long1 : courseChoosingList) {
			ids.add(long1.getStudentid());
		}
		stuCariteria.andIdIn(ids);
		stuExample.setOrderByClause("id desc limit "+startCount+","+bean.getPageSize());
		
		List<Student> studentList = studentMapper.selectByExample(stuExample);
		bean.setBeans(studentList);
		
		
		return bean;
	}

	


	

	/**
	 * choose Course
	 */
	@Override
	public CourseChoosing chooseCourse(CourseChoosing choose) throws Exception {
		courseChoosingMapper.insert(choose);
		return choose;
	}

	
	/**
	 * students  change course
	 */
	@Override
	public CourseChoosing changeCourse(CourseChoosing choose)  throws Exception{
		if(TextUtils.isNullId(choose.getId()) || TextUtils.isNullId(choose.getStudentid()) || TextUtils.isNullId(choose.getCourseid()) )
			throw new NullIdException("changeCourse: id cannot be null");
		
		courseChoosingMapper.updateByPrimaryKey(choose);
		return choose;
	}

	

	@Override
	public CommonEntity addCourse(CourseVo course) throws Exception {
		
		
		CommonEntity commonEntity=new CommonEntity();
		if(TextUtils.isEmpty(course.getCourse().getName()))
		{
			commonEntity.setMsg("course's name cannot be empty");
			commonEntity.setStatus(1);
			return commonEntity;
		}
		
		if(TextUtils.isNullId(course.getCourse().getTutorid()))
		{
			commonEntity.setMsg("must assign a teacher");
			commonEntity.setStatus(1);
			return commonEntity;
		}
		
		
		
		mapper.insert(course.getCourse());
		
		List<Courseitem> courseitems= course.getCourseitem();
		
		for (Courseitem courseitem : courseitems) {
			courseitem.setCourseid(course.getCourse().getId());
			itemMapper.insert(courseitem);			
		}
		
		List<Coursetimetable> tables= course.getCoursetimetable();
		
		for (Coursetimetable tab : tables) {
			tab.setCourseid(course.getCourse().getId());			
			tableMapper.insert(tab);			
		}
		
		commonEntity.setBean(course);
		commonEntity.setMsg("success");
		commonEntity.setStatus(0);
		return commonEntity;
	}


	@Override
	public CommonEntity deleteCourse(Course course) throws Exception {
		CommonEntity commonEntity=new CommonEntity();
		if(TextUtils.isNullId(course.getId()))
		{
			commonEntity.setMsg("must select a course to delete");
			commonEntity.setStatus(1);
			return commonEntity;
		}
		
		
		mapper.deleteByPrimaryKey(course.getId());
		commonEntity.setBean(null);
		commonEntity.setMsg("success");
		commonEntity.setStatus(0);
		return commonEntity;
	}


	/**
	 * change course's tutor
	 */
	@Override
	public CommonEntity changeCourseTutorBytutorId(Course course) throws Exception {
			
		CommonEntity commonEntity=new CommonEntity();
		if(TextUtils.isNullId(course.getId()))
		{
			commonEntity.setMsg("must select a course to change");
			commonEntity.setStatus(1);
			return commonEntity;
		}
		if(TextUtils.isNullId(course.getTutorid()))
		{
			commonEntity.setMsg("must select a tutor to be assigned");
			commonEntity.setStatus(1);
			return commonEntity;
		}
		
		
		mapper.updateByPrimaryKeySelective(course);
		commonEntity.setBean(course);
		commonEntity.setMsg("success");
		commonEntity.setStatus(0);
		return commonEntity;
	}






	@Override
	public CommonEntity updateCourse(Course choose) {
		
		CommonEntity commonEntity=new CommonEntity();
		if(TextUtils.isNullId(choose.getId()))
		{
			commonEntity.setMsg("must select a course to change");
			commonEntity.setStatus(1);
			return commonEntity;
		}
		
		mapper.updateByPrimaryKey(choose);
	
		commonEntity.setBean(choose);
		commonEntity.setMsg("success");
		commonEntity.setStatus(0);
		return commonEntity;
	}






	@Override
	public List<Course> getCourseByStudentId(Long id) {
		if(id==null)
			return new ArrayList<Course>();
		
		List<Course> courses=mapper.selectCoursesByStudentId(id);
		if(courses==null )
			return new ArrayList<Course>();
		
		return courses;
	}







	

	
	

}
