package uk.co.jsmondswimmingpool.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import uk.co.jsmondswimmingpool.entity.Achievement;
import uk.co.jsmondswimmingpool.entity.AchievementExample;

public interface AchievementMapper {
    int countByExample(AchievementExample example);

    int deleteByExample(AchievementExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Achievement record);

    int insertSelective(Achievement record);

    List<Achievement> selectByExample(AchievementExample example);

    Achievement selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Achievement record, @Param("example") AchievementExample example);

    int updateByExample(@Param("record") Achievement record, @Param("example") AchievementExample example);

    int updateByPrimaryKeySelective(Achievement record);

    int updateByPrimaryKey(Achievement record);
}