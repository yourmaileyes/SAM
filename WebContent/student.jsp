<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css"
          href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css"
          href="bootstrap-3.3.7-dist/css/bootstrapValidator.css">
    <script type="text/javascript" src="bootstrap-3.3.7-dist/js/jquery-3.2.1.min.js"></script>
    <script type="text/javascript"
            src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <title>Insert title here</title>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-2 column">
        </div>
        <div class="col-md-6 column">
            <form role="form"  action="updateStudent.do" method="post" >
                <input type="hidden" name="id" value="${student.id}"/>
                <div class="form-group">
                    <label for="exampleInputEmail1">账户</label><input type="text" name="account" class="form-control" id="exampleInputEmail1" value="${student.account}" />
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail11">密码</label><input name="password" class="form-control" id="exampleInputEmail11" value="${student.password}"/>
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail12">院系</label><input name="department" class="form-control" id="exampleInputEmail12" value="${student.department}"/>
                    <c:if test="${student!=null}">
                    <p class="help-block">
                        用户创建时间 <fmt:formatDate value="${student.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>.
                    </p>
                    </c:if>
                </div>
                <button type="submit" class="btn btn-default">提交</button>
            </form>
        </div>
        <div class="col-md-4 column">
        </div>
    </div>
</div>
</body>
</html>