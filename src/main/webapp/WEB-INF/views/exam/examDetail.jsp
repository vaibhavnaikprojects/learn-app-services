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
      		 
	      		<div class="panel panel-primary">
	      			<div class="panel-heading">Exam Details</div>
	      			<div class="panel-body">
	      				<div class="col-xs-9">
		      				<div class="row">
								<div class="col-xs-12"><p><b>Exam Name:</b> ${exam.examName}</p></div>
							</div>
							<div class="row">
								<div class="col-xs-12"><p><b>Exam Description:</b> ${exam.examDescription}</p></div>
							</div>
							<div class="row">
								<div class="col-xs-6"><p><b>Exam Min Marks:</b> ${exam.passingMarks}</p></div>
								<div class="col-xs-6"><p><b>Exam Max Marks:</b> ${exam.maxMarks}</p></div>
							</div>
						</div>
						<div class="col-xs-3">
						<img src="data:image/jpg;base64,${exam.examImage}" style="max-width: 100%;max-height: 100%;width: 100%" alt="Slide Image"/><br/>
						</div>
	      			</div>
	       		</div>
	       		</div>
	 		</div>
    	<div class="row">
      		<div class="col-xs-6">
      			<div class="panel panel-primary">
	      			<div class="panel-heading">Slide Details</div>
		      			<div class="panel-body">
		      				<div class="col-xs-9">
		      				<h4>Slides Present : <a href="getSlides?examId=${exam.examId}" data-toggle="tooltip" title="View Details">${slideCount}</a></h4>
		      				</div>
		      				<div class="col-xs-3">
		      						<a href="newSlides?examId=${exam.examId}" class="btn btn-primary">Add Slides</a>
		      				</div>
		      			</div>
	      		</div>
      		</div>
      		<div class="col-xs-6">
      			<div class="panel panel-primary">
	      			<div class="panel-heading">Questions Details</div>
		      			<div class="panel-body">
		      				<div class="col-xs-9">
		      				<h4>Questions Present : <a href="getQuestions?examId=${exam.examId}" data-toggle="tooltip" title="View Details">${questionCount}</a></h4>
		      				</div>
		      				<div class="col-xs-3">
		      						<a href="newQuestions?examId=${exam.examId}" class="btn btn-primary">Add Questions</a>
		      				</div>
		      			</div>
	      		</div>
      		</div>
      	</div>
      	<div class="row">
      	<div class="col-xs-12">
      		<div class="panel panel-default">
	      		<div class="panel-body">
			      	<div class="col-xs-2 col-xs-offset-5">
			      		<a href="deleteExam?examId=${exam.examId}" class="btn btn-danger btn-block">Delete Exam</a>
			      	</div>
		      	</div>
	      	</div>
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