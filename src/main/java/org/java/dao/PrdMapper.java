package org.java.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface PrdMapper {

    public List<Map>getPrds(@Param("indexStart")int indexStart,@Param("size")int size);

    public Map getPrd(@Param("id")int id);

    public int getNum();
}
