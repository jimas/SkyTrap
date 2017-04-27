package com.jimas.weixin.skytrap.repository.api;

import java.util.List;

import com.jimas.weixin.skytrap.repository.api.request.MenuButtonReq;
import com.jimas.weixin.skytrap.repository.entity.MenuButton;
import com.jimas.weixin.skytrap.repository.entity.MenuButtonKey;

public interface MenuButtonApi {
    
    public boolean saveMenuButton(MenuButton menuButton);
    
    public boolean deleteByKey(MenuButtonKey key);
    
    public List<MenuButton> findList(MenuButtonReq req);
    
    public MenuButton findByKey(MenuButtonKey key);
}
