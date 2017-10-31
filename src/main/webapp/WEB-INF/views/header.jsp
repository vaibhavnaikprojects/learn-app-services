<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    <nav class="navbar navbar-default header-color" role="navigation">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed nav-button" data-toggle="collapse" data-target="#navbar-header-app" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <span class="navbar-brand" style="color: white">LearnApp</span>
        </div>
        <div id="navbar-header-app" class="navbar-collapse collapse">
          <ul id="header-navbar" class="nav navbar-nav navbar-left header-color">
            <li id="homeHeader"><a href="home.html" style="text-decoration: none; color: white"><i class="glyphicon glyphicon-home"></i> Home</a></li>
            <li id="examHeader"><a href="exam.html" style="text-decoration: none; color: white"><i class="glyphicon glyphicon-home"></i> Exam</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#" style="text-decoration: none; color: white"><i class="glyphicon glyphicon-user"></i> ${user.userName}</a></li>
            <li><a href="logout.html" style="text-decoration: none; color: white"><i class="glyphicon glyphicon-home"></i> Logout</a></li>
          </ul>
        </div>
        </div>
    </nav>