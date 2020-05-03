package com.sam.controller;

import com.sam.biz.StudentBiz;
import com.sam.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    StudentBiz studentBiz;
    @RequestMapping(value = "info") // 个人中心
    public String info(HttpSession session) {
        Student loginUser = (Student) session.getAttribute("loginUser");
        if (loginUser == null) {
            return "login";
        }
        return "info";
    }

    @RequestMapping(value = "changepassword") // 修改密码
    public String changepassword(Student student, HttpSession session) {
        studentBiz.changePassword(student);
        session.setAttribute("msg", "修改成功！");
        return "info";
    }

    @RequestMapping(value = "mytest")//我的报名
    public String mytest(HttpSession session){
        Student loginUser = (Student) session.getAttribute("loginUser");
        if (loginUser == null) {
            return "login";
        }
        session.setAttribute("activities",studentBiz.getMyActivity(loginUser.getId()));
        return "mytest";
    }
/*
    @RequestMapping(value = "passwordcheck") // ajax登录验证密码
    public void passwordcheck(User user, HttpSession session, HttpServletResponse res) throws IOException {
        User loginUser = userBiz.selectByUsername(user.getUsername());
        res.setCharacterEncoding("utf-8");
        if (loginUser == null || !loginUser.getPassword().equals(user.getPassword())) {
            res.getWriter().write("0");
            return;
        } else {
            res.getWriter().write("验证通过");
        }
    }

    */
}
