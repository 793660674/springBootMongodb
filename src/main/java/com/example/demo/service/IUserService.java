package com.example.demo.service;

import com.example.demo.entity.Users;

import java.util.List;

/**
 * mongodb 案例
 * 创建者  tj
 * 创建时间    2019年5月5日
 *
 */
public interface IUserService {
    public void saveUser(Users users);

    public Users findUserByName(String name);

    public void removeUser(String name);

    public void updateUser(String name, String key, String value);

    public List<Users> listUser();
}