package com.jimas.weixin.skytrap.repository.api;

import java.util.List;

import com.jimas.weixin.skytrap.repository.api.request.RoleReq;
import com.jimas.weixin.skytrap.repository.entity.Role;

/**
 * @Description 角色
 * @author weqinjia.liu
 * @Date 2017年4月26日
 */
public interface RoleApi {

    public boolean saveRole(Role role);
    
    public boolean deleteByKey(String roleId);
    
    public List<Role> findList(RoleReq req);
    
    public Role findById(String roleId);
    
}
