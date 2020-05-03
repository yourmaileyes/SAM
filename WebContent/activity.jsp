<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<meta content="text/html; charset=UTF-8">

<link rel="stylesheet" href="css/amazeui.min.css">
<link rel="stylesheet" href="css/course.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/loginandregist.js"></script>
<script src="js/jquery-2.1.4.min.js"></script>
<script src="js/amazeui.min.js"></script>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery.min.js"></script>
<script src="js/loginkuang.js"></script>
<script src="js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/course.css">
<title>活动详情</title>
<!--[if lt IE 9]>  
<script src="js/html5shiv.js"></script>  
<script src="js/respond.min.js"></script>  
<![endif]-->
<style>
body {
	padding-top: 50px;
	padding-bottom: 40px;
	color: #5a5a5a;
}
</style>

</head>

<body>
<%@include file="head.jsp"%>
	<div class="g-flow f-cb">


		<div class="f-bg courseheadbox" id="j-coursehead" style="padding:10px">

			<div class="u-courseHead" id="auto-id-1509947716498">

				<div class="ov f-pr j-ch" style="padding-top: 0px; top: 10px;">


					<div class="g-sd1 left j-chimg">
						<img width="450" height="250"
							src="<c:url value="images/${activity.imgurl}?imageView&amp;thumbnail=450y250&amp;quality=100"/>">
					</div>

					<div class="g-mn1">

						<div class="g-mn1c right j-right f-pr">
							<div class="ctarea f-fl j-cht">
								<div class="u-coursetitle f-fl" id="auto-id-1509947716616">
									<h2 class="f-thide">
										<span class="u-coursetitle_title" title="">${activity.name}</span>
									</h2>

									<div class="f-cb margin-top-15">
										<c:if test="${activity.status==1 }">活动开始时间<fmt:formatDate value="${activity.starttime}" pattern="yyyy-MM-dd HH:mm:ss"/></c:if>
										<c:if test="${activity.status!=1 }">活动结束时间<fmt:formatDate value="${activity.endtime}" pattern="yyyy-MM-dd HH:mm:ss"/></c:if>




										<div class="f-fl" style="margin-right: 3px;">
											<a href="#" target="_blank" class="j-userNode"
												data-id="837467" data-type="10" id="auto-id-1509947716617">${activity.context}</a>
										</div>
										<c:if test="${activity.status==4 }">
										<div class="f-fl" style="margin-right: 3px;">
											<a href="#" target="_blank" class="j-userNode"
											   data-id="837468" data-type="10" id="auto-id-1509947716618">${activity.result}</a>
										</div>
										</c:if>


									</div>

								</div>
							</div>
							<div>

								<div class="btnarea f-pa j-chbtnarea">

									<c:if test="${isSelect == false || isSelect==null}">
										<a class="learnbtn f-db f-cb j-joinBtn"> <span>立即参加</span></a>
									</c:if>
									<c:if test="${isSelect == true }">
										<a class="learnbtn f-db f-cb j-joinBtn"><span>取消报名</span></a>
									</c:if>
								</div>
							</div>
						</div>
					</div>
				</div>


			</div>
			<!-- 评论区 -->
			<div
					style="position: relative; border: 2px solid; border-radius: 5px; margin: 20px; width: 92%; width: 100%; padding:10px;">
				<!-- 输入区 -->
				<c:if test="${isSelect == true }">
				<div
						style="background-color:; position: relative; width: 975px; padding: 10px; margin-bottom: 30px; border-bottom-style: dotted;">
					<form action="subreview.do" method="post">
						<input type="hidden" name="activityid" value="${activity.id}">
						<div
								style="position: relative; height: 150px; width: 200px; padding: 20px;">
							感觉活动怎么样？<br> <input type="radio" name="lable" value="1">一般<br>
							<input type="radio" name="lable" value="2">还行<br> <input
								type="radio" name="lable" value="3">不错<br> <input
								type="radio" name="lable" value="4">非常好<br>
						</div>
						<div
								style="position: absolute; left: 250px; top: 10px; height: 150px; width: 500px;">
					<textarea name="context" style="width: 100%; height: 100%;"
							  placeholder="输入你想说的话"></textarea>
						</div>
						<div
								style="position: absolute; left: 750px; top: 10px; height: 150px; width: 100px;">
							<input type="submit" value="提交"
								   style="position: relative; left: 20px; top: 100px; height: 30px; width: 90px; border: 2px solid; border-radius: 5px;">
						</div>
					</form>
				</div>
				</c:if>
				<!-- 展示评论区 -->
				<c:if test="${comments == null}">
					暂时还没有评论。。。
				</c:if>
				<c:forEach var="review" items="${comments}" varStatus="status">
					<div
							style="position: relative; width: 955px; border: 2px solid; border-radius: 5px; margin: 10px;">
						<div
								style="background-color:; position: relative; width: 200px; height: 100px; padding-left: 20px; padding-top: 10px;">

							用户：${review.username}<br>
							<c:if test="${review.lable != null }">
									觉得活动:${review.lable}
							</c:if>
						</div>
						<div
								style="position: absolute; left: 210px; top: 10px; height: 80px; width: 640px;">

								${review.context}</div>
						<div
								style="position: absolute; left: 850px; top: 5px; height: 80px; width: 100px;">
							发表于：<br><fmt:formatDate value="${review.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></div>
					</div>
				</c:forEach>
			</div>
		</div>



	</div>
	<script>
		$(document)
				.ready(
						function() {
							$(".learnbtn")
									.click(
											function() {
												if (!"${loginUser}") {
													window.location = "${pageContext.request.contextPath }/login.jsp";
												} else {
													if ("${isSelect}" == "true") {
														deleteCourse();

													} else {
														insertCourse();
														//location.reload() ;
													}
												}

											});
						});

		function insertCourse() {

			$.ajax({
				type : "post",
				url : "insertSign.do",
				data : {
					"avtivityid" : "${avtivity.id}",
					"userid" : "${loginUser.id}"
				},
				async : false,
				method : 'post',
				dataType : "text",
				success : function(data) {
					alert(data);
					/* alert(password==data); */
					location.reload(true);

				},
				error : function(data) {
					//alert("进入了error方法");
					location.reload(true);
				}
			});
			//location.reload() ;
		}
		function deleteCourse() {

			$.ajax({
				type : "post",
				url : "deleteSign.do",
				data : {
					"avtivityid" : "${avtivity.id}",
					"userid" : "${loginUser.id}"
				},
				async : true,
				success : function(data) {
					/* alert(password==data); */
					if (data == "true") {

						location.reload(true);
					} else {
						$(".learnbtn").focus();
						return;
					}
					/* alert(data); */
				},
				error : function(data) {
					//alert("进入了error方法");
					location.reload(true);
				}
			});
		}
	</script>
	<footer style="text-align: center">
	<hr>
	<p class="am-padding-left">
		© 2020 <a href="#">山西大学商务学院</a>. 作者:解子扬
	</p>
	</footer>
</body>
</html>
