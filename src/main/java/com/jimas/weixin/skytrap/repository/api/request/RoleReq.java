package com.jimas.weixin.skytrap.repository.api.request;

import com.jimas.weixin.skytrap.repository.api.domain.BaseObject;

public class RoleReq extends BaseObject {

    private static final long serialVersionUID = 6639494808931381773L;
    //主键:admin:超级管理员、customer:客户、Engineer:工程师、CSE:客服
    private String roleId;

    //角色名称
    private String roleName;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    
    
}
