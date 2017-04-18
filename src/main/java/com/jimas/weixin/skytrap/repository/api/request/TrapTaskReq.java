package com.jimas.weixin.skytrap.repository.api.request;

import com.jimas.weixin.skytrap.repository.api.domain.BaseObject;

public class TrapTaskReq extends BaseObject{

    private static final long serialVersionUID = 5635921095533945007L;

    //地址code
    private String address;

    //街道信息
    private String street;

    //补漏类型
    private String traptype;

    //联系人
    private String linkman;

    //联系人手机号
    private String mobile;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
