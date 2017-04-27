package com.jimas.weixin.skytrap.repository.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import com.jimas.weixin.skytrap.repository.api.RoleApi;
import com.jimas.weixin.skytrap.repository.api.request.RoleReq;
import com.jimas.weixin.skytrap.repository.dao.RoleMapper;
import com.jimas.weixin.skytrap.repository.entity.Role;
import com.jimas.weixin.skytrap.repository.entity.RoleCriteria;
import com.jimas.weixin.skytrap.repository.entity.RoleCriteria.Criteria;
@Service
public class RoleService implements RoleApi {

    @Autowired
    private RoleMapper mapper;
    
    @Override
    @Transactional(value = "appransactionManager")
    public boolean saveRole(Role role) {
        Assert.notNull(role);
        Assert.notNull(role.getRoleId(),"roleId is required; it must not be null");
        int flag =0;
        Date now = new Date();
        Role roleDb = this.findById(role.getRoleId());
        if(StringUtils.isEmpty(roleDb)){//insert
            role.setCreateTime(now);
            role.setUpdateTime(now);
            flag= mapper.insertSelective(role);
        }else{
            role.setUpdateTime(now);
            flag= mapper.updateByPrimaryKeySelective(role);
        }
        return flag>0?true:false;
    }

    @Override
    @Transactional(value = "appransactionManager")
    public boolean deleteByKey(String roleId) {
        Assert.notNull(roleId);
        return mapper.deleteByPrimaryKey(roleId)>0?true:false;
    }

    @Override
    public List<Role> findList(RoleReq req) {
        RoleCriteria example=new RoleCriteria();
        if(req!=null){
            Criteria criteria = example.createCriteria();
            if(!StringUtils.isEmpty(req.getRoleId())){
                criteria.andRoleIdEqualTo(req.getRoleId());
            }
            if(!StringUtils.isEmpty(req.getRoleName())){
                criteria.andRoleNameEqualTo(req.getRoleName());
            }
        }
        return mapper.selectByExample(example);
    }

    @Override
    public Role findById(String roleId) {
        Assert.notNull(roleId);
        return mapper.selectByPrimaryKey(roleId);
    }

}
