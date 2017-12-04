package uk.co.jsmondswimmingpool.service.imp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.co.jsmondswimmingpool.entity.Achievement;
import uk.co.jsmondswimmingpool.entity.AchievementExample;
import uk.co.jsmondswimmingpool.entity.Attendance;
import uk.co.jsmondswimmingpool.entity.AttendanceExample;
import uk.co.jsmondswimmingpool.entity.CourseChoosing;
import uk.co.jsmondswimmingpool.entity.CourseChoosingExample;
import uk.co.jsmondswimmingpool.entity.Finishstatus;
import uk.co.jsmondswimmingpool.entity.FinishstatusExample;
import uk.co.jsmondswimmingpool.entity.Student;
import uk.co.jsmondswimmingpool.entity.StudentExample;
import uk.co.jsmondswimmingpool.entity.StudentExample.Criteria;
import uk.co.jsmondswimmingpool.entity.custom.CommonEntity;
import uk.co.jsmondswimmingpool.entity.custom.StudentVo;
import uk.co.jsmondswimmingpool.exception.NullIdException;
import uk.co.jsmondswimmingpool.mapper.AchievementMapper;
import uk.co.jsmondswimmingpool.mapper.AttendanceMapper;
import uk.co.jsmondswimmingpool.mapper.CourseChoosingMapper;
import uk.co.jsmondswimmingpool.mapper.CourseMapper;
import uk.co.jsmondswimmingpool.mapper.FinishstatusMapper;
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

	@Autowired
	AchievementMapper achievementMapper;

	@Autowired
	SimpleDateFormat simpleDate;
	@Autowired
	AttendanceMapper attendanceMapper;

	@Autowired
	FinishstatusMapper mapperFinish;

	@Override
	public CommonEntity getAll(uk.co.jsmondswimmingpool.entity.custom.StudentVo vo) {
		CommonEntity bean = new CommonEntity();
		StudentExample example = new StudentExample();
		example.setOrderByClause("id desc");
		if (vo != null) {
			Criteria criteria = example.createCriteria();
			if (vo.getStudent() != null) {
				if (!TextUtils.isEmpty(vo.getStudent().getName()))
					criteria.andNameLike("%" + vo.getStudent().getName() + "%");
			}

		}

		try {
			List<Student> students = mapper.selectByExample(example);
			bean.setBean(students);
			bean.setMsg("success");
			bean.setStatus(0);
		} catch (Exception e) {
			bean.setStatus(1001);
			bean.setMsg("failed to get all the Students");
			e.printStackTrace();
		}

		return bean;
	}

	@Override
	public CommonEntity findById(Long id) {

		CommonEntity bean = new CommonEntity();
		try {

			Student student = mapper.selectByPrimaryKey(id);

			bean.setBean(student);
			bean.setMsg("success");
			bean.setStatus(0);
		} catch (Exception e) {
			bean.setStatus(1002);
			bean.setMsg("failed to get the student");
			e.printStackTrace();
		}
		return bean;
	}

	@Override
	public CommonEntity addStudent(Student student) {
		CommonEntity bean = new CommonEntity();
		if (student == null)
			return null;
		try {
			mapper.insert(student);
			bean.setBean(student);
			bean.setMsg("success");
			bean.setStatus(0);
		} catch (Exception e) {
			e.printStackTrace();
			e.printStackTrace();
			bean.setStatus(1003);
			bean.setMsg("failed to add this Student");

		}

		return bean;

	}

	@Override
	public CommonEntity updateStudent(Student student) {
		CommonEntity bean = new CommonEntity();

		try {
			if (student == null || student.getId() == null || student.getId() < 0)
				throw new NullIdException("id = null");
			mapper.updateByPrimaryKeySelective(student);
			bean.setBean(student);
			bean.setMsg("success");
			bean.setStatus(0);
		} catch (Exception e) {

			e.printStackTrace();
			bean.setStatus(1004);
			bean.setMsg("failed to update this student");
		}
		return bean;
	}

	@Override
	public CommonEntity deleteStudent(Long id) {
		CommonEntity bean = new CommonEntity();

		try {
			if (TextUtils.isNullId(id))
				throw new NullIdException("id = null");
			mapper.deleteByPrimaryKey(id);

			bean.setBean(null);
			bean.setMsg("success");
			bean.setStatus(0);
		} catch (Exception e) {
			e.printStackTrace();
			bean.setStatus(1005);
			bean.setMsg("failed to delete this student");
		}
		return bean;
	}

	@Override
	public CommonEntity getAttendanceRecord(Attendance id) {
		CommonEntity entity = new CommonEntity();
		AttendanceExample attendanceExample = new AttendanceExample();
		uk.co.jsmondswimmingpool.entity.AttendanceExample.Criteria c = attendanceExample.createCriteria();
		c.andCourseidEqualTo(id.getCourseid());
		c.andStudentidEqualTo(id.getStudentid());

		try {
			List<Attendance> selectByExample = attendanceMapper.selectByExample(attendanceExample);
			entity.setBean(selectByExample);
			entity.setMsg("success");
			entity.setStatus(0);
		} catch (Exception e) {

			e.printStackTrace();
			entity.setStatus(1006);
			entity.setMsg("failed to get attendance records");

		}

		return entity;
	}

	@Override
	public CommonEntity finishCourse(Finishstatus finish) {
		CommonEntity entity = new CommonEntity();

		try {
			int selectByExample = mapperFinish.insert(finish);
			entity.setBean(finish);
			entity.setMsg("success");
			entity.setStatus(0);
		} catch (Exception e) {
			e.printStackTrace();
			entity.setStatus(1007);
			entity.setMsg("failed to finish this course for this student");
		}
		return entity;
	}

	@Override
	public CommonEntity getAchievement(Long id) {
		CommonEntity entity = new CommonEntity();
		try {
			AchievementExample example = new AchievementExample();
			uk.co.jsmondswimmingpool.entity.AchievementExample.Criteria createCriteria = example.createCriteria();
			createCriteria.andStudentidEqualTo(id);
			List<Achievement> selectByExample = achievementMapper.selectByExample(example);
			entity.setBean(selectByExample);
			entity.setStatus(0);
			entity.setMsg("success");
		} catch (Exception e) {
			e.printStackTrace();
			entity.setStatus(1008);
			entity.setMsg("failed to get achievements");

		}

		return entity;
	}

	@Override
	public CommonEntity getAllByCourseId(Long id) {
		CourseChoosingExample example = new CourseChoosingExample();
		uk.co.jsmondswimmingpool.entity.CourseChoosingExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andCourseidEqualTo(id);
		CommonEntity commonEntity = new CommonEntity();

		try {
			List<CourseChoosing> selectByExample = mapperchoosing.selectByExample(example);
			if (!selectByExample.isEmpty()) {
				List<Long> studentIds = new ArrayList<>();

				for (CourseChoosing courseChoosing : selectByExample) {
					
					studentIds.add(courseChoosing.getStudentid());
				}

				StudentExample example2 = new StudentExample();
				Criteria createCriteria2 = example2.createCriteria();
				createCriteria2.andIdIn(studentIds);

				
				List<Student> selectByExample2 = mapper.selectByExample(example2);
				List<Long> ids=new ArrayList<>();
				List<StudentVo> listvo=new  ArrayList<>();
				
				for (Student student : selectByExample2) {
					StudentVo studentVo=new StudentVo();
					studentVo.setStudent(student);
					listvo.add(studentVo);
//					select * from attendance where studentid in (1,2) and courseid=1 and record_date="2017-11-19"
					ids.add(student.getId());			
				}
				if(!ids.isEmpty())
				{
					AttendanceExample example3=new AttendanceExample();
					uk.co.jsmondswimmingpool.entity.AttendanceExample.Criteria c = example3.createCriteria();
					 c.andRecordDateEqualTo(new Date());
					 c.andCourseidEqualTo(id);
					 c.andStudentidIn(ids);
					List<Attendance> selectByExample3 = attendanceMapper.selectByExample(example3);
					for (Attendance attendance : selectByExample3) {
						inner:for (StudentVo vo : listvo) {
							if(vo.getStudent().getId().longValue()==attendance.getStudentid().longValue()) {
								vo.setAttendance(attendance);
								break inner;
							}
						}
					}
				}
				commonEntity.setBean(listvo);
				
			}else {				
				commonEntity.setBean(new ArrayList<StudentVo>());
			}
			commonEntity.setMsg("success");
			commonEntity.setStatus(0);

		} catch (Exception e) {
			commonEntity.setMsg("failed to get students info");
			commonEntity.setStatus(1009);
			e.printStackTrace();
		}

		return commonEntity;
	}

	@Override
	public CommonEntity signIn(Attendance attendance) {
		CommonEntity commonEntity = new CommonEntity();

		try {

			if (TextUtils.isNullId(attendance.getCourseid(), attendance.getStudentid())) {
				commonEntity.setBean(null);
				commonEntity.setMsg("failed to SignIn");
				commonEntity.setStatus(1010);

			} else {
				commonEntity.setMsg("success");
				commonEntity.setStatus(0);
				attendance.setRecordDate(new Date());
				attendanceMapper.insert(attendance);
				commonEntity.setBean(attendance);
			}
		} catch (Exception e) {
			commonEntity.setMsg("failed to SignIn");
			commonEntity.setStatus(1011);
			e.printStackTrace();
		}
		return commonEntity;
	}

	@Override
	public CommonEntity achieve(Achievement achievement) {
		CommonEntity commonEntity = new CommonEntity();
		try {
			AchievementExample example=new AchievementExample();
			uk.co.jsmondswimmingpool.entity.AchievementExample.Criteria c = example.createCriteria();
			c.andCourseidEqualTo(achievement.getCourseid());
			c.andStudentidEqualTo(achievement.getStudentid());
			c.andCourseitemidEqualTo(achievement.getCourseitemid());
			
			List<Achievement> selectByExample = achievementMapper.selectByExample(example);
			if(TextUtils.isListEmpty(selectByExample))
			achievementMapper.insert(achievement);
			commonEntity.setBean(achievement);
			commonEntity.setMsg("success");
			commonEntity.setStatus(0);
			
		} catch (Exception e) {
			e.printStackTrace();
			commonEntity.setBean(achievement);
			commonEntity.setMsg("failed to set up achievement");
			commonEntity.setStatus(0);
		}
		return commonEntity;
	}

	@Override
	public CommonEntity updateFinishCourseState(Finishstatus finish) {
		CommonEntity commonEntity = new CommonEntity();
		try {
			FinishstatusExample example=new FinishstatusExample();
			uk.co.jsmondswimmingpool.entity.FinishstatusExample.Criteria createCriteria = example.createCriteria();
			createCriteria.andCourseidEqualTo(finish.getCourseid());
			createCriteria.andStudentidEqualTo(finish.getStudentid());
			mapperFinish.deleteByExample(example);
			commonEntity.setStatus(0);
			commonEntity.setMsg("success");
		} catch (Exception e) {
			e.printStackTrace();
			commonEntity.setBean(null);
			commonEntity.setMsg("failed to set up achievement");
			commonEntity.setStatus(1012);
		}
		return commonEntity;
	}

}
