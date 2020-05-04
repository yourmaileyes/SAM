package com.sam.controller;

import com.sam.biz.OrganBiz;
import com.sam.entity.Activity;
import com.sam.entity.Organ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
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
        return "showanswer";
    }

    @RequestMapping(value = "getAS")
    public String getAS(int id,HttpSession session){
        session.setAttribute("AS",organBiz.getStudnets(id));
        session.setAttribute("ASID",id);
        return "message";
    }

    @RequestMapping(value = "organinfo")
    public String organinfo(HttpSession session){
        Organ organ = (Organ) session.getAttribute("loginUser");
        if (organ==null){
            return "login";
        }
        session.removeAttribute("msg");
        return "organinfo";
    }

    @RequestMapping(value = "changepasswordOrgan")
    public String changepasswordOrgan(Organ organ, HttpSession session){
        organBiz.changepasswordOrgan(organ);
        session.setAttribute("msg", "修改成功！");
        return "organinfo";
    }

    @RequestMapping(value = "deSign")
    public void deleteSign(int studentId, int activityId, HttpServletResponse res) throws IOException {
        organBiz.deleteSign(studentId,activityId);
        res.setCharacterEncoding("utf-8");
        res.getWriter().write("取消报名成功！");
    }
}
