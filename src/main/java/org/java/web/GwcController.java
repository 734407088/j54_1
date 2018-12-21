package org.java.web;

import org.java.service.GwcService;
import org.java.service.PrdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class GwcController {

    @Autowired
    private PrdService prdService;
    @Autowired
    private GwcService gwcService;
    @RequestMapping("ck")
    public String ck(HttpSession session, Model model){
        Map user =(Map) session.getAttribute("user");
        Integer userId=Integer.parseInt(user.get("userId").toString());
        model.addAttribute("list",gwcService.getGwcs(userId));
        return "gwc";
    }

    @RequestMapping("change")
    public String change(Integer gid,String type){
        Map gwc=gwcService.getGwc(gid);
        int num=Integer.parseInt(gwc.get("gnum").toString());
        if(type.equals("tj")){
            num++;
            gwcService.upd(num,gid);
        }else if(type.equals("js")){
            if(num<=1){
                gwcService.del1(gid);
            }else{
                num--;
                gwcService.upd(num,gid);
            }
        }else if(type.equals("yc")){
            gwcService.del1(gid);
        }
        return "redirect:ck";
    }

    @RequestMapping("clear")
    public String clear(HttpSession session){
        Map user =(Map) session.getAttribute("user");
        Integer userId=Integer.parseInt(user.get("userId").toString());
        gwcService.del2(userId);
        return  "redirect:init";
    }

    @RequestMapping("reg")
    public String reg(){
        return  "redirect:init";
    }

    @RequestMapping("buy")
    @ResponseBody
    public String buy(Integer id,HttpSession session){
        Map gwc=gwcService.getGwc(id);
        Map prd=prdService.getPrd(id);
        if(gwc!=null){
            Integer num=Integer.parseInt(gwc.get("gnum").toString());
            num++;
            gwcService.upd(num,id);
        }else{
            Map user =(Map) session.getAttribute("user");
            Integer userId=Integer.parseInt(user.get("userId").toString());
            Map map=new HashMap();
            map.put("gid",prd.get("id"));
            map.put("gname",prd.get("name"));
            map.put("gprice",prd.get("price"));
            map.put("gpic",prd.get("pic"));
            map.put("gnum",1);
            map.put("userId",userId);
            gwcService.add(map);
        }
        return "s";
    }

}
