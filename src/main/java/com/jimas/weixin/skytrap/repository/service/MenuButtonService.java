package com.jimas.weixin.skytrap.repository.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import com.jimas.weixin.skytrap.repository.api.MenuButtonApi;
import com.jimas.weixin.skytrap.repository.api.request.MenuButtonReq;
import com.jimas.weixin.skytrap.repository.dao.MenuButtonMapper;
import com.jimas.weixin.skytrap.repository.entity.MenuButton;
import com.jimas.weixin.skytrap.repository.entity.MenuButtonCriteria;
import com.jimas.weixin.skytrap.repository.entity.MenuButtonCriteria.Criteria;
import com.jimas.weixin.skytrap.repository.entity.MenuButtonKey;
@Service
public class MenuButtonService implements MenuButtonApi {

    @Autowired
    private MenuButtonMapper mapper;
    
    @Override
    @Transactional(value = "appransactionManager")
    public boolean saveMenuButton(MenuButton menuButton) {
        Assert.notNull(menuButton);
        Assert.notNull(menuButton.getOperateUrl(),"OperateUrl is required; it must not be null");
        Assert.notNull(menuButton.getSiteSource(),"SiteSource is required; it must not be null");
        int flag =0;
        Date now = new Date();
        MenuButtonKey key=new MenuButtonKey();
        key.setOperateUrl(menuButton.getOperateUrl());
        key.setSiteSource(menuButton.getSiteSource());
        MenuButton menuButtonDb = this.findByKey(key);
        if(StringUtils.isEmpty(menuButtonDb)){//insert
            menuButton.setCreateTime(now);
            menuButton.setUpdateTime(now);
            flag= mapper.insertSelective(menuButton);
        }else{
            if(menuButtonDb!=null){
                menuButton.setUpdateTime(now);
                flag= mapper.updateByPrimaryKeySelective(menuButton);
            }
        }
        return flag>0?true:false;
    }

    @Override
    @Transactional(value = "appransactionManager")
    public boolean deleteByKey(MenuButtonKey key) {
        Assert.notNull(key);
        Assert.notNull(key.getOperateUrl(),"OperateUrl is required; it must not be null");
        Assert.notNull(key.getSiteSource(),"SiteSource is required; it must not be null");
        return mapper.deleteByPrimaryKey(key)>0?true:false;
    }

    @Override
    public List<MenuButton> findList(MenuButtonReq req) {
        MenuButtonCriteria example=new MenuButtonCriteria();
        if(req!=null){
            Criteria criteria = example.createCriteria();
            if(!StringUtils.isEmpty(req.getOperateUrl())){
                criteria.andOperateUrlEqualTo(req.getOperateUrl());
            }
            if(!StringUtils.isEmpty(req.getSiteSource())){
                criteria.andSiteSourceEqualTo(req.getSiteSource());
            }
            if(!StringUtils.isEmpty(req.getLevel())){
                criteria.andLevelEqualTo(req.getLevel());
            }
            if(!StringUtils.isEmpty(req.getStatus())){
                criteria.andStatusEqualTo(req.getStatus());
            }
            if(!StringUtils.isEmpty(req.getType())){
                criteria.andTypeEqualTo(req.getType());
            }
        }
        return mapper.selectByExample(example);
    }

    @Override
    public MenuButton findByKey(MenuButtonKey key) {
        Assert.notNull(key);
        Assert.notNull(key.getOperateUrl(),"OperateUrl is required; it must not be null");
        Assert.notNull(key.getSiteSource(),"SiteSource is required; it must not be null");
        return mapper.selectByPrimaryKey(key);
    }

}
