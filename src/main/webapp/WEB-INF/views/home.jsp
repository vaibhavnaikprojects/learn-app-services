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
	<jsp:include page="header.jsp"></jsp:include>
    <div class="container-fluid">
      	<div class="row">
      		<div class="col-xs-12">
      		<div class="x_panel">
      				<table id="examList" class="table-striped datatable">
					<thead>
						<tr style="color: white;">
							<th>Exam Name</th>
							<th>Exam Description</th>
							<th>Exam Min Marks</th>
							<th>Exam Total marks</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="exam" items="${examList}">
							<tr>
								<td><a href="getExam?examId=${exam.examId}"><c:out value="${exam.examName}" /></a></td>
								<td><c:out value="${exam.examDescription}" /></td>
								<td><c:out value="${exam.passingMarks}" /></td>
								<td><c:out value="${exam.maxMarks}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
      			</div>
      		</div>
	 	</div>
    </div>
    <jsp:include page="footer.jsp"></jsp:include>
	<script src="<c:url value="/resources/js/application/jquery.min.js"/>"></script>
	<script src="<c:url value="/resources/js/application/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/resources/js/application/dataTable.js"/>"></script>
	<script src="<c:url value="/resources/js/validation/main.js"/>"></script>
	<script>
	$(document).ready(function(){
		$(".nav").find(".nav-active").removeClass("nav-active");
		$('#homeHeader').addClass("nav-active");
	});
	</script>
</body>
</html>