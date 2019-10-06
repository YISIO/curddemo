package com.yisio.curddemo.service;

import com.yisio.curddemo.bean.User;
import com.yisio.curddemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * Created by 码匠心 on 2019/10/05.
 */
@Service
@Transactional
public class UserService {
    @Autowired
    UserMapper userMapper;
    public List<User> getAllUser(){
        return userMapper.getAllUser();
    }
    private  void UserDo(User users)
    {
        users.setUserId(users.UserId);
        users.setUserName(users.UserName);
        users.setPlace(users.Place);
        users.setSex(users.Sex);
        users.setWedlock(users.Wedlock);
    }
    public int AddUser(User users)  {
        UserDo(users);
        return userMapper.AddUser(users);
    }
    public  int updateUser(User users){
        UserDo(users);
        return userMapper.updateUser(users);
    }
    public  boolean deleteUserByUserId(String ids){
      String[] split = ids.split(",");
      return userMapper.deleteUserByUserId(split) == split.length;
    }
}
