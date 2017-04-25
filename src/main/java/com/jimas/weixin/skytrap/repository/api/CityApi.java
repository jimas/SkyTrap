package com.jimas.weixin.skytrap.repository.api;

import com.jimas.weixin.skytrap.repository.api.request.CityReq;
import com.jimas.weixin.skytrap.repository.api.request.PageRequest;
import com.jimas.weixin.skytrap.repository.api.response.PageResponse;
import com.jimas.weixin.skytrap.repository.entity.City;

public interface CityApi {

    public boolean saveCity(City city);
    
    public City findCityByParam(String province,String city,String district);
    
    public PageResponse<City> findByPage(PageRequest<CityReq> pageReq);
}
