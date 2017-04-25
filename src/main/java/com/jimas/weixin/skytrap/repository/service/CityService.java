package com.jimas.weixin.skytrap.repository.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import com.jimas.weixin.skytrap.repository.api.CityApi;
import com.jimas.weixin.skytrap.repository.api.request.CityReq;
import com.jimas.weixin.skytrap.repository.api.request.PageRequest;
import com.jimas.weixin.skytrap.repository.api.response.PageResponse;
import com.jimas.weixin.skytrap.repository.dao.CityMapper;
import com.jimas.weixin.skytrap.repository.entity.City;
import com.jimas.weixin.skytrap.repository.entity.CityCriteria;
import com.jimas.weixin.skytrap.repository.entity.CityCriteria.Criteria;

@Service
public class CityService implements CityApi {

    @Autowired
    private CityMapper mapper;

    @Override
    public boolean saveCity(City city) {
        City cityDb = mapper.selectByPrimaryKey(city.getId());
        int flag = 0;
        if (cityDb != null) {// update
            flag = mapper.updateByPrimaryKeySelective(city);
        } else {
            flag = mapper.insertSelective(city);
        }
        return flag > 0 ? true : false;
    }

    @Override
    public City findCityByParam(String province, String city, String district) {

        if (!StringUtils.isEmpty(district)) {
            CityCriteria example = new CityCriteria();
            Criteria createCriteria = example.createCriteria();
            createCriteria.andCnameEqualTo(district);
            List<City> districtList = mapper.selectByExample(example);
            if(districtList.size()==1){
                return districtList.get(0);
            }
            
            example.clear();
            createCriteria = example.createCriteria();
            createCriteria.andCnameEqualTo(city);
            List<City> cityList = mapper.selectByExample(example);
            for (City districtCity : districtList) {
                if (districtCity.getUpid().equals(cityList.get(0).getId())) {
                    return districtCity;
                }
            }
            
        }
        if (!StringUtils.isEmpty(city)) {
            CityCriteria example = new CityCriteria();
            Criteria createCriteria = example.createCriteria();
            createCriteria.andCnameEqualTo(city);
            List<City> cityList = mapper.selectByExample(example);
            if(cityList.size()==1){
                return cityList.get(0);
            }
            createCriteria.andCnameEqualTo(province);
            List<City> provinceList = mapper.selectByExample(example);
            for (City cityCity : cityList) {
                if (cityCity.getUpid().equals(provinceList.get(0).getId())) {
                    return cityCity;
                }
            }
        }
        if (!StringUtils.isEmpty(province)) {
            CityCriteria example = new CityCriteria();
            Criteria createCriteria = example.createCriteria();
            createCriteria.andCnameEqualTo(province);
            List<City> provinceList = mapper.selectByExample(example);
            return provinceList.get(0);
            
        }
        return null;
    }

    @Override
    public PageResponse<City> findByPage(PageRequest<CityReq> pageReq) {
        Assert.notNull(pageReq);
        CityCriteria example=new CityCriteria();
        example.setLimitSize(pageReq.getLimit());
        example.setLimitStart(pageReq.getStep());
        CityReq params = pageReq.getParams();
        if(!StringUtils.isEmpty(params)){
            Criteria criteria = example.createCriteria();
            if(!StringUtils.isEmpty(params.getCname())){
                criteria.andCnameEqualTo(params.getCname());
            }
            if(!StringUtils.isEmpty(params.getId())){
                criteria.andIdEqualTo(params.getId());
            }
            if(!StringUtils.isEmpty(params.getLevel())){
                criteria.andLevelEqualTo(params.getLevel());
            }
            if(!StringUtils.isEmpty(params.getUpid())){
                criteria.andUpidEqualTo(params.getUpid());
            }
        }
        int total = mapper.countByExample(example);
        List<City> list = mapper.selectByExample(example);
        PageResponse<City> pageResponse = new PageResponse<City>(total,pageReq.getPageNumber());
        pageResponse.setList(list);
        return pageResponse;
    }

}
