package com.aviation.util;

import com.aviation.entity.Menu;
import com.aviation.service.MenuService;

import java.util.ArrayList;
import java.util.List;

public class CreateMenu {

	// 装载数据的容器
	private static List<Menu> menuList = null;
	
	private StringBuffer sb = null ;

	String defaultrole = "";

	
	// 构造方法 － 查询所有的数据 - 列出了一级菜单
	public CreateMenu(String role,MenuService menuService){
		menuList = menuService.getMenuList();
		defaultrole = role;
		sb = new StringBuffer("");
	}
	
	// 列出一级菜单
	public String printMenu() {
		sb.append("<ul class=\"nav\" id=\"side-menu\">");
		sb.append("<li class=\"nav-header\">");
		sb.append(" <div class=\"dropdown profile-element\">");
		sb.append("<a data-toggle=\"dropdown\" class=\"dropdown-toggle\" href=\"#\">");
		sb.append("<span class=\"clear\">");
		sb.append("<span class=\"block m-t-xs\" style=\"font-size:20px;\">");
		sb.append("<i class=\"fa fa-plane\"></i>");
		sb.append("<strong class=\"font-bold\">Aviation</strong>");
		sb.append("</span>");
		sb.append("</span>");
		sb.append("</a>");
		sb.append("</div>");
		sb.append("<div class=\"logo-element\">Aviation");
		sb.append("</div>");
		sb.append("</li>");
		sb.append("<li>\n" +
				"                        <a class=\"J_menuItem\" href=\"index_v2\">\n" +
				"                            <i class=\"fa fa-home\"></i>\n" +
				"                            <span class=\"nav-label\">主页</span>\n" +
				"                        </a>\n" +
				"                    </li>");


		for(Menu m : menuList) {
			if(m.getParent_id() == 0) {
				sb.append("\n<li id=" + m.getMenu_id() + ">");
				sb.append("<a href=\""+m.getHref()+"\">");
				sb.append("<i class=\"fa fa-edit\"></i>");
				sb.append("<span class=\"nav-label\">"+m.getMenu_name()+"</span>");
				sb.append("<span class=\"fa arrow\"></span>");
				sb.append("</a>");
				sb.append("\n<ul class=\"nav nav-second-level\">");
				// 列出子菜单
				printSubMenu(m);
				sb.append("\n</ul>");
				sb.append("</li>");
				sb.append("<li class=\"line dk\"></li>");
			}
		}
		sb.append("\n</ul>");
		return sb.toString();
	}
	
	/**
	 * 将子菜单拼接stringbuffer中
	 * @param menu
	 */
	private void printSubMenu(Menu menu) {
		// 子菜单集合
		List<Menu> subList = getSubMenu(menu);
		
		for(Menu m : subList) {
			List<Menu> thirdList = getSubMenu(m);
			if (thirdList.size() > 0){
				sb.append("<li>");
				sb.append("<a id=" + m.getMenu_id() + " href="+m.getHref()+">"+m.getMenu_name()+" <span class=\"fa arrow\"></span></a>");
				printThirdMenu(m);
				sb.append("</li>");
			}
			else {
				sb.append("\n<li id=" + m.getMenu_id() + "><a class=\"J_menuItem\" href=\"" + m.getHref() + "\">" + m.getMenu_name() + "</a></li>");
			}

		}
	}

	/**
	 * 将三级菜单拼接stringbuffer中
	 * @param menu
	 */
	private void printThirdMenu(Menu menu){
		// 子菜单集合
		List<Menu> subList = getSubMenu(menu);

		sb.append("<ul class=\"nav nav-third-level\">");

		for (Menu m : subList){
			sb.append("\n<li id=" + m.getMenu_id() + "><a class=\"J_menuItem\" href=\""+m.getHref()+"\">"+m.getMenu_name()+"</a></li>");
		}
		sb.append("</ul>");

	}
	
	/**
	 * 获取某个父级菜单的子菜单集合
	 * @param menu 父级菜单的对象
	 * @return 子菜单的集合
	 */
	private List<Menu> getSubMenu(Menu menu) {
		List<Menu> subList = new ArrayList<Menu>();
		// 遍历所有的menu数据
		for(Menu m : menuList) {
			if(m.getParent_id() == menu.getMenu_id() && m.getRole().contains(defaultrole)) {
				subList.add(m);
			}                            
		}
		return subList;
	}



}
