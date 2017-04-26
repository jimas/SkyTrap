package com.jimas.weixin.skytrap.repository.dao;

import com.jimas.weixin.skytrap.repository.entity.MenuButton;
import com.jimas.weixin.skytrap.repository.entity.MenuButtonCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MenuButtonMapper {
    int countByExample(MenuButtonCriteria example);

    int deleteByExample(MenuButtonCriteria example);

    int deleteByPrimaryKey(String operateUrl);

    int insert(MenuButton record);

    int insertSelective(MenuButton record);

    List<MenuButton> selectByExample(MenuButtonCriteria example);

    MenuButton selectByPrimaryKey(String operateUrl);

    int updateByExampleSelective(@Param("record") MenuButton record, @Param("example") MenuButtonCriteria example);

    int updateByExample(@Param("record") MenuButton record, @Param("example") MenuButtonCriteria example);

    int updateByPrimaryKeySelective(MenuButton record);

    int updateByPrimaryKey(MenuButton record);
}