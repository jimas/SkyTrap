package com.jimas.weixin.skytrap.repository.api.request;

import com.jimas.weixin.skytrap.repository.domain.BaseObject;

public class TrapTaskReq extends BaseObject{

    private static final long serialVersionUID = 5635921095533945007L;

    private String province;

    //
    private String city;

    //
    private String district;

    //
    private String traptype;

    //
    private String linkman;

    //
    private String mobile;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getTraptype() {
        return traptype;
    }

    public void setTraptype(String traptype) {
        this.traptype = traptype;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    
}
