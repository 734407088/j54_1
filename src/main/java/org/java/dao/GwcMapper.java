package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface GwcMapper {

    public List<Map> getGwcs(@Param("userId")int userId);

    public Map getGwc(@Param("gid") int gid);

    public void upd(@Param("num") int num,@Param("gid") int gid);

    public void add(Map map);

    public void del1(@Param("gid")int gid);

    public void del2(@Param("userId")int userId);

}
