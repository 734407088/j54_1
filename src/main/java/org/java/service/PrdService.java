package org.java.service;

import java.util.List;
import java.util.Map;

public interface PrdService {

    public Map getPrd(Integer id);

    public List<Map>getPrds(Integer indexStart,Integer size);

    public int getNum();
}
