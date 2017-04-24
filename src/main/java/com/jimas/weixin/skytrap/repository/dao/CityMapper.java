package com.jimas.weixin.skytrap.repository.dao;

import com.jimas.weixin.skytrap.repository.entity.City;
import com.jimas.weixin.skytrap.repository.entity.CityCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CityMapper {
    int countByExample(CityCriteria example);

    int deleteByExample(CityCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(City record);

    int insertSelective(City record);

    List<City> selectByExample(CityCriteria example);

    City selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") City record, @Param("example") CityCriteria example);

    int updateByExample(@Param("record") City record, @Param("example") CityCriteria example);

    int updateByPrimaryKeySelective(City record);

    int updateByPrimaryKey(City record);
}