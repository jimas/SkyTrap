package com.jimas.weixin.skytrap.repository.entity;

import java.io.Serializable;

public class TrapTask implements Serializable {
    //
    private Integer id;

    //地址code
    private String address;

    //街道信息
    private String street;

    //详细地址信息
    private String addressinfo;

    //补漏类型
    private String traptype;

    //联系人
    private String linkman;

    //联系人手机号
    private String mobile;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street == null ? null : street.trim();
    }

    public String getAddressinfo() {
        return addressinfo;
    }

    public void setAddressinfo(String addressinfo) {
        this.addressinfo = addressinfo == null ? null : addressinfo.trim();
    }

    public String getTraptype() {
        return traptype;
    }

    public void setTraptype(String traptype) {
        this.traptype = traptype == null ? null : traptype.trim();
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", address=").append(address);
        sb.append(", street=").append(street);
        sb.append(", addressinfo=").append(addressinfo);
        sb.append(", traptype=").append(traptype);
        sb.append(", linkman=").append(linkman);
        sb.append(", mobile=").append(mobile);
        sb.append("]");
        return sb.toString();
    }
}