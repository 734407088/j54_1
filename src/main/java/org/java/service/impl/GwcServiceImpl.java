package org.java.service.impl;

import org.java.dao.GwcMapper;
import org.java.service.GwcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GwcServiceImpl implements GwcService {

    @Autowired
    private GwcMapper gwcMapper;
    @Override
    public List<Map> getGwcs(int userId) {
        return gwcMapper.getGwcs(userId);
    }

    @Override
    public Map getGwc(int gid) {
        return gwcMapper.getGwc(gid);
    }

    @Override
    public void upd(int num, int gid) {
          gwcMapper.upd(num, gid);
    }

    @Override
    public void add(Map map) {
          gwcMapper.add(map);
    }

    @Override
    public void del1(int gid) {
         gwcMapper.del1(gid);
    }

    @Override
    public void del2(int userId) {
        gwcMapper.del2(userId);
    }
}
