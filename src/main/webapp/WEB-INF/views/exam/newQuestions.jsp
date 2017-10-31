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
	<link href="<c:url value="/resources/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css" />
</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>
    <div class="container-fluid">
    	<div class="row">
    		<div class="col-xs-6 col-xs-offset-4">
    			<img src="<c:url value="/resources/images/Exam3.png"/>" style="max-width: 50%;max-height: 50%;" alt=""/>
    		</div>
    	</div>
      	<div class="row">
      		<div class="col-xs-12">
      		  <div class="panel panel-primary" style="height: 70%">
	      		<div class="panel-heading">Add Questions</div>
	      			<div class="panel-body">
      		  <form id="questionForm" class="form-horizontal" method="post" action="addQuestions" enctype="multipart/form-data">
      						<div class="form-group required">
								<label class="control-label col-xs-3" for="questions">Import Questions</label>
								<div class="col-xs-6">
									<input type="hidden" name="examId" id="examId" value="${examId}"/>
									<input type="file" id="uploadQuestions" name="uploadQuestions" required="required"/>
								</div>
								<div class="col-xs-3">
								</div>
							</div>
							<div class="form-group">
								<div class="col-xs-3"></div>
								<div class="col-xs-3">
									<input type="submit" value="Upload Questions" class="btn btn-primary" id="uploadQuestions"/>
									<span id="createSlideMessage"></span>
								</div>
								<div class="col-xs-3">
									<a href="downloadQuestionsTemplate.html">Download Template</a>
								</div>
							</div>
					</form>
				</div>
      		  </div>
	 		</div>
    	</div>
    </div>
    <jsp:include page="../footer.jsp"></jsp:include>
	<script src="<c:url value="/resources/js/application/jquery.min.js"/>"></script>
	<script src="<c:url value="/resources/js/application/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/resources/js/application/dataTable.js"/>"></script>
	<script>
	$(document).ready(function(){
		$(".nav").find(".nav-active").removeClass("nav-active");
		$('#examHeader').addClass("nav-active");
	});
	</script>
	<script src="<c:url value="/resources/js/validation/main.js"/>"></script>
	
</body>
</html>