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
	<jsp:include page="examModal.jsp"></jsp:include>
    <div class="container-fluid">
      	<div class="row">
      		<div class="col-xs-12">
      		  <div class="x_panel">
	      			<table id="questionList" class="table-striped datatable">
					<thead>
						<tr style="color: white;">
							<th>Question</th>
							<th>Option 1</th>
							<th>Option 2</th>
							<th>Option 3</th>
							<th>Option 4</th>
							<th>Correct Answer</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="question" items="${exam.questions}">
							<tr id="${question.questionId}">
								<td><a href="#" data-target="#questionModal" data-toggle="modal" data-keyboard="false" data-backdrop="static"><c:out value="${question.question}" /></a></td>
								<td><c:out value="${question.option1}" /></td>
								<td><c:out value="${question.option2}" /></td>
								<td><c:out value="${question.option3}" /></td>
								<td><c:out value="${question.option4}" /></td>
								<td><c:out value="${question.correctAnswer}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
	       		</div>
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