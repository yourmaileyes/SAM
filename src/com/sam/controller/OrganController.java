package com.sam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class OrganController {
   /* @RequestMapping(value = "info") // 个人中心
    public String info(HttpSession session) {
        User loginUser = (User) session.getAttribute("loginUser");
        if (loginUser == null) {
            return "login";
        }
        List<Answer> answerList = answerBiz.selectbyuserid(loginUser.getId());
        session.removeAttribute("msg");
        session.setAttribute("answerList", answerList);
        return "info";
    }

    @RequestMapping(value = "changepassword") // 修改密码
    public String changepassword(User user, HttpSession session) {
        userBiz.updateByPrimaryKeySelective(user);
        session.setAttribute("msg", "修改成功！");
        return "info";
    }*/
}
