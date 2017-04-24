package com.jimas.weixin.skytrap.repository.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import com.jimas.weixin.skytrap.repository.api.TrapTaskApi;
import com.jimas.weixin.skytrap.repository.api.request.PageRequest;
import com.jimas.weixin.skytrap.repository.api.request.TrapTaskReq;
import com.jimas.weixin.skytrap.repository.api.response.PageResponse;
import com.jimas.weixin.skytrap.repository.dao.TrapTaskMapper;
import com.jimas.weixin.skytrap.repository.entity.TrapTask;
import com.jimas.weixin.skytrap.repository.entity.TrapTaskCriteria;
import com.jimas.weixin.skytrap.repository.entity.TrapTaskCriteria.Criteria;
@Service
public class TrapTaskService implements TrapTaskApi {

    @Autowired
    private TrapTaskMapper mapper;
    
    @Override
    @Transactional(value = "appransactionManager")
    public boolean saveTrapTask(TrapTask task) {
        Assert.notNull(task);
        int flag =0;
        if(StringUtils.isEmpty(task.getId())){//insert
            flag= mapper.insertSelective(task);
        }else{
            TrapTask trapTaskDb = this.findById(task.getId());
            if(trapTaskDb!=null){
                flag= mapper.updateByPrimaryKeySelective(task);
            }
        }
        return flag>0?true:false;
    }

    @Override
    @Transactional(value = "appransactionManager")
    public boolean deleteById(int id) {
        Assert.notNull(id);
        int flag = mapper.deleteByPrimaryKey(id);
        return flag>0?true:false;
    }

    @Override
    public TrapTask findById(int id) {
        Assert.notNull(id);
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResponse<TrapTask> findByParams(PageRequest<TrapTaskReq> pageReq) {
        Assert.notNull(pageReq);
        TrapTaskCriteria example=new TrapTaskCriteria();
        example.setLimitSize(pageReq.getLimit());
        example.setLimitStart(pageReq.getStep());
        TrapTaskReq params = pageReq.getParams();
        if(!StringUtils.isEmpty(params)){
            Criteria criteria = example.createCriteria();
            if(!StringUtils.isEmpty(params.getProvince())){
                criteria.andProvinceEqualTo(params.getProvince());
            }
            if(!StringUtils.isEmpty(params.getCity())){
                criteria.andCityEqualTo(params.getCity());
            }
            if(!StringUtils.isEmpty(params.getDistrict())){
                criteria.andDistrictEqualTo(params.getDistrict());
            }
            if(!StringUtils.isEmpty(params.getLinkman())){
                criteria.andLinkmanEqualTo(params.getLinkman());
            }
            if(!StringUtils.isEmpty(params.getMobile())){
                criteria.andMobileEqualTo(params.getMobile());
            }
            if(!StringUtils.isEmpty(params.getTrapType())){
                criteria.andTrapTypeEqualTo(params.getTrapType());
            }
        }
        int total = mapper.countByExample(example);
        List<TrapTask> list = mapper.selectByExample(example);
        PageResponse<TrapTask> pageResponse = new PageResponse<TrapTask>(total,pageReq.getPageNumber());
        pageResponse.setList(list);
        return pageResponse;
    }

}
