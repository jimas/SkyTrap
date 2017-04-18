package com.jimas.weixin.skytrap.repository.entity;

import java.io.Serializable;

public class TrapTask implements Serializable {
    //
    private Integer id;

    //
    private String province;

    //
    private String city;

    //
    private String district;

    //
    private String street;

    //
    private String addressinfo;

    //
    private String traptype;

    //
    private String linkman;

    //
    private String mobile;

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
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", district=").append(district);
        sb.append(", street=").append(street);
        sb.append(", addressinfo=").append(addressinfo);
        sb.append(", traptype=").append(traptype);
        sb.append(", linkman=").append(linkman);
        sb.append(", mobile=").append(mobile);
        sb.append("]");
        return sb.toString();
    }
}