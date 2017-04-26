package com.jimas.weixin.skytrap.repository.dao;

import com.jimas.weixin.skytrap.repository.entity.Role;
import com.jimas.weixin.skytrap.repository.entity.RoleCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {
    int countByExample(RoleCriteria example);

    int deleteByExample(RoleCriteria example);

    int deleteByPrimaryKey(String roleId);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleCriteria example);

    Role selectByPrimaryKey(String roleId);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleCriteria example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleCriteria example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}