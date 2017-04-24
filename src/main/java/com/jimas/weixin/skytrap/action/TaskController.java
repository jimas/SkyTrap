package com.jimas.weixin.skytrap.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jimas.common.ResultVo;
import com.jimas.common.constant.ResultStatusEnum;
import com.jimas.common.util.ResultUtil;
import com.jimas.weixin.skytrap.repository.api.CityApi;
import com.jimas.weixin.skytrap.repository.api.TrapTaskApi;
import com.jimas.weixin.skytrap.repository.api.request.PageRequest;
import com.jimas.weixin.skytrap.repository.api.request.TrapTaskReq;
import com.jimas.weixin.skytrap.repository.api.response.PageResponse;
import com.jimas.weixin.skytrap.repository.entity.City;
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
    @Autowired
    private CityApi cityApi;
    
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
    @RequestMapping(value="/addTask",method=RequestMethod.POST )
    @ResponseBody
    public ResultVo<Object> addTask(HttpServletRequest request, HttpServletResponse response,@RequestParam(value="address",required=true) String address, @ModelAttribute TrapTask trapTask) {
        ResultVo<Object> resultVo = new ResultVo<Object>();
        try {
            String[] split = address.split(" ");
            trapTask.setProvince(split[0]);
            if(split.length>1){
                trapTask.setCity(split[1]);
            }else{
                trapTask.setCity("");
            }
            if(split.length>2){
                trapTask.setDistrict(split[2]);
            }else{
                trapTask.setDistrict("");
            }
            boolean save = trapTaskApi.saveTrapTask(trapTask);
            if(!save){
                String message=trapTask.getId()==null?"新增失败":"修改失败,该【"+trapTask.getId()+"】任务不存在。";
                return ResultUtil.initResultVo(ResultStatusEnum.SERVICE_EXCEPTION.getStatus(),message,null);
            }
        } catch (Exception e) {
            logger.error("trapTaskApi.saveTrapTask error", e);
            return ResultUtil.initResultVo(ResultStatusEnum.SERVICE_EXCEPTION.getStatus());
        }
        
        return resultVo;
    }
    /**
     * 显示任务列表
     * @param request
     * @param response
     * @param map
     * @return
     */
    @RequestMapping("/taskList")
    public String taskList(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
        return "tasklist";
    }
    /**
     * 删除任务
     * @param request
     * @param response
     * @param map
     * @param taskId
     * @return
     */
    @RequestMapping(value="/taskDelete",method=RequestMethod.POST )
    @ResponseBody
    public ResultVo<Object> taskDelete(HttpServletRequest request, HttpServletResponse response, ModelMap map,@RequestParam(value="taskId",required=true) Integer taskId) {
        ResultVo<Object> resultVo = new ResultVo<Object>();
        try {
            boolean deleteById = trapTaskApi.deleteById(taskId);   
            if(!deleteById){
                return ResultUtil.initResultVo(ResultStatusEnum.SERVICE_EXCEPTION.getStatus(),"删除失败",null);
            }
        } catch (Exception e) {
            logger.error("trapTaskApi.deleteById error", e);
            return ResultUtil.initResultVo(ResultStatusEnum.SERVICE_EXCEPTION.getStatus());
        }
        return resultVo;
    }
    /**
     * 跳转到任务编辑页面
     * @param request
     * @param response
     * @param map
     * @param taskId
     * @return
     */
    @RequestMapping(value="/taskEdit")
    public String taskEdit(HttpServletRequest request, HttpServletResponse response, ModelMap map,@RequestParam(value="taskId",required=true) Integer taskId) {
        TrapTask task = trapTaskApi.findById(taskId);
        if(task==null){
            task=new TrapTask();
            task.setId(taskId);
        }else{
            City city = cityApi.findCityByParam(task.getProvince(), task.getCity(), task.getDistrict());
            map.put("addressCode", city.getId());
        }
        map.put("task", task);
        return "taskEdit";
    }
    /**
     * 查询任务
     * @param request
     * @param response
     * @param map
     * @param pageReq
     * @return
     */
    @RequestMapping("/findTasks")
    @ResponseBody
    public ResultVo<List<TrapTask>>  findTasks(HttpServletRequest request, HttpServletResponse response, ModelMap map,@ModelAttribute PageRequest<TrapTaskReq> pageReq) {
        ResultVo<List<TrapTask>> resultVo = new ResultVo<List<TrapTask>>();
        PageResponse<TrapTask> pageRes = trapTaskApi.findByParams(pageReq);
        resultVo.setResult(pageRes.getList());
        return resultVo;
    }
}
