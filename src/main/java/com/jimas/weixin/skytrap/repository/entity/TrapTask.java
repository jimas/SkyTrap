package com.jimas.weixin.skytrap.repository.entity;

import java.io.Serializable;

public class TrapTask implements Serializable {
    //
    private Integer id;

    //省份
    private String province;

    //城市
    private String city;

    //区
    private String district;

    //街道信息
    private String street;

    //详细地址信息
    private String addressinfo;

    //补漏类型
    private String trapType;

    //联系人
    private String linkman;

    //联系人手机号
    private String mobile;

    //漏水详情
    private String trapInfo;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
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

    public String getTrapType() {
        return trapType;
    }

    public void setTrapType(String trapType) {
        this.trapType = trapType == null ? null : trapType.trim();
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

    public String getTrapInfo() {
        return trapInfo;
    }

    public void setTrapInfo(String trapInfo) {
        this.trapInfo = trapInfo == null ? null : trapInfo.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", district=").append(district);
        sb.append(", street=").append(street);
        sb.append(", addressinfo=").append(addressinfo);
        sb.append(", trapType=").append(trapType);
        sb.append(", linkman=").append(linkman);
        sb.append(", mobile=").append(mobile);
        sb.append(", trapInfo=").append(trapInfo);
        sb.append("]");
        return sb.toString();
    }
}