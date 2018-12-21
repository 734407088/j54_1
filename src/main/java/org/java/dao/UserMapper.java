package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

@Mapper
public interface UserMapper {

    public Map getUser(@Param("uname")String uname,@Param("upwd")String upwd);
}
