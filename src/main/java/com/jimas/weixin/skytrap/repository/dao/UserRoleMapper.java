package com.jimas.weixin.skytrap.repository.dao;

import com.jimas.weixin.skytrap.repository.entity.UserRole;
import com.jimas.weixin.skytrap.repository.entity.UserRoleCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRoleMapper {
    int countByExample(UserRoleCriteria example);

    int deleteByExample(UserRoleCriteria example);

    int deleteByPrimaryKey(Integer userRoleId);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    List<UserRole> selectByExample(UserRoleCriteria example);

    UserRole selectByPrimaryKey(Integer userRoleId);

    int updateByExampleSelective(@Param("record") UserRole record, @Param("example") UserRoleCriteria example);

    int updateByExample(@Param("record") UserRole record, @Param("example") UserRoleCriteria example);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);
}