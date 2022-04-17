package com.aviation.service.impl;

import com.aviation.entity.Users;
import com.aviation.mapper.UserMapper;
import com.aviation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private UserMapper userMapper;

    public Users login(String username,String password){
        return userMapper.login(username,password);
    }

    public int register(Users user){
        return userMapper.register(user);
    }

    @Override
    public List<Users> getAllUsers() {
        return userMapper.getAllUsers();
    }

    @Override
    public int deleteUsers(int uid) {
        return userMapper.deleteUsers(uid);
    }

    @Override
    public Users getUsers(int uid) {
        return userMapper.getUsers(uid);
    }

    @Override
    public int updateUser(Users users) {
        return userMapper.updateUser(users);
    }

    @Override
    public int addUser(Users users) {
        return userMapper.addUser(users);
    }

    @Override
    public List<Users> getUnBoundUser() {
        return userMapper.getUnBoundUser();
    }
}
