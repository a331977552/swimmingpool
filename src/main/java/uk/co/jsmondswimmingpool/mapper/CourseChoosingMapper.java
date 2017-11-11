package uk.co.jsmondswimmingpool.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import uk.co.jsmondswimmingpool.entity.CourseChoosing;
import uk.co.jsmondswimmingpool.entity.CourseChoosingExample;

public interface CourseChoosingMapper {
    int countByExample(CourseChoosingExample example);

    int deleteByExample(CourseChoosingExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CourseChoosing record);

    int insertSelective(CourseChoosing record);

    List<CourseChoosing> selectByExample(CourseChoosingExample example);

    CourseChoosing selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CourseChoosing record, @Param("example") CourseChoosingExample example);

    int updateByExample(@Param("record") CourseChoosing record, @Param("example") CourseChoosingExample example);

    int updateByPrimaryKeySelective(CourseChoosing record);

    int updateByPrimaryKey(CourseChoosing record);

    
}