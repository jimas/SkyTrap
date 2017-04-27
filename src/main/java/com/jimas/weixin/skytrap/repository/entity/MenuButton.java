package com.jimas.weixin.skytrap.repository.entity;

import java.io.Serializable;
import java.util.Date;

public class MenuButton extends MenuButtonKey implements Serializable {
    //
    private String code;

    //
    private String name;

    //
    private String parentCode;

    //
    private String ancestorCode;

    //菜单等级
    private Integer level;

    //
    private String sortStr;

    //button、menu 按钮或菜单
    private String type;

    //状态 A:启用、 I 禁用
    private String status;

    //
    private Date createTime;

    //
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode == null ? null : parentCode.trim();
    }

    public String getAncestorCode() {
        return ancestorCode;
    }

    public void setAncestorCode(String ancestorCode) {
        this.ancestorCode = ancestorCode == null ? null : ancestorCode.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getSortStr() {
        return sortStr;
    }

    public void setSortStr(String sortStr) {
        this.sortStr = sortStr == null ? null : sortStr.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", code=").append(code);
        sb.append(", name=").append(name);
        sb.append(", parentCode=").append(parentCode);
        sb.append(", ancestorCode=").append(ancestorCode);
        sb.append(", level=").append(level);
        sb.append(", sortStr=").append(sortStr);
        sb.append(", type=").append(type);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}