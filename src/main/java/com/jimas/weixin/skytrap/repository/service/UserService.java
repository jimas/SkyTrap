package com.jimas.weixin.skytrap.repository.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import com.jimas.common.util.VagueQueryUtils;
import com.jimas.weixin.skytrap.repository.api.UserApi;
import com.jimas.weixin.skytrap.repository.api.request.UserReq;
import com.jimas.weixin.skytrap.repository.dao.UserMapper;
import com.jimas.weixin.skytrap.repository.entity.User;
import com.jimas.weixin.skytrap.repository.entity.UserCriteria;
import com.jimas.weixin.skytrap.repository.entity.UserCriteria.Criteria;

@Service
public class UserService implements UserApi {

    @Autowired
    private UserMapper mapper;
    
    @Override
    @Transactional(value = "appransactionManager")
    public boolean saveUser(User user) {
        Assert.notNull(user);
        int flag =0;
        Date now = new Date();
        if(StringUtils.isEmpty(user.getUserId())){//insert
            user.setCreateTime(now);
            user.setUpdateTime(now);
            flag= mapper.insertSelective(user);
        }else{
            User userDb = this.findById(user.getUserId());
            if(userDb!=null){
                user.setUpdateTime(now);
                flag= mapper.updateByPrimaryKeySelective(user);
            }
        }
        return flag>0?true:false;
    }

    @Override
    @Transactional(value = "appransactionManager")
    public boolean deleteByKey(Integer userId) {
        Assert.notNull(userId);
        return mapper.deleteByPrimaryKey(userId)>0?true:false;
    }

    @Override
    public List<User> findList(UserReq req) {
        UserCriteria example=new UserCriteria();
        if(req!=null){
            Criteria criteria = example.createCriteria();
            if(!StringUtils.isEmpty(req.getEmail())){
                criteria.andEmailLike(VagueQueryUtils.getVagueParam(req.getEmail()));
            }
            if(!StringUtils.isEmpty(req.getIdCard())){
                criteria.andIdCardLike(VagueQueryUtils.getVagueParam(req.getIdCard()));
            }
            if(!StringUtils.isEmpty(req.getMobile())){
                criteria.andMobileLike(VagueQueryUtils.getVagueParam(req.getMobile()));
            }
            if(!StringUtils.isEmpty(req.getNickname())){
                criteria.andNicknameLike(VagueQueryUtils.getVagueParam(req.getNickname()));
            }
            if(!StringUtils.isEmpty(req.getOpenId())){
                criteria.andOpenIdLike(VagueQueryUtils.getVagueParam(req.getOpenId()));
            }
            if(!StringUtils.isEmpty(req.getRealName())){
                criteria.andRealNameLike(VagueQueryUtils.getVagueParam(req.getRealName()));
            }
            if(!StringUtils.isEmpty(req.getSex())){
                criteria.andSexEqualTo(req.getSex());
            }
            if(!StringUtils.isEmpty(req.getUserName())){
                criteria.andUserNameLike(VagueQueryUtils.getVagueParam(req.getUserName()));
            }
        }
        example.setOrderByClause("create_time desc");
        return mapper.selectByExample(example);
    }

    @Override
    public User findById(Integer userId) {
        Assert.notNull(userId);
        return mapper.selectByPrimaryKey(userId);
    }

}
