package com.yisio.curddemo.controller;

import com.yisio.curddemo.bean.User;
import com.yisio.curddemo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
/**
 * Created by 码匠心 on 2019/10/05.
 */
@RestController
@RequestMapping("/User/UserData")
@Api(value = "UserController",description = "用户管理")
public class UserController {
    @Autowired
    UserService userService;

    @ApiOperation(value = "用户查询")
    @RequestMapping(value = "/UserData",method = RequestMethod.GET)
    public Map<String,Object> getAllUser(){
          Map<String,Object> map=new HashMap<>();
          map.put("User",userService.getAllUser());
          return map;
    }
    @ApiOperation(value = "新增用户")
    @RequestMapping(value = "/UserData/AddUser",method = RequestMethod.POST)
    public String AddUser(User users) {
        if (userService.AddUser(users)==1)
            return "新增成功！";
        return  "新增失败！";
    }
    @ApiOperation(value = "修改用户")
    @RequestMapping(value = "/UserData/updateUser",method = RequestMethod.PUT)
    public String updateUser(User users){
        if (userService.updateUser(users)==1)
            return "修改成功！";
        return "修改失败！";
    }
    @ApiOperation(value = "删除用户")
    @RequestMapping(value = "/UserData/deleteUser/{ids}",method = RequestMethod.DELETE)
    public String deleteUserByUserId(@PathVariable String ids){
        if(userService.deleteUserByUserId(ids))
          return "删除成功!";
        return "删除失败!";
    }
}
