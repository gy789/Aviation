package com.aviation.service;

import com.aviation.entity.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> getMenuList();
    int addMenu(Menu menu);//添加menu（主要是添加快递公司菜单信息）
    int deleteMenu(String menu_name);

}
