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
        TrapTask task=new TrapTask();
        boolean saveTrapTask = service.saveTrapTask(task);
        System.out.println(saveTrapTask);
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
