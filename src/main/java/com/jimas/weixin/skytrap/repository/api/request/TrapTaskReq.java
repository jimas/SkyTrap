package com.jimas.weixin.skytrap.repository.api.request;

import com.jimas.weixin.skytrap.repository.api.domain.BaseObject;

public class TrapTaskReq extends BaseObject{

    private static final long serialVersionUID = 5635921095533945007L;

    //省份
    private String province;

    //城市
    private String city;

    //区
    private String district;

    //街道信息
    private String street;

    //补漏类型
    private String traptype;

    //联系人
    private String linkman;

    //联系人手机号
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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
