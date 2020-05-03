<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的报名</title>
	<link rel="stylesheet" href="css/amazeui.min.css">
	<link rel="stylesheet" href="css/course.css">
	<script src="js/jquery-2.1.4.min.js"></script>
	<script src="js/amazeui.min.js"></script>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="css/course.css">
</head>
<body>
<%@include file="head.jsp"%>
<div class="container">
	<div class="uc-course-list_content" >

		<div class="container-fluid" style="padding-left: 0px">
			<div class="j-course-list"><div class="uc-course-list g-flow">

				<ul class="uc-course-list_ul" style="padding:15px">
					<!--Regular list-->
					<c:if test="${activities==null}">暂无报名</c:if>
					<c:forEach var="course" items="${activities}" varStatus="status">

						<li class="uc-course-list_itm f-ib">
							<!--Regular if23-->
							<div class="uc-coursecard uc-ykt-coursecard f-fl">
								<a target="_blank" class="j-href" href="activity.do?id=${course.id}">
									<div class="uc-ykt-coursecard-wrap f-cb f-pr">
										<div class="uc-ykt-coursecard-wrap_box">
											<div class="uc-ykt-coursecard-wrap_picbox f-pr">
												<img class="imgPic j-img" src="<c:url value="images/${course.imgurl}?imageView&amp;thumbnail=223y124&amp;quality=100"/>" data-src="" alt="课程图片" >
												<div class="m-showLectorTag f-pa" style="display: none;">老师参与</div>
											</div>
											<div class="uc-ykt-coursecard-wrap_tit">
												<h3 class="">${course.name}</h3>
											</div>
											<div class="uc-ykt-coursecard-wrap_orgName f-fs0 f-thide">
													${course.context}</div>
											<div class="uc-ykt-coursecard-wrap_scorewrap f-thide f-cb f-pa">
												<div class="m-scorecnt f-fl f-cb">
													<div class="uc-starrating">
															${course.number}人报名
													</div>
												</div>
												<div class="m-hot f-fl">
													<!--Regular if24-->
													活动时间<fmt:formatDate value="${course.starttime}" pattern="yyyy-MM-dd"/>
													至<fmt:formatDate value="${course.endtime}" pattern="yyyy-MM-dd"/>

												</div>
											</div>
											<div class="uc-ykt-coursecard-wrap_price f-pa">
												<!--Regular if25-->
												<span class="u-free">

															<br><c:if test="${course.status==4 }">已结束</c:if>
															</span>

											</div>
											<!--Regular if26-->
										</div>
									</div>
								</a>
							</div>

						</li>
					</c:forEach>
				</ul>
				<!--Regular if22-->
			</div>
			</div>
		</div>
	</div>
<footer style="text-align: center">
<hr>
<p class="am-padding-left">
	© 2020 <a href="#">山西大学商务学院</a>. 作者:解子扬
</p>
</br>
</br>
</br>
</footer>
</body>
</html>