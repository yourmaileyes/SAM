package com.sam.controller;

import com.sam.biz.AdminBiz;
import com.sam.biz.MainBiz;
import com.sam.entity.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class AdminController {
    @Autowired
    AdminBiz adminBiz;
    @Autowired
    MainBiz mainBiz;

    @RequestMapping(value = "aplActivity")//审批活动
    public void aplActivity(int id, HttpServletResponse response) throws IOException {
        adminBiz.aplActivity(id);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("审批成功！");
    }

    @RequestMapping(value = "deleteActivity")//删除活动
    public void deleteActivity(int id,HttpServletResponse response) throws IOException {
        adminBiz.deleteActivity(id);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("审批成功！");
    }

    @RequestMapping(value = "updateA")//活动修改导航
    public String updateA(int id,HttpSession session){
        session.removeAttribute("emsg");
        session.removeAttribute("activity");
        session.setAttribute("activity",mainBiz.activity(id));
        return "upa";
    }

    @RequestMapping(value = "updateActivity")//修改活动
    public String updateActivity(Activity activity, HttpSession session){
        adminBiz.updateActivity(activity);
        session.setAttribute("emsg","修改成功！");
        return "upa";
    }

}
