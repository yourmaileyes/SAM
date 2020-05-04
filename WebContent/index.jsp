<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<link href="favicon.ico" rel="icon" type="image/x-icon" />
<link href="favicon.ico" rel="shortcut icon" type="image/x-icon" />

<link rel="stylesheet" type="text/css" href="css/base.css">
<link rel="stylesheet" type="text/css" href="css/home.css">
    <link rel="stylesheet" href="css/amazeui.min.css">
    <link rel="stylesheet" href="css/course.css">
    <link rel="stylesheet" href="css/admin.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/course.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>大学艺术活动网站</title>
<style type="text/css">
body {
	background-color: #f5f5f5;
	padding-left: 0px;
}

#contents {
	background-color: #FFF;
	padding-left: 20px;
}
</style>
</head>
<%@include file="head.jsp"%>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<div class="carousel slide" id="carousel-624135">
						<ol class="carousel-indicators">
							<li class="active" data-slide-to="0"
								data-target="#carousel-624135"></li>
							<li data-slide-to="1" data-target="#carousel-624135"></li>
							<li data-slide-to="2" data-target="#carousel-624135"></li>
						</ol>
						<div class="carousel-inner">
							<div class="item active">
								<img alt="" src="images/main1.jpg" width="100%"
									height="200px" />
								<div class="carousel-caption">
									<h4>
										 学生大合唱
									</h4>
									<p>
										山西大学商务学院“庆祝建国70周年暨2019年迎新生文艺晚会”主题晚会顺利举行
									</p>
								</div>
							</div>
							<div class="item">
								<img alt="" src="images/main2.jpg" width="100%"
									height="300px" />
								<div class="carousel-caption">
									<h4>
										获奖演员上台领奖
									</h4>
									<p>
										山西大学商务学院第十五届校园文化艺术节“我的中国梦”主题晚会顺利举行
									</p>
								</div>
							</div>
							<div class="item">
								<img alt="" src="images/main3.jpg" width="100%"
									height="300px" />
								<div class="carousel-caption">
									<h4>
										演员们正在热情演出
									</h4>
									<p>
										山西大学商务学院第十五届校园文化艺术节“我的中国梦”主题晚会顺利举行
									</p>
								</div>
							</div>
						</div>
						<a class="left carousel-control" href="#carousel-624135"
							data-slide="prev"><span
							class="glyphicon glyphicon-chevron-left"></span></a> <a
							class="right carousel-control" href="#carousel-624135"
							data-slide="next"><span
							class="glyphicon glyphicon-chevron-right"></span></a>
					</div>
                    <div class="uc-course-list_content" >

                        <div class="container-fluid" style="padding-left: 0px">
                            <div class="j-course-list"><div class="uc-course-list g-flow">

                                <ul class="uc-course-list_ul" style="padding:15px">
                                    <!--Regular list-->
                                    <c:forEach var="course" items="${activities}" varStatus="status">

                                        <li class="uc-course-list_itm f-ib">
                                            <!--Regular if23-->
                                            <div class="uc-coursecard uc-ykt-coursecard f-fl">
                                                <a target="_blank" class="j-href" href="activity.do?id=${course.id}">
                                                    <div class="uc-ykt-coursecard-wrap f-cb f-pr">
                                                        <div class="uc-ykt-coursecard-wrap_box">
                                                            <div class="uc-ykt-coursecard-wrap_picbox f-pr">
																<c:if test="${course.imgurl eq ''}">
																	<img width="450" height="250"
																		 src="<c:url value="images/activity.jpg?imageView&amp;thumbnail=450y250&amp;quality=100"/>">
																</c:if>
																<c:if test="${course.imgurl ne ''}">
																	<img width="450" height="250"
																		 src="<c:url value="images/${course.imgurl}?imageView&amp;thumbnail=450y250&amp;quality=100"/>">
																</c:if>
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
                </div>
            </div>
        </div>
    </div>
</div>
</div>
</div>
<footer style="text-align: center">
<hr>
<p class="am-padding-left">© 2020 <a href="#">山西大学商务学院</a>. 作者:解子扬
</p>
</br>
</br>
</br>
</footer>

</body>
</html>