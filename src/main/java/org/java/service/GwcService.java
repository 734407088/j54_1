package org.java.service;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface GwcService {

    public List<Map> getGwcs(int userId);

    public Map getGwc( int gid);

    public void upd( int num, int gid);

    public void add(Map map);

    public void del1(int gid);

    public void del2(int userId);
}
