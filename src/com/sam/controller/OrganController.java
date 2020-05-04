package com.sam.controller;

import com.sam.biz.OrganBiz;
import com.sam.entity.Activity;
import com.sam.entity.Organ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class OrganController {
    @Autowired
    OrganBiz organBiz;

    @RequestMapping(value = "myActivity")
    public String myActivity(HttpSession session){
        Organ organ = (Organ) session.getAttribute("loginUser");
        if (organ==null){
            return "login";
        }
        session.setAttribute("myActivity",organBiz.getMyActiities(organ.getId()));
        return "";
    }

    @RequestMapping(value = "getAS")
    public String getAS(int id,HttpSession session){
        session.setAttribute("AS",organBiz.getStudnets(id));
        return "";
    }
}
