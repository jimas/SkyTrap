package com.jimas.weixin.skytrap.repository.service;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jimas.weixin.skytrap.BaseTest;
import com.jimas.weixin.skytrap.repository.entity.TrapTask;

public class TrapTaskServiceTest extends BaseTest{

    @Autowired
    private TrapTaskService service;
    @Test
    public void testSaveTrapTask() {
        for(int i=10;i<20;i++){
            TrapTask task=new TrapTask();
            task.setAddressinfo("测试cdsdsd"+i);
            task.setCity("上海市");
            task.setProvince("上海");
            task.setDistrict("黄浦区");
            task.setLinkman("王剩下"+i);
            task.setMobile("18912636309");
            task.setTrapType("其他");
            boolean saveTrapTask = service.saveTrapTask(task);
            System.out.println(saveTrapTask);
        }
    }

    @Test
    public void testDeleteById() {
        fail("Not yet implemented");
    }

    @Test
    public void testFindById() {
        fail("Not yet implemented");
    }

    @Test
    public void testFindByParams() {
        fail("Not yet implemented");
    }

}
