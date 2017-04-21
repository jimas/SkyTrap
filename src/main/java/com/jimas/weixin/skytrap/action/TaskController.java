package com.jimas.weixin.skytrap.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jimas.common.ResultVo;
import com.jimas.common.constant.ResultStatusEnum;
import com.jimas.common.util.ResultUtil;
import com.jimas.weixin.skytrap.repository.api.TrapTaskApi;
import com.jimas.weixin.skytrap.repository.entity.TrapTask;
/**
 * @Description 任务 控制层
 * @author weqinjia.liu
 * @Date 2017年4月19日
 */
@Controller
@RequestMapping("/task")
public class TaskController extends BaseController{
    
    private static final Logger logger=Logger.getLogger(TaskController.class);
    @Autowired
    private TrapTaskApi trapTaskApi;
    
    /**
     * 跳转到 发布任务页面
     * @param request
     * @param response
     * @param map
     * @return
     */
    @RequestMapping("/toAddTask")
    public String toAddTask(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
        
        return "task";
    }
    /**
     * 新增 发布任务
     * @param request
     * @param response
     * @param map
     * @return
     */
    @RequestMapping("/addTask")
    @ResponseBody
    public ResultVo<Object> addTask(HttpServletRequest request, HttpServletResponse response,@RequestParam(value="address",required=true) String address, @ModelAttribute TrapTask trapTask) {
        ResultVo<Object> resultVo = new ResultVo<Object>();
        try {
            String[] split = address.split(" ");
            trapTask.setProvince(split[0]);
            if(split.length>1){
                trapTask.setCity(split[1]);
            }
            if(split.length>2){
                trapTask.setDistrict(split[2]);
            }
            boolean save = trapTaskApi.saveTrapTask(trapTask);
            if(!save){
                return ResultUtil.initResultVo(ResultStatusEnum.SERVICE_EXCEPTION.getStatus(),"保存失败",null);
            }
        } catch (Exception e) {
            logger.error("trapTaskApi.saveTrapTask error", e);
            return ResultUtil.initResultVo(ResultStatusEnum.SERVICE_EXCEPTION.getStatus());
        }
        
        return resultVo;
    }
}
