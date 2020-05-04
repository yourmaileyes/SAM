package com.sam.controller;

import com.sam.biz.AdminBiz;
import com.sam.biz.MainBiz;
import com.sam.entity.Activity;
import com.sam.entity.Organ;
import com.sam.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;

@Controller
public class AdminController {
    @Autowired
    AdminBiz adminBiz;
    @Autowired
    MainBiz mainBiz;

    @RequestMapping(value = "allActivity")
    public String allActivity(HttpSession session){
        session.setAttribute("activities",adminBiz.getActivities());
        return "allexam";
    }
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
        response.getWriter().write("删除成功！");
    }

    @RequestMapping(value = "uA")//活动新建导航
    public String updateA(HttpSession session){
        session.removeAttribute("emsg");
        session.removeAttribute("activity");
        return "upa";
    }

    @RequestMapping(value = "updateA")//活动修改导航
    public String updateA(int id,HttpSession session){
        session.removeAttribute("emsg");
        session.removeAttribute("activity");
        session.setAttribute("activity",mainBiz.activity(id));
        return "upa";
    }

    @RequestMapping(value = "updateActivity")//修改活动
    public String updateActivity(HttpServletRequest request, HttpSession session) throws ParseException {
        adminBiz.updateActivity(request);
        session.setAttribute("emsg","操作成功！");
        return "upa";
    }

    @RequestMapping(value = "allStudent")//学生管理导航
    public String allStudent(HttpSession session){
        session.removeAttribute("emsg");
        session.removeAttribute("student");
        session.setAttribute("studentList",adminBiz.getStudents());
        return "allstudent";
    }

    @RequestMapping(value = "updateS")//学生修改导航
    public String updateS(int id,HttpSession session){
        session.removeAttribute("student");
        session.setAttribute("student",adminBiz.getStudent(id));
        return "student";
    }

    @RequestMapping(value = "deleteStudent")//删除学生
    public void deleteStudent(int id,HttpServletResponse response) throws IOException {
        adminBiz.deleteStudent(id);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("删除成功！");
    }

    @RequestMapping(value = "updateStudent")//修改学生
    public String updateStudent(Student student, HttpSession session){
        adminBiz.updateStudent(student);
        session.setAttribute("emsg","操作成功！");
        if (student.getId()==null||student.getId()==0)
            return "redirect:allStudent.do";
        else
            return "redirect:updateS.do?id="+student.getId();
    }

    @RequestMapping(value = "allOrgan")//组织者管理导航
    public String allOrgan(HttpSession session){
        session.removeAttribute("organ");
        session.setAttribute("organList",adminBiz.getOrgan());
        session.removeAttribute("emsg");
        return "alltest";
    }

    @RequestMapping(value = "updateO")//组织者修改导航
    public String updateO(int id,HttpSession session){
        session.removeAttribute("organ");
        session.setAttribute("organ",adminBiz.getOrgan(id));
        return "organ";
    }

    @RequestMapping(value = "deleteOrgan")//删除组织者
    public void deleteOrgan(int id,HttpServletResponse response) throws IOException {
        adminBiz.deleteOrgan(id);
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("删除成功！");
    }

    @RequestMapping(value = "updateOrgan")//修改组织者
    public String updateOrgan(Organ organ, HttpSession session){
        adminBiz.updateOrgan(organ);
        session.setAttribute("emsg","操作成功！");
        if (organ.getId()==null||organ.getId()==0)
            return "redirect:allOrgan.do?";
        else
            return "redirect:updateO.do?id="+organ.getId();
    }

}
