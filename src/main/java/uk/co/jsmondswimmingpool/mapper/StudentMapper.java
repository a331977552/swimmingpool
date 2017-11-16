package uk.co.jsmondswimmingpool.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import uk.co.jsmondswimmingpool.entity.CourseChoosing;
import uk.co.jsmondswimmingpool.entity.Student;
import uk.co.jsmondswimmingpool.entity.StudentExample;
import uk.co.jsmondswimmingpool.entity.custom.SignVo;

public interface StudentMapper {
    int countByExample(StudentExample example);

    int deleteByExample(StudentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExample(StudentExample example);

    Student selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

	List<Student> selectByCourseId(Long id);


	List<CourseChoosing> selectStuIdAndCourseIdByTodayAndTutorId(SignVo signVo);

	List<Long> selectTimeTableByTutorIdAndCourseDate(SignVo signVo);
}