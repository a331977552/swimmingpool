package uk.co.jsmondswimmingpool.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import uk.co.jsmondswimmingpool.entity.Attendance;
import uk.co.jsmondswimmingpool.entity.AttendanceExample;

public interface AttendanceMapper {
    int countByExample(AttendanceExample example);

    int deleteByExample(AttendanceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Attendance record);

    int insertSelective(Attendance record);

    List<Attendance> selectByExample(AttendanceExample example);

    Attendance selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Attendance record, @Param("example") AttendanceExample example);

    int updateByExample(@Param("record") Attendance record, @Param("example") AttendanceExample example);

    int updateByPrimaryKeySelective(Attendance record);

    int updateByPrimaryKey(Attendance record);
}