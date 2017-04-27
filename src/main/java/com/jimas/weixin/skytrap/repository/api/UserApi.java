package com.jimas.weixin.skytrap.repository.api;

import java.util.List;
import com.jimas.weixin.skytrap.repository.api.request.UserReq;
import com.jimas.weixin.skytrap.repository.entity.User;

/**
 * @Description 用户接口
 * @author weqinjia.liu
 * @Date 2017年4月26日
 */
public interface UserApi {

    public boolean saveUser(User user);
    
    public boolean deleteByKey(Integer userId);
    
    public List<User> findList(UserReq req);
    
    public User findById(Integer userId);
}
