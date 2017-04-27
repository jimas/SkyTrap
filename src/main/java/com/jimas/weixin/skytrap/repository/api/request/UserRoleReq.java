package com.jimas.weixin.skytrap.repository.api.request;

import com.jimas.weixin.skytrap.repository.api.domain.BaseObject;

public class UserRoleReq extends BaseObject {

    private static final long serialVersionUID = 2937550286034723256L;
    //主键
    private Integer userRoleId;

    //admin:超级管理员、customer:客户、Engineer:工程师、CSE:客服
    private String roleId;

    //
    private Integer userId;

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    
}
