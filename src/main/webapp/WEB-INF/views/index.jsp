<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="vanaik">
	<link href="<c:url value="/resources/css/application/bootstrap.min.css"/>" rel="stylesheet">
	<link href="<c:url value="/resources/css/application/main.css"/>" rel="stylesheet">
<title>LearnApp Admin Console</title>
</head>
<body>
		<div class="col-sm-4 col-md-4"></div>
		<div class="col-sm-4 col-md-4">
			<h1>LearnApp Admin Console</h1>
			<hr>
			<h4 class="message-error">${message}</h4>
			<form class="form-horizontal" role="form" action="login.html" name="login" method="post">
			<div class="form-group">
			      <label class="control-label col-sm-2" for="email">User Id:</label>
			      <div class="col-sm-8">
			        <input type="text" class="form-control" id="userId"name="userId" placeholder="Enter User ID">
			      </div>
			      <div id="userIdMessage" class="col-sm-2">
			      </div>
			 </div>
			 <div class="form-group">
			      <label class="control-label col-sm-2" for="email">Password:</label>
			      <div class="col-sm-8">
			        <input type="password" class="form-control" id="password" name="password"  placeholder="Enter Password">
			      </div>
			       <div id="passwordMessage" class="col-sm-2"></div>
			</div>
				<input type="submit" class="btn btn-primary " value="log in">
			</form>
		</div>
		<div class="col-sm-4 col-md-4"></div>
	<script src="<c:url value="/resources/js/application/jquery.min.js"/>"></script>
	<script src="<c:url value="/resources/js/application/bootstrap.min.js"/>"></script>
</body>
</html>
