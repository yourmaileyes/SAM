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
	public String login(String username, String password, int type, HttpSession session) {
		Object loginUser = mainBiz.longin(username,password,type);
		if (loginUser==null){
			session.setAttribute("massage","用户名或密码错误！");
			return "login";
		}
		session.removeAttribute("massage");
		session.setAttribute("loginUser", loginUser);
		return "redirect:index.do";
	}

	@RequestMapping(value = "passwordcheck") // ajax登录验证密码
	public void passwordcheck(String username,String password,int type,HttpSession session, HttpServletResponse res) throws IOException {
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
