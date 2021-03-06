package com.jimas.weixin.skytrap.repository.dao;

import com.jimas.weixin.skytrap.repository.entity.User;
import com.jimas.weixin.skytrap.repository.entity.UserCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int countByExample(UserCriteria example);

    int deleteByExample(UserCriteria example);

    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserCriteria example);

    User selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserCriteria example);

    int updateByExample(@Param("record") User record, @Param("example") UserCriteria example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}