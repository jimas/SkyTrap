package com.jimas.weixin.skytrap.repository.service;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jimas.weixin.skytrap.BaseTest;
import com.jimas.weixin.skytrap.repository.api.MenuButtonApi;

public class MenuButtonServiceTest extends BaseTest {

    @Autowired
    private MenuButtonApi service;
    
    @Test
    public void testSaveMenuButton() {
        
    }

    @Test
    public void testDeleteByKey() {
        fail("Not yet implemented");
    }

    @Test
    public void testFindList() {
        fail("Not yet implemented");
    }

    @Test
    public void testFindByKey() {
        fail("Not yet implemented");
    }

}
