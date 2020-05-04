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
	<script src="js/moment-with-locales.min.js"></script>
	<script src="js/bootstrap-datetimepicker.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-2 column">
		</div>
		<div class="col-md-6 column">
			<img src="images/${activity.imgurl}" alt="活动宣传图片" style="height:300px;width:300px">
			<form role="form"  action="updateActivity.do" method="post" enctype="multipart/form-data">
				<input type="hidden" name="id" value="${activity.id}"/>
				<div class="form-group">
					<label for="exampleInputEmail1">活动标题</label><input type="text" name="name" class="form-control" id="exampleInputEmail1" value="${activity.name}" />
				</div>
				<div class="form-group">
					<label for="exampleInputEmail11">活动简介</label><textarea name="context" class="form-control" id="exampleInputEmail11">${activity.context}</textarea>
				</div>
				<div class="form-group">
					<label for="exampleInputEmail11">活动结果</label><textarea name="result" class="form-control" id="exampleInputEmail11">${activity.result}</textarea>
				</div>
					<div class="form-group">
						<label>选择活动开始时间：</label>
						<!--指定 date标记-->
						<div class='input-group date' id='datetimepicker1'>
							<input type='text' name="starttime" class="form-control" value="<fmt:formatDate value="${activity.starttime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/>
							<span class="input-group-addon">
                    <span class="glyphicon glyphicon-calendar"></span>
                </span>
						</div>
					</div>
				<div class="form-group">
					<label>选择活动结束时间：</label>
					<!--指定 date标记-->
					<div class='input-group date' id='datetimepicker2'>
						<input type='text' name="endtime" class="form-control" value="<fmt:formatDate value="${activity.endtime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/>
						<span class="input-group-addon">
                    <span class="glyphicon glyphicon-calendar"></span>
                </span>
					</div>
				</div>
				<div class="form-group">
					<label for="exampleInputFile">宣传图片</label><input type="file" name="file" id="exampleInputFile" />
					<p class="help-block">
						请上传少于10MB的图片.
					</p>
				</div>
				<button type="submit" class="btn btn-default">提交</button>
			</form>
		</div>
		<div class="col-md-4 column">
		</div>
	</div>
</div>
<script>
	$(function () {
		$('#datetimepicker1').datetimepicker({
			format: 'YYYY-MM-DD HH:mm:ss',
			locale: moment.locale('zh-cn')
		});
		$('#datetimepicker2').datetimepicker({
			format: 'YYYY-MM-DD HH:mm:ss',
			locale: moment.locale('zh-cn')
		});
	});
</script>
</body>
</html>