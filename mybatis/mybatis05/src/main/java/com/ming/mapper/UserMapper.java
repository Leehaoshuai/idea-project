package com.ming.mapper;



import com.ming.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    @Select("select * from user")
    List<User> getUsers();

    // 方法存在多个参数
    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id") int id);

    // 引用类型不需要@Param
    @Insert("insert into user(id,name,pwd) values (#{id},#{name},#{password})")
    int addUser(User user);

    //
    @Update("update user set name=#{name},pwd=#{password} where id = #{id}")
    int updateUser(User user);


    @Delete("delete from user where id = #{uid}")
    int deleteUser(@Param("uid") int id);
}
