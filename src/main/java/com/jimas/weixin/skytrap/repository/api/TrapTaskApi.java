package com.jimas.weixin.skytrap.repository.api;

import com.jimas.weixin.skytrap.repository.api.request.PageRequest;
import com.jimas.weixin.skytrap.repository.api.request.TrapTaskReq;
import com.jimas.weixin.skytrap.repository.api.response.PageResponse;
import com.jimas.weixin.skytrap.repository.entity.TrapTask;

public interface TrapTaskApi {

    /**
     * 保存补漏任务
     * @param task
     * @return
     */
    public boolean saveTrapTask(TrapTask task);
    /**
     * 根据主键删除补漏任务
     * @param id
     * @return
     */
    public boolean deleteById(int id);
    /**
     * 根据主键查询补漏任务
     * @param id
     * @return
     */
    public TrapTask findById(int id);
    /**
     * 分页查询
     * @param pageReq
     * @return
     */
    public PageResponse<TrapTask> findByParams(PageRequest<TrapTaskReq> pageReq);
}
