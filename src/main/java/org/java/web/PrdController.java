package org.java.web;

import org.java.service.PrdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PrdController {

    @Autowired
    private PrdService prdService;

    @RequestMapping("init")
    public String init(@RequestParam(value = "page",required = false) Integer page, Model model){
        if(page==null){
            page=1;
        }
        int size=5;
        int count=prdService.getNum();
        int maxPage=(count-1)/size+1;
        Map<String,Object>map=new HashMap<>();
        map.put("size",size);
        map.put("count",count);
        map.put("maxPage",maxPage);
        map.put("page",page);
        model.addAttribute("map",map);
        List<Map>list=prdService.getPrds(page,size);
        model.addAttribute("list",list);
        return "index";
    }
}
