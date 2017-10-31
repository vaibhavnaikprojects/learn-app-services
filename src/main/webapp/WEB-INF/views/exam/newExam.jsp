<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="vanaik">
	<title>LearnApp Admin Console::HOME</title>
	<link href="<c:url value="/resources/css/application/bootstrap.min.css"/>" rel="stylesheet">
	<link href="<c:url value="/resources/css/application/dataTable.css"/>" rel="stylesheet">
	<link href="<c:url value="/resources/css/learnapp/main.css"/>" rel="stylesheet">
</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>
    <div class="container-fluid">
    	<div class="row">
    		<div class="col-xs-6 col-xs-offset-4" style="padding-left: 60">
    			<img src="<c:url value="/resources/images/Exam1.png"/>" style="max-width: 50%;max-height: 50%;" alt=""/>
    		</div>
    	</div>
      	<div class="row">
      		<div class="col-xs-12">
	      		<div class="panel panel-default">
	      			<div class="panel-heading">Add Exam</div>
      				<div class="panel-body">
      					<form id="addExam" method="post" class="form-horizontal" action="addExam" enctype="multipart/form-data">
      						<div class="form-group required">
								<label class="control-label col-xs-3" for="examName">Exam Name</label>
								<div class="col-xs-6">
									<input type="text" class="form-control input-sm"
										id="examName" name="examName" placeholder="Enter Exam Name" required="required"/>
								</div>
								<div class="col-xs-3">
								</div>
							</div>
							<div class="form-group required">
								<label class="control-label col-xs-3" for="examDescription">Exam Description</label>
								<div class="col-xs-6">
									<textarea rows="3" class="form-control input-sm" id="examDescription" name="examDescription" placeholder="Enter Exam Description" required="required"></textarea>
								</div>
								<div class="col-xs-3">
								</div>
							</div>
							<div class="form-group required">
								<label class="control-label col-xs-3" for="passingMarks">Exam Min Marks</label>
								<div class="col-xs-6">
									<input type="number" class="form-control input-sm" id="passingMarks" name="passingMarks" placeholder="Enter Minimum Marks" required="required"/>
								</div>
								<div class="col-xs-3">
								</div>
							</div>
							<div class="form-group required">
								<label class="control-label col-xs-3" for="examDescription">Exam max Marks</label>
								<div class="col-xs-6">
									<input type="number" class="form-control input-sm" id="maxMarks" name="maxMarks" placeholder="Enter maximum Marks" required="required"/>
								</div>
								<div class="col-xs-3">
								</div>
							</div>
							<div class="form-group required">
								<label class="control-label col-xs-3" for="examDescription">Exam Image</label>
								<div class="col-xs-6">
									<input type="file" id="image" name="image" required="required"/>
								</div>
								<div class="col-xs-3">
								</div>
							</div>
							<div class="row">
								<div class="col-xs-2 col-xs-offset-7">
									<input type="submit" value="Submit" class="btn btn-primary btn-block" id="createExam"/>
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
	<script src="<c:url value="/resources/js/validation/main.js"/>"></script>
	<script>
	$(document).ready(function(){
		$(".nav").find(".nav-active").removeClass("nav-active");
		$('#examHeader').addClass("nav-active");
	});
	</script>
</body>
</html>