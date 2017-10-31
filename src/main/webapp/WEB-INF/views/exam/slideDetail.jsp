<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="vanaik">
	<title>LearnApp Admin Console::EXAM</title>
	<link href="<c:url value="/resources/css/application/bootstrap.min.css"/>" rel="stylesheet">
	<link href="<c:url value="/resources/css/application/dataTable.css"/>" rel="stylesheet">
	<link href="<c:url value="/resources/css/learnapp/main.css"/>" rel="stylesheet">
</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>
    <div class="container-fluid">
      	<div class="row">
      		<div class="col-xs-12">
      		<c:forEach var="tutorial" items="${exam.tutorialBeans}">
	      		<c:if test="${tutorial.slideNo eq 4}">
	      		<div class="row">
	      		</c:if>
	      			<div class="col-xs-3">
		      		  	<div class="panel panel-primary" style="height: 50%;">
			      			<div class="panel-heading">${tutorial.slideNo}</div>
			      			<div class="panel-body">
			      				<img src="data:image/jpg;base64,${tutorial.image}" style="max-width: 100%;max-height: 100%;height: 40%;width: 100%" alt="Slide Image"/><br/>
			      				<audio src="exams/getAudio?examId=${exam.examId}&slideNo=${tutorial.slideNo}" type="audio/mpeg" id="audio${tutorial.slideNo}"></audio>
			      				<a href="javascript:void(0)" onclick="aud_play_pause(${tutorial.slideNo})" class="btn btn-primary" style="border-radius: 100%;position: absolute; top: 48%;left: 75%"><i id="stateicon${tutorial.slideNo}" class="glyphicon glyphicon-play"></i></a>
			 					<p style="text-align: justify;padding:10px; font-size: 12px;overflow-y: auto; height: 40%">${tutorial.slideDescription}</p>
							</div>
						</div>
					</div>
				<c:if test="${tutorial.slideNo eq 4}">
				</div>
				</c:if>
			</c:forEach>
	       		</div>
    	</div>
    	<div class="row">
    		<div class="col-xs-2 col-xs-offset-5">
    			<a href="getExam?examId=${exam.examId}" class="btn btn-block btn-primary">Return</a>
    		</div>
    	</div>
    </div>
    <jsp:include page="../footer.jsp"></jsp:include>
	<script src="<c:url value="/resources/js/application/jquery.min.js"/>"></script>
	<script src="<c:url value="/resources/js/application/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/resources/js/application/dataTable.js"/>"></script>
	<script src="<c:url value="/resources/js/validation/main.js"/>"></script>
	<script>
	$(document).ready(function(){
		$(".nav").find(".nav-active").removeClass("nav-active");
		$('#examHeader').addClass("nav-active");
	});
	</script>
</body>
</html>