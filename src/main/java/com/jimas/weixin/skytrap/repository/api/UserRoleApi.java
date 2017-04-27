package com.jimas.weixin.skytrap.repository.api;

import java.util.List;

import com.jimas.weixin.skytrap.repository.api.request.UserRoleReq;
import com.jimas.weixin.skytrap.repository.entity.UserRole;

/**
 * @Description 用户角色
 * @author weqinjia.liu
 * @Date 2017年4月26日
 */
public interface UserRoleApi {
    
    public boolean saveUserRole(UserRole userRole);
    
    public boolean deleteByKey(Integer userRoleId);
    
    public List<UserRole> findList(UserRoleReq req);
    
    public UserRole findById(Integer userRoleId);
}
