package uk.co.jsmondswimmingpool.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import uk.co.jsmondswimmingpool.entity.Coursetimetable;
import uk.co.jsmondswimmingpool.entity.CoursetimetableExample;

public interface CoursetimetableMapper {
    int countByExample(CoursetimetableExample example);

    int deleteByExample(CoursetimetableExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Coursetimetable record);

    int insertSelective(Coursetimetable record);

    List<Coursetimetable> selectByExample(CoursetimetableExample example);

    Coursetimetable selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Coursetimetable record, @Param("example") CoursetimetableExample example);

    int updateByExample(@Param("record") Coursetimetable record, @Param("example") CoursetimetableExample example);

    int updateByPrimaryKeySelective(Coursetimetable record);

    int updateByPrimaryKey(Coursetimetable record);
}