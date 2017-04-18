package com.jimas.weixin.skytrap.repository.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.jimas.weixin.skytrap.repository.entity.TrapTask;
import com.jimas.weixin.skytrap.repository.entity.TrapTaskCriteria;

public interface TrapTaskMapper {
    int countByExample(TrapTaskCriteria example);

    int deleteByExample(TrapTaskCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(TrapTask record);

    int insertSelective(TrapTask record);

    List<TrapTask> selectByExample(TrapTaskCriteria example);

    TrapTask selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TrapTask record, @Param("example") TrapTaskCriteria example);

    int updateByExample(@Param("record") TrapTask record, @Param("example") TrapTaskCriteria example);

    int updateByPrimaryKeySelective(TrapTask record);

    int updateByPrimaryKey(TrapTask record);
}