package com.jimas.weixin.skytrap.repository.dao;

import com.jimas.weixin.skytrap.repository.entity.MenuButton;
import com.jimas.weixin.skytrap.repository.entity.MenuButtonCriteria;
import com.jimas.weixin.skytrap.repository.entity.MenuButtonKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MenuButtonMapper {
    int countByExample(MenuButtonCriteria example);

    int deleteByExample(MenuButtonCriteria example);

    int deleteByPrimaryKey(MenuButtonKey key);

    int insert(MenuButton record);

    int insertSelective(MenuButton record);

    List<MenuButton> selectByExample(MenuButtonCriteria example);

    MenuButton selectByPrimaryKey(MenuButtonKey key);

    int updateByExampleSelective(@Param("record") MenuButton record, @Param("example") MenuButtonCriteria example);

    int updateByExample(@Param("record") MenuButton record, @Param("example") MenuButtonCriteria example);

    int updateByPrimaryKeySelective(MenuButton record);

    int updateByPrimaryKey(MenuButton record);
}