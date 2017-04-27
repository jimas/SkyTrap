package com.jimas.weixin.skytrap.repository.entity;

import java.io.Serializable;

public class MenuButtonKey implements Serializable {
    //系统来源
    private String siteSource;

    //操作url
    private String operateUrl;

    private static final long serialVersionUID = 1L;

    public String getSiteSource() {
        return siteSource;
    }

    public void setSiteSource(String siteSource) {
        this.siteSource = siteSource == null ? null : siteSource.trim();
    }

    public String getOperateUrl() {
        return operateUrl;
    }

    public void setOperateUrl(String operateUrl) {
        this.operateUrl = operateUrl == null ? null : operateUrl.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", siteSource=").append(siteSource);
        sb.append(", operateUrl=").append(operateUrl);
        sb.append("]");
        return sb.toString();
    }
}