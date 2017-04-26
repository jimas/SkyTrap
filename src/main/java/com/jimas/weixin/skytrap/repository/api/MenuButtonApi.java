package com.jimas.weixin.skytrap.repository.api;

import java.util.List;

import com.jimas.weixin.skytrap.repository.api.request.MenuButtonReq;
import com.jimas.weixin.skytrap.repository.entity.MenuButton;

public interface MenuButtonApi {
    
    public boolean saveMenuButton(MenuButton menuButton);
    
    public boolean deleteByKey(String operateUrl);
    
    public List<MenuButton> findList(MenuButtonReq req);
    
    public MenuButton findById(String operateUrl);
}
