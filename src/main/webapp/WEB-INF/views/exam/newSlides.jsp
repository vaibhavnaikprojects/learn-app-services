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
    		<div class="col-xs-6 col-xs-offset-4" style="padding-left: 60">
    			<img src="<c:url value="/resources/images/Exam2.png"/>" style="max-width: 50%;max-height: 50%;" alt=""/>
    		</div>
    	</div>
      	<div class="row">
      		<div class="col-xs-6">
      		  <div class="panel panel-primary">
	      			<div class="panel-heading">Add Slides</div>
	      			<div class="panel-body">
      		  	<form id="slideForm" class="form-horizontal" method="post" action="addSlide" enctype="multipart/form-data">
      						<div class="form-group required">
								<label class="control-label col-xs-3" for="slideNo">Enter Slide No</label>
								<div class="col-xs-8">
									<input type="text" class="form-control input-sm"
										id="slideNo" name="slideNo" placeholder="Enter Slide Number" required="required"/>
								</div>
							</div>
							<div class="form-group required">
								<label class="control-label col-xs-3" for="slideDescription">Exam Description</label>
								<div class="col-xs-8">
									<textarea class="form-control input-sm" rows="15" id="slideDescription" name="slideDescription" placeholder="Enter Slide Description" required="required"></textarea>
								</div>
							</div>
							<div class="form-group required">
								<label class="control-label col-xs-3" for="slideImage">Slide Image</label>
								<div class="col-xs-8">
									<input type="file" id="slideImage" name="slideImage" required="required"/>
								</div>
							</div>
							<div class="form-group required">
								<label class="control-label col-xs-3" for="slideAudio">Slide Audio</label>
								<div class="col-xs-8">
									<input type="file" id="slideAudio" name="slideAudio" required="required"/>
									<input type="hidden" name="examId" id="examId" value="${examId}"/>
								</div>
							</div>
							<div class="form-group">
								<div class="col-xs-3"></div>
								<div class="col-xs-6">
									<input type="submit" value="Create Slide" class="btn btn-primary" id="createSlide"/>
									<span id="createSlideMessage"></span>
								</div>
								<div class="col-xs-3">
									<a href="newQuestions?examId=${examId}" class="btn btn-default" id="addQuestions">Add Questions</a>
								</div>
							</div>
					</form>
					</div>
      		  </div>
	 		</div>
	 		<div  class="col-xs-6">
	 			<div class="panel panel-primary" style="height: 77%">
	      			<div class="panel-heading">Image Previewer</div>
	      			<div class="panel-body">
	 					<img id="imagePreview" src="#" style=" max-width: 100%;max-height: 100%;" alt="" />
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
		var examId="2";
	});
	</script>
	<script src="<c:url value="/resources/js/validation/main.js"/>"></script>
	
</body>
</html>