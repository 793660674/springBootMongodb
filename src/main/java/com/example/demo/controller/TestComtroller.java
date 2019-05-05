package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Users;
import com.example.demo.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: Tj
 * @Date: 2019/5/5 16:50
 * @Description:
 */
@RestController
@RequestMapping(value = "/mangodb")
@Api(description = "java使用mangodb")
public class TestComtroller {

    @Autowired
    private IUserService userService;



    @ApiOperation(value = "新增用户")
    @RequestMapping(value = "/add" , method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "姓名", required = true, dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "age", value = "年龄", required = true, dataType = "int",paramType = "query"),
            @ApiImplicitParam(name = "uid", value = "id", required = true, dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "address", value = "地址", required = true, dataType = "String",paramType = "query")
    })
    public Object add(String name,Integer age,String uid,String address){
        Users users = new Users(uid, name, age);
        users.setAddress(address);
        userService.saveUser(users);
        List<Users> list = userService.listUser();
        System.out.println("一共这么多人:"+list.size());
        return list;
    }
    @ApiOperation(value = "查询")
    @RequestMapping(value = "/findUserByName" , method = RequestMethod.GET)
    @ApiImplicitParam(name = "name", value = "姓名", required = true, dataType = "String",paramType = "query")
    public Object findUserByName(String name){
        return userService.findUserByName(name);
    }
    @ApiOperation(value = "删除")
    @RequestMapping(value = "/removeUserByName" , method = RequestMethod.GET)
    @ApiImplicitParam(name = "name", value = "姓名", required = true, dataType = "String",paramType = "query")
    public void removeUser(String name){
        userService.removeUser(name);
    }
    @ApiOperation(value = "修改用户")
    @RequestMapping(value = "/updateUser" , method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "姓名", required = true, dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "key", value = "条件字段key", required = true, dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "value", value = "条件值", required = true, dataType = "String",paramType = "query")
    })
    public void updateUser(String name, String key, String value){
        userService.updateUser(name,key,value);
    }

    public Object listUser(){
        return  userService.listUser();
    }
}