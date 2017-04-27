package com.jimas.weixin.skytrap.repository.api.request;

import com.jimas.weixin.skytrap.repository.api.domain.BaseObject;

public class MenuButtonReq extends BaseObject {

    private static final long serialVersionUID = -8045860576496630527L;
   
    //操作url 主键
    private String operateUrl;
    //系统来源
    private String siteSource;
    //菜单等级
    private Integer level;

    //button、menu 按钮或菜单
    private String type;

    //状态 A:启用、 I 禁用
    private String status;

    public String getOperateUrl() {
        return operateUrl;
    }

    public void setOperateUrl(String operateUrl) {
        this.operateUrl = operateUrl;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSiteSource() {
        return siteSource;
    }

    public void setSiteSource(String siteSource) {
        this.siteSource = siteSource;
    }
    
    
    
}
