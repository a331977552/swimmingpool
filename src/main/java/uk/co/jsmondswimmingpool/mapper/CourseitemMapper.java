package uk.co.jsmondswimmingpool.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import uk.co.jsmondswimmingpool.entity.Courseitem;
import uk.co.jsmondswimmingpool.entity.CourseitemExample;

public interface CourseitemMapper {
    int countByExample(CourseitemExample example);

    int deleteByExample(CourseitemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Courseitem record);

    int insertSelective(Courseitem record);

    List<Courseitem> selectByExample(CourseitemExample example);

    Courseitem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Courseitem record, @Param("example") CourseitemExample example);

    int updateByExample(@Param("record") Courseitem record, @Param("example") CourseitemExample example);

    int updateByPrimaryKeySelective(Courseitem record);

    int updateByPrimaryKey(Courseitem record);
}