package com.jimas.weixin.skytrap.repository.api.request;

import com.jimas.weixin.skytrap.repository.api.domain.BaseObject;

public class CityReq extends BaseObject{

    private static final long serialVersionUID = 8941882545197035008L;
    //城市编码
    private String id;

    //城市名称
    private String cname;

    //父级编码
    private String upid;

    //等级
    private Integer level;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getUpid() {
        return upid;
    }

    public void setUpid(String upid) {
        this.upid = upid;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
    
    
}
