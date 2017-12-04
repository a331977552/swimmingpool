package uk.co.jsmondswimmingpool.service.imp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.co.jsmondswimmingpool.entity.Course;
import uk.co.jsmondswimmingpool.entity.CourseChoosing;
import uk.co.jsmondswimmingpool.entity.CourseChoosingExample;
import uk.co.jsmondswimmingpool.entity.CourseExample;
import uk.co.jsmondswimmingpool.entity.CourseExample.Criteria;
import uk.co.jsmondswimmingpool.entity.Courseitem;
import uk.co.jsmondswimmingpool.entity.CourseitemExample;
import uk.co.jsmondswimmingpool.entity.Finishstatus;
import uk.co.jsmondswimmingpool.entity.FinishstatusExample;
import uk.co.jsmondswimmingpool.entity.custom.CommonEntity;
import uk.co.jsmondswimmingpool.entity.custom.CourseChangeVo;
import uk.co.jsmondswimmingpool.entity.custom.CourseItemVo;
import uk.co.jsmondswimmingpool.entity.custom.CourseVo;
import uk.co.jsmondswimmingpool.entity.custom.PageBean;
import uk.co.jsmondswimmingpool.entity.custom.StudentVo;
import uk.co.jsmondswimmingpool.mapper.AchievementMapper;
import uk.co.jsmondswimmingpool.mapper.CourseChoosingMapper;
import uk.co.jsmondswimmingpool.mapper.CourseMapper;
import uk.co.jsmondswimmingpool.mapper.CourseitemMapper;
import uk.co.jsmondswimmingpool.mapper.FinishstatusMapper;
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
	AchievementMapper achievementMapper;
	@Autowired
	FinishstatusMapper finishMapper;

	@Override
	public CommonEntity getAll(CourseVo vo) {
		CommonEntity commonEntity = new CommonEntity();
		CourseExample example = new CourseExample();
		
		CourseVo courseVo=new CourseVo();
		
		if(vo.getPageBean()!=null) {
			Integer currentPage = vo.getPageBean().getCurrentPage();
			example.setOrderByClause("id desc limit"+((currentPage+1)*vo.getPageBean().getPageSize())+","+vo.getPageBean().getPageSize());
			courseVo.setPageBean(new PageBean(vo.getPageBean().getCurrentPage()+1, -1, vo.getPageBean().getPageSize()));
		}else {			
			example.setOrderByClause("id desc");
		}
		
		Criteria criteria = example.createCriteria();
		if (vo != null && vo.getCourse() != null && !TextUtils.isEmpty(vo.getCourse().getName())) {

			criteria.andNameLike("%" + vo.getCourse().getName() + "%");

		}

		if (vo != null && vo.getDay() != null) {
			/*
			 * SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			 * String format = simpleDateFormat.format(vo.getDay());
			 */
			criteria.andEndDateGreaterThanOrEqualTo(vo.getDay());

			criteria.andStartDateLessThanOrEqualTo(vo.getDay());
		}

		List<Course> removingCourse = mapper.selectByExample(example);
		try {
			List<Course> selectByExample = mapper.selectByExample(example);
			if (vo != null && vo.isIncludingFishished() != null && !vo.isIncludingFishished()) {

				List<Long> values = new ArrayList<>();
				for (Course course : selectByExample) {
					values.add(course.getId());
				}

				FinishstatusExample example2 = new FinishstatusExample();
				uk.co.jsmondswimmingpool.entity.FinishstatusExample.Criteria c2 = example2.createCriteria();
				c2.andCourseidIn(values);
				c2.andStudentidEqualTo(vo.getStudentId());
				List<Finishstatus> selectByExample2 = finishMapper.selectByExample(example2);
				for (Finishstatus finishstatus : selectByExample2) {
					inner: for (Course course : selectByExample) {
						if (finishstatus.getCourseid().longValue() == course.getId().longValue()) {
							removingCourse.add(course);
							break inner;
						}
					}
				}

			}

			// remove the course this student already chose
			if (vo != null && vo.getIncludingChose() != null && !vo.getIncludingChose() && vo.getStudentId() != null) {
				CourseChoosingExample example3 = new CourseChoosingExample();
				uk.co.jsmondswimmingpool.entity.CourseChoosingExample.Criteria c3 = example3.createCriteria();
				c3.andStudentidEqualTo(vo.getStudentId());
				List<CourseChoosing> chosen = courseChoosingMapper.selectByExample(example3);
				for (CourseChoosing c : chosen) {
					inner: for (Course course : selectByExample) {
						if (course.getId().longValue() == c.getCourseid().longValue()
								&& !removingCourse.contains(course)) {
							removingCourse.add(course);
							break inner;
						}
					}
				}
			}
			selectByExample.removeAll(removingCourse);
		
			courseVo.setCourseList(selectByExample);
		
			commonEntity.setBean(courseVo);
			commonEntity.setMsg("success");
			commonEntity.setStatus(0);
		} catch (Exception e) {
			commonEntity.setMsg("failure");
			commonEntity.setStatus(11);
			e.printStackTrace();
		}

		return commonEntity;
	}

	/**
	 * choose Course
	 */
	@Override
	public CommonEntity chooseCourse(CourseChoosing choose) {
		CommonEntity commonEntity = new CommonEntity();
		try {
				
			courseChoosingMapper.insert(choose);
			// delete finishing status
			FinishstatusExample example2 = new FinishstatusExample();
			uk.co.jsmondswimmingpool.entity.FinishstatusExample.Criteria c2 = example2.createCriteria();
			c2.andCourseidEqualTo(choose.getCourseid());
			c2.andStudentidEqualTo(choose.getStudentid());
			finishMapper.deleteByExample(example2);

			commonEntity.setMsg("success");
			commonEntity.setStatus(0);
		} catch (Exception exception) {
			exception.printStackTrace();
			commonEntity.setMsg("failed to choose this course");
			commonEntity.setStatus(12);

		}
		return commonEntity;
	}

	/**
	 * students change course
	 */
	@Override
	public CommonEntity changeCourse(CourseChangeVo choose) {
		CommonEntity commonEntity = new CommonEntity();
		if (TextUtils.isNullId(choose.getStudentId()) || TextUtils.isNullId(choose.getCourseId())
				|| TextUtils.isNullId(choose.getPreviousCourseId())) {
			commonEntity.setStatus(13);
			commonEntity.setMsg("please choose one course");
		} else {

			try {
				CourseChoosingExample example = new CourseChoosingExample();
				uk.co.jsmondswimmingpool.entity.CourseChoosingExample.Criteria c = example.createCriteria();
				c.andCourseidEqualTo(choose.getPreviousCourseId());
				c.andStudentidEqualTo(choose.getStudentId());

				List<CourseChoosing> selectByExample = courseChoosingMapper.selectByExample(example);
				if (selectByExample == null || selectByExample.isEmpty()) {
					commonEntity.setMsg("this student did choose course before");
					commonEntity.setStatus(22);
					return commonEntity;
				}
				CourseChoosing courseChoosing = selectByExample.get(0);
				courseChoosing.setCourseid(choose.getCourseId());
				courseChoosingMapper.updateByPrimaryKey(courseChoosing);

				// delete finishing status
				FinishstatusExample example2 = new FinishstatusExample();
				uk.co.jsmondswimmingpool.entity.FinishstatusExample.Criteria c2 = example2.createCriteria();
				c2.andCourseidEqualTo(courseChoosing.getCourseid());
				c2.andStudentidEqualTo(courseChoosing.getStudentid());
				finishMapper.deleteByExample(example2);

				commonEntity.setBean(courseChoosing);
				commonEntity.setStatus(0);
				commonEntity.setMsg("success");
			} catch (Exception e) {
				commonEntity.setMsg("failed to change  course");
				commonEntity.setStatus(14);
				e.printStackTrace();
			}

		}

		return commonEntity;
	}

	@Override
	public CommonEntity addCourse(CourseVo course) {

		CommonEntity commonEntity = new CommonEntity();
		if (TextUtils.isEmpty(course.getCourse().getName())) {
			commonEntity.setMsg("course's name cannot be empty");
			commonEntity.setStatus(15);
			return commonEntity;
		}

		try {
			mapper.insert(course.getCourse());
			
			List<Courseitem> courseitems = course.getCourseitems();

			for (Courseitem courseitem : courseitems) {
				courseitem.setCourseid(course.getCourse().getId());
				itemMapper.insert(courseitem);
			}
			commonEntity.setBean(course);
			commonEntity.setMsg("success");
			commonEntity.setStatus(0);
		} catch (Exception e) {
			e.printStackTrace();
			commonEntity.setBean(null);
			commonEntity.setMsg("failed to add this course");
			commonEntity.setStatus(16);
		}

		return commonEntity;
	}

	@Override
	public CommonEntity deleteCourse(Long id) {
		CommonEntity commonEntity = new CommonEntity();
		if (TextUtils.isNullId(id)) {
			commonEntity.setMsg("must select a course to delete");
			commonEntity.setStatus(17);
			return commonEntity;
		}

		try {
			mapper.deleteByPrimaryKey(id);
			commonEntity.setBean(id);
			commonEntity.setMsg("success");
			commonEntity.setStatus(0);
		} catch (Exception e) {
			e.printStackTrace();
			commonEntity.setBean(null);
			commonEntity.setMsg("failed to delete this  course");
			commonEntity.setStatus(18);
		}

		return commonEntity;
	}

	@Override
	public CommonEntity updateCourse(Course choose) {

		CommonEntity commonEntity = new CommonEntity();
		if (TextUtils.isNullId(choose.getId())) {
			commonEntity.setMsg("must select a course to change");
			commonEntity.setStatus(18);
			return commonEntity;
		}

		mapper.updateByPrimaryKey(choose);

		commonEntity.setBean(choose);
		commonEntity.setMsg("success");
		commonEntity.setStatus(0);
		return commonEntity;
	}

	@Override
	public CommonEntity getCourseByStudentId(Long id) {
		CommonEntity commonEntity = new CommonEntity();
		try {

			List<Course> courses = mapper.selectCoursesByStudentId(id);
			StudentVo studentVo = new StudentVo();
			studentVo.setCourses(courses);
			List<Finishstatus> finishstatus = new ArrayList<>();
			studentVo.setFinishstatus(finishstatus);

			if (courses == null)
				courses = new ArrayList<Course>();

			commonEntity.setBean(studentVo);

			for (Course course : courses) {
				FinishstatusExample example = new FinishstatusExample();
				uk.co.jsmondswimmingpool.entity.FinishstatusExample.Criteria c = example.createCriteria();
				c.andCourseidEqualTo(course.getId());
				c.andStudentidEqualTo(id);
				List<Finishstatus> selectByExample = finishMapper.selectByExample(example);
				if (selectByExample != null && !selectByExample.isEmpty()) {
					finishstatus.addAll(selectByExample);
				}
			}

			commonEntity.setMsg("success");
			commonEntity.setStatus(0);
		} catch (Exception e) {
			e.printStackTrace();
			commonEntity.setMsg("failed to courses by this student");
			commonEntity.setStatus(21);
		}
		return commonEntity;
	}

	@Override
	public CommonEntity getCourseById(Long id) {
		CommonEntity commonEntity = new CommonEntity();
		try {
			Course selectByPrimaryKey = mapper.selectByPrimaryKey(id);
			commonEntity.setMsg("success");
			commonEntity.setStatus(0);
			commonEntity.setBean(selectByPrimaryKey);
		} catch (Exception exception) {
			exception.printStackTrace();
			commonEntity.setMsg("failure");
			commonEntity.setStatus(19);

		}

		return null;
	}

	@Override
	public CommonEntity getAllItemByCourseId(Long id) {
		CourseitemExample example = new CourseitemExample();
		uk.co.jsmondswimmingpool.entity.CourseitemExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andCourseidEqualTo(id);

		CommonEntity commonEntity = new CommonEntity();
		try {
			List<Courseitem> selectByExample = itemMapper.selectByExample(example);
			commonEntity.setMsg("success");
			commonEntity.setStatus(0);
			commonEntity.setBean(selectByExample);
		} catch (Exception exception) {
			exception.printStackTrace();
			commonEntity.setMsg("failure");
			commonEntity.setStatus(20);

		}
		return commonEntity;
	}

	@Override
	public CommonEntity updateItem(Courseitem item) {
		CommonEntity commonEntity = new CommonEntity();
		try {

			int selectByExample = itemMapper.updateByPrimaryKey(item);
			commonEntity.setMsg("success");
			commonEntity.setStatus(0);
			commonEntity.setBean(selectByExample);
		} catch (Exception exception) {
			exception.printStackTrace();
			commonEntity.setMsg("failure");
			commonEntity.setStatus(21);

		}

		return commonEntity;
	}

	@Override
	public CommonEntity addItems(CourseItemVo item) {
		CommonEntity commonEntity = new CommonEntity();
		try {
				
			CourseitemExample example = new CourseitemExample();
			uk.co.jsmondswimmingpool.entity.CourseitemExample.Criteria createCriteria = example.createCriteria();
		
			createCriteria.andCourseidEqualTo(item.getCourseId());

			itemMapper.deleteByExample(example);
			for (Courseitem courseitem : item.getItems()) {
				itemMapper.insert(courseitem);
			}
			commonEntity.setBean(item);
			commonEntity.setMsg("success");
			commonEntity.setStatus(0);
		} catch (Exception exception) {
			exception.printStackTrace();
			commonEntity.setMsg("failure");
			commonEntity.setStatus(21);

		}

		return commonEntity;
	}

	@Override
	public CommonEntity deleteItem(Long id) {
		CommonEntity commonEntity = new CommonEntity();
		try {
				
			itemMapper.deleteByPrimaryKey(id);
			commonEntity.setMsg("success");
			commonEntity.setStatus(0);
		} catch (Exception exception) {
			exception.printStackTrace();
			commonEntity.setMsg("failure");
			commonEntity.setStatus(21);

		}

		return commonEntity;
	}

}
