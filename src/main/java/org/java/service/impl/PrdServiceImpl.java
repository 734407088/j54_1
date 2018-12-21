package org.java.service.impl;

import org.java.dao.PrdMapper;
import org.java.service.PrdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PrdServiceImpl  implements PrdService {

    @Autowired
    private PrdMapper prdMapper;
    @Override
    public Map getPrd(Integer id) {
        return prdMapper.getPrd(id);
    }

    @Override
    public List<Map> getPrds(Integer indexStart, Integer size) {
        return prdMapper.getPrds((indexStart-1)*size,size);
    }

    @Override
    public int getNum() {
        return prdMapper.getNum();
    }
}
