<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
<title>SAM登录</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/course.css">
<link  rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css"> 
<script type="text/javascript" src="bootstrap-3.3.7-dist/js/jquery-3.2.1.min.js"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="style/css/11.css">

</head>

<body>

	<div id="ui" style="text-align:center;">
	<div class="user ">
	<div class="logo" style="margin-bottom: 50px;margin-top: 50px;">
	<a href=#>
	<img src="${pageContext.request.contextPath }/images/1.jpg" width="204px" class="img-rounded"></a>
	</div>
	<!-- uiView:  -->
	<div data-ui-view="" class="container">



	<div class="container-fluid full ">
	<form id="login1" action="login.do" method="post" 
						class="form col-md-4 col-md-offset-4 ">
		<div class="form-group" >
			<label for="type" class="col-md-3 control-label">角色</label>
			<select id="type" name="type"
				   class="form-control input-lg" placeholder="用户名">
				<option selected="selected" value="1">学生</option>
				<option value="2">组织</option>
				<option value="3">管理员</option>
			</select>
		</div>
						<label for="username" class="col-md-3 control-label">用户名</label>
						<div class="form-group" >
							<input id="username" name="username" type="text"
								class="form-control input-lg" placeholder="用户名">
						</div>
						<label for="password" class="col-md-3 control-label">密码</label>
						<div class="form-group">
							<input id="password" name="password" type="password"
								class="form-control input-lg" placeholder="登录密码">
						</div>
						<label class="col-md-3 control-label"
					for="varcode">验证码</label> <br><input class="form-control input-lg" id="varcode"
					type="text" name="varcode" ><img onclick="changevarcode()" id="varcodeimg" alt="验证码" src="changevarcode.do"> <br>
						<div class="form-group" id ="email">
							
						</div>
						<div class="form-group" id="phone">
							
					    </div>
					    <div class="form-group" id="nickname">
							
					    </div>
					    <div class="form-group" id="sex">
							
					    </div>
					
						<div class="form-group">
							<div id="loginInfo"></div>
						</div>
						 
						<div class="form-group">
							<button id="submit1" class="btn btn-primary btn-lg btn-block"
								type="button" onclick="validatePassword()">立刻登录</button>
						</div>
					</form>
	</div>
	</div>
	
	<div class="footer">
	<a class="icon-ic_login_backhome" href="index.do">
	返回首页</a>
		</div>
	</div>
	</div>


	
	
	<script type="text/javascript">
	<!--实现动态改变页面进行注册操作 -->
	
	
		function validatePassword() {
			var username = $("#username").val();
			var password = $("#password").val();
			var varcode = $("#varcode").val();
			var isok = true;
			/* 判断用户名密码是否为空 */
			if (username == "") {
				$("#loginInfo").html(
						"<b style='color:red;font-size:15px;'>用户名不能为空！</b>");
				$("#username").focus();
				isok = false;
				return;
			}
			if (password == "") {
				$("#loginInfo").html(
						"<b style='color:red;font-size:15px;'>密码不能为空！</b>");
				$("#password").focus();
				isok = false;
				return;
			}
			if (varcode == "") {
				$("#loginInfo").html(
						"<b style='color:red;font-size:15px;'>验证码不能为空！</b>");
				$("#varcode").focus();
				isok = false;
				return;
			}
			$
			.ajax({
				type : "post",
				url : "varcodecheck.do",
				data : {
					"varcode" : varcode
				},
				async : false,
				dataType : 'text',
				success : function(data) {
					if (data == 0) {
						$("#loginInfo")
								.html(
										"<b style='color:red;font-size:15px;'>验证码错误!</b>");
						isok = false;
						return 0;
					} else{
						$
						.ajax({
							type : "post",
							url : "passwordcheck.do",
							data : {
								"username" : username,
								"password" : password,
								"type" : 1
							},
							async : false,
							dataType : 'text',
							success : function(data) {
								if (data == 3) {
									$("#loginInfo")
											.html(
													"<b style='color:red;font-size:15px;'>您的账号已被屏蔽!</b>");
									changevarcode();
									isok = false;
								}else
								if (data == 0) {
									$("#loginInfo")
											.html(
													"<b style='color:red;font-size:15px;'>用户名或密码错误!</b>");
									changevarcode();
									isok = false;
								} else {
									$("#loginInfo").html("正在登录.....");
								}
							},
							error : function(data) {
								alert("登录出错！请联系管理员" + data);
								isok = false;
							}
						});
					}
				},
				error : function(data) {
					alert("登录出错！请联系管理员" + data);
					isok = false;
					return;
				}
			});
			
			if (isok) {
				$("#login1").submit();
			}
		}
		function changevarcode(){
			var src = "changevarcode.do?t="+new Date().getTime();
			$("#varcodeimg").attr("src",src);
		}
	</script>
	
	<footer style="text-align: center">
    <hr>
<p class="am-padding-left">© 2020 <a href="#">山西大学商务学院</a>. 作者:解子扬</p>
</footer>


	</body>
	</html>