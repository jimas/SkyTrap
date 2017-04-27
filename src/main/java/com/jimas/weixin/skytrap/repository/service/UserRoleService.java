package com.jimas.weixin.skytrap.repository.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.jimas.weixin.skytrap.repository.api.UserRoleApi;
import com.jimas.weixin.skytrap.repository.api.request.UserRoleReq;
import com.jimas.weixin.skytrap.repository.dao.UserRoleMapper;
import com.jimas.weixin.skytrap.repository.entity.UserRole;
import com.jimas.weixin.skytrap.repository.entity.UserRoleCriteria;
import com.jimas.weixin.skytrap.repository.entity.UserRoleCriteria.Criteria;
@Service
public class UserRoleService implements UserRoleApi {

    @Autowired
    private UserRoleMapper mapper;
    
    @Override
    @Transactional(value = "appransactionManager")
    public boolean saveUserRole(UserRole userRole) {
        Assert.notNull(userRole);
        int flag =0;
        Date now = new Date();
        if(StringUtils.isEmpty(userRole.getUserId())){//insert
            userRole.setCreateTime(now);
            userRole.setUpdateTime(now);
            flag= mapper.insertSelective(userRole);
        }else{
            UserRole userRoleDb = this.findById(userRole.getUserId());
            if(userRoleDb!=null){
                userRole.setUpdateTime(now);
                flag= mapper.updateByPrimaryKeySelective(userRole);
            }
        }
        return flag>0?true:false;
    }

    @Override
    @Transactional(value = "appransactionManager")
    public boolean deleteByKey(Integer userRoleId) {
        Assert.notNull(userRoleId);
        return mapper.deleteByPrimaryKey(userRoleId)>0?true:false;
    }

    @Override
    public List<UserRole> findList(UserRoleReq req) {
        UserRoleCriteria example=new UserRoleCriteria();
        if(req!=null){
            Criteria criteria = example.createCriteria();
            if(!StringUtils.isEmpty(req.getRoleId())){
                criteria.andRoleIdEqualTo(req.getRoleId());
            }
            if(!StringUtils.isEmpty(req.getUserId())){
                criteria.andUserIdEqualTo(req.getUserId());
            }
            if(!StringUtils.isEmpty(req.getUserRoleId())){
                criteria.andUserRoleIdEqualTo(req.getUserRoleId());
            }
        }
        return mapper.selectByExample(example);
    }

    @Override
    public UserRole findById(Integer userRoleId) {
        Assert.notNull(userRoleId);
        return mapper.selectByPrimaryKey(userRoleId);
    }

}
