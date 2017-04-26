package com.jimas.weixin.skytrap.repository.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jimas.weixin.skytrap.repository.api.MenuButtonApi;
import com.jimas.weixin.skytrap.repository.api.request.MenuButtonReq;
import com.jimas.weixin.skytrap.repository.dao.MenuButtonMapper;
import com.jimas.weixin.skytrap.repository.entity.MenuButton;
@Service
public class MenuButtonService implements MenuButtonApi {

    @Autowired
    private MenuButtonMapper mapper;
    
    @Override
    public boolean saveMenuButton(MenuButton menuButton) {
        return false;
    }

    @Override
    public boolean deleteByKey(String operateUrl) {
        return false;
    }

    @Override
    public List<MenuButton> findList(MenuButtonReq req) {
        return null;
    }

    @Override
    public MenuButton findById(String operateUrl) {
        return null;
    }

}
