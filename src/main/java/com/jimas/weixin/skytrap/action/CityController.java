package com.jimas.weixin.skytrap.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.jimas.common.ResultVo;
import com.jimas.weixin.skytrap.repository.api.CityApi;
import com.jimas.weixin.skytrap.repository.api.request.CityReq;
import com.jimas.weixin.skytrap.repository.api.request.PageRequest;
import com.jimas.weixin.skytrap.repository.api.response.PageResponse;
import com.jimas.weixin.skytrap.repository.entity.City;
@Controller
@RequestMapping("/city")
public class CityController extends BaseController {
    @Autowired
    private CityApi cityApi;
    
    @RequestMapping({"/cityList",""})
    public String city(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
        
        return "citylist";
    }
    
    /**
     * 查询城市
     * @param request
     * @param response
     * @param map
     * @param pageReq
     * @return
     */
    @RequestMapping("/findCitys")
    @ResponseBody
    public ResultVo<List<City>>  findTasks(HttpServletRequest request, HttpServletResponse response, ModelMap map,@ModelAttribute PageRequest<CityReq> pageReq) {
        ResultVo<List<City>> resultVo = new ResultVo<List<City>>();
        PageResponse<City> pageRes = cityApi.findByPage(pageReq);
        resultVo.setResult(pageRes.getList());
        return resultVo;
    }
    
}
