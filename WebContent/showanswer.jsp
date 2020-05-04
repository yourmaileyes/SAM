<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
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
		<div class="col-md-12 column">
			<a href="uA.do">点击发起活动</a>
			<table class="table">
				<thead>
				<tr>
					<th>
						活动编号
					</th>
					<th>
						活动名字
					</th>
					<th>
						活动图片
					</th>
					<th>
						活动申请时间
					</th>
					<th>
						状态
					</th>
					<th>
						操作
					</th>
				</tr>
				</thead>
				<tbody>
				<c:forEach items="${myActivity }" var="exam">
					<tr class="success">
						<td>
								${exam.id }
						</td>
						<td>
								${exam.name }
						</td>
						<td>
							<img alt="" src="images/${exam.imgurl}" style="height:150px;width:150px"/>
						</td>
						<td>
							<fmt:formatDate value="${exam.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</td>
						<td>
							<c:if test="${exam.status == 0}">待审核</c:if>
							<c:if test="${exam.status == 1}">审核已通过</c:if>
							<c:if test="${exam.status == 3}">活动已结束</c:if>
						</td>
						<td>
							<c:if test="${exam.status != 0}">
								<button onclick="window.location.href='getAS.do?id=${exam.id}'">查看报名表</button>
							</c:if>
							<button onclick="window.location.href='updateA.do?id=${exam.id}'">编辑</button>
							<button onclick="deleteexam(id='${exam.id}')">删除</button>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
</body>
</html>