package com.aviation.service;

import com.aviation.entity.Users;

import java.util.List;

public interface UserService {
    Users login(String username, String password);
    int register(Users users);
    List<Users> getAllUsers();//得到所有的用户
    int deleteUsers(int uid);//删除用户
    int updateUser(Users users);//修改密码
    Users getUsers(int uid);//得到用户详细信息
    int addUser(Users users);//添加用户
    List<Users> getUnBoundUser();//得到未绑定公司的用户

}
