package uk.co.jsmondswimmingpool.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import uk.co.jsmondswimmingpool.entity.Finishstatus;
import uk.co.jsmondswimmingpool.entity.FinishstatusExample;

public interface FinishstatusMapper {
    int countByExample(FinishstatusExample example);

    int deleteByExample(FinishstatusExample example);

    int insert(Finishstatus record);

    int insertSelective(Finishstatus record);

    List<Finishstatus> selectByExample(FinishstatusExample example);

    int updateByExampleSelective(@Param("record") Finishstatus record, @Param("example") FinishstatusExample example);

    int updateByExample(@Param("record") Finishstatus record, @Param("example") FinishstatusExample example);
}