package com.jimas.weixin.skytrap.repository.entity;

import java.io.Serializable;

public class City implements Serializable {
    //城市编码
    private String id;

    //城市名称
    private String cname;

    //父级编码
    private String upid;

    //
    private String ename;

    //
    private String pinyin;

    //等级
    private Integer level;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public String getUpid() {
        return upid;
    }

    public void setUpid(String upid) {
        this.upid = upid == null ? null : upid.trim();
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename == null ? null : ename.trim();
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin == null ? null : pinyin.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", cname=").append(cname);
        sb.append(", upid=").append(upid);
        sb.append(", ename=").append(ename);
        sb.append(", pinyin=").append(pinyin);
        sb.append(", level=").append(level);
        sb.append("]");
        return sb.toString();
    }
}