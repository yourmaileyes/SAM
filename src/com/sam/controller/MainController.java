package com.sam.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sam.biz.MainBiz;
import com.sam.entity.Comment;
import com.sam.entity.Student;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sam.util.DateUtil;
import com.sam.util.code;

@Controller
public class MainController {
	@Autowired
	MainBiz mainBiz;

	@RequestMapping(value = "index") // 主页导航
	public String index(HttpSession session) {
		session.setAttribute("activities",mainBiz.activities());
		return "index";
	}

	@RequestMapping(value = "login") // 登录
	public String login(String username, String password, String type, HttpSession session) {
		Object loginUser = mainBiz.longin(username,password,type);
		if (loginUser==null){
			session.setAttribute("massage","用户名或密码错误！");
			return "login";
		}
		session.removeAttribute("massage");
		session.setAttribute("loginUser", loginUser);
		switch (type){
			case "1":
				return "redirect:index.do";
			case "2":
				return "organ";
			case "3":
				return "admin";
		}
		return "redirect:index.do";
	}

	@RequestMapping(value = "passwordcheck") // ajax登录验证密码
	public void passwordcheck(String username,String password,String type,HttpSession session, HttpServletResponse res) throws IOException {
		res.setCharacterEncoding("utf-8");
		if (mainBiz.longin(username,password,type) == null) {
			res.getWriter().write("0");
		} else {
			res.getWriter().write("验证通过");
		}
	}

	@RequestMapping(value = "varcodecheck") // ajax登录验证验证码
	public void varcodecheck(String varcode, HttpSession session, HttpServletResponse res) throws IOException {
		String varcode0 = (String) session.getAttribute("varcode");
		res.setCharacterEncoding("utf-8");
		if (!varcode0.equalsIgnoreCase(varcode)) {
			res.getWriter().write("0");
		} else {
			res.getWriter().write("验证通过");
		}
	}

	@RequestMapping(value = "changevarcode") // 生成验证码
	public void changevarcode(HttpSession session, HttpServletResponse res) throws IOException {
		code co = new code();
		co.drawImage(res.getOutputStream());
		session.setAttribute("varcode", co.getCode());
	}

	@RequestMapping(value = "activity")
	public String activity(int id,HttpSession session){
		session.removeAttribute("emsg");
		session.setAttribute("activity",mainBiz.activity(id));
		session.setAttribute("comments",mainBiz.getComments(id));
		Student student = (Student) session.getAttribute("loginUser");
		if (student!=null)
			session.setAttribute("isSelect",mainBiz.isSelect(student.getId(),id));
		return "activity";
	}

	@RequestMapping(value = "subreview")
	public String subreview(Comment comment, HttpSession session){
		Student student = (Student) session.getAttribute("loginUser");
		comment.setStudentid(student.getId());
		comment.setUsername(student.getAccount());
		mainBiz.insertComment(comment);
		return "redirect:activity.do?id="+comment.getActivityid();
	}

	@RequestMapping(value = "insertSign")
	public void insertSign(int avtivityid,int userid, HttpServletResponse res) throws IOException {
		mainBiz.insertSign(userid,avtivityid);
		res.setCharacterEncoding("utf-8");
		res.getWriter().write("报名成功！");
	}

	@RequestMapping(value = "deleteSign")
	public void deleteSign(int avtivityid,int userid, HttpServletResponse res) throws IOException {
		mainBiz.deleteSign(userid,avtivityid);
		res.setCharacterEncoding("utf-8");
		res.getWriter().write("true");
	}

	/*@RequestMapping(value = "usercheck") // ajax验证用户名是否使用
	public void usercheck(String username, HttpSession session, HttpServletResponse res) throws IOException {
		User loginUser = userBiz.selectByUsername(username);
		res.setCharacterEncoding("utf-8");
		if (loginUser != null) {
			res.getWriter().write("1");
			return;
		} else {
			res.getWriter().write("验证通过");
		}
	}*/

	/*@RequestMapping(value = "regist") // 注册
	public String regist(User user, HttpSession session) {
		user.setId(DateUtil.getId());
		userBiz.insertSelective(user);
		return "redirect:index.do";
	}*/

	@RequestMapping(value = "logout") // 退出登录
	public String logout(HttpSession session) {
		session.removeAttribute("loginUser");
		return "redirect:index.do";
	}


}
