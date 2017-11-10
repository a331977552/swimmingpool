package uk.co.jsmondswimmingpool.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import uk.co.jsmondswimmingpool.entity.Tutor;
import uk.co.jsmondswimmingpool.entity.TutorExample;

public interface TutorMapper {
    int countByExample(TutorExample example);

    int deleteByExample(TutorExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Tutor record);

    int insertSelective(Tutor record);

    List<Tutor> selectByExample(TutorExample example);

    Tutor selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Tutor record, @Param("example") TutorExample example);

    int updateByExample(@Param("record") Tutor record, @Param("example") TutorExample example);

    int updateByPrimaryKeySelective(Tutor record);

    int updateByPrimaryKey(Tutor record);
}