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
			<table class="table">
				<thead>
				<tr>
					<th>
						学生编号
					</th>
					<th>
						学生账户
					</th>
					<th>
						院系
					</th>
					<th>
						创建时间
					</th>
					<th>
						操作
					</th>
				</tr>
				</thead>
				<tbody>
				<c:forEach items="${AS }" var="test">
					<tr class="success">
						<td>
								${test.id }
						</td>
						<td>
								${test.account }
						</td>
						<td>
								${test.department }
						</td>
						<td>
							<fmt:formatDate value="${test.createtime }" pattern="yyyy-MM-dd HH:mm:ss"/>
						</td>
						<td>
							<button onclick="deleteexam('${test.id}','${test.account}','${ASID}')">删除</button>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
</body>
<script type="text/javascript">
	function deleteexam(id,account,activityId){
		var r=confirm("确认要取消学生："+account+"报名?");
		if (r==true){
			$.ajax({
				type : "post",
				url : "deSign.do",
				data : {
					"studentId" : id,
					"activityId" : activityId
				},
				async : true,
				dataType : 'text',
				success : function(data) {
					alert(data);
					location.reload(true);
				},
				error : function(data) {
					alert("出错！请联系管理员" + data);
					isok = false;
				}
			});
		}
	}
</script>
</html>