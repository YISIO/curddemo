package com.yisio.curddemo.mapper;

import com.yisio.curddemo.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
/**
 * Created by 码匠心 on 2019/10/05.
 */
import java.util.List;
@Mapper
public interface UserMapper {
     List<User> getAllUser();
     int AddUser(User users);
     int updateUser(@Param("users") User users);
     int deleteUserByUserId(@Param("ids") String[] ids);
}
