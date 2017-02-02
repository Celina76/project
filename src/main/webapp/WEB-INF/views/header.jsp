<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
		<div class="page-header">

			<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">MusicWorld</a>
				</div>
				<ul class="nav navbar-nav">
					<li class="active"><a href="index">Home</a></li>
					<li><a href="display">products</a>
				</ul>

				<!-- 		</ul> -->
				<!-- 				<div class="col-sm-5"> -->
				<!-- 			<input type="search" class="form-control" name="search" -->
				<!-- 				placeholder="Search for Product"> -->

				<!-- 		</div> -->
								<sec:authorize access="hasRole('ROLE_ADMIN')"> 
						<ul class="nav navbar-nav"> 
								<li class="dropdown"><a class="dropdown-toggle" 
									data-toggle="dropdown" href="#">Admin <span class="caret"></span></a> 
									<ul class="dropdown-menu"> 
										<li><a href="product">Add Product</a></li> 
										<li><a href="category">Add Category</a></li> 

									</ul></li> 
				 			</ul></sec:authorize> 
				<ul class="nav navbar-nav navbar-right">
					<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')">
						<c:if test="${pageContext.request.userPrincipal.name!=null }">
							<li><h4>welcome
									${pageContext.request.userPrincipal.name }</h4></li>
						</c:if>
					</sec:authorize>
					<c:if test="${pageContext.request.userPrincipal.name==null }">
						<li><a href="login"><span
								class="glyphicon glyphicon-user"></span>Login</a></li>
					</c:if>
					<c:if test="${pageContext.request.userPrincipal.name==null }">
						<li><a href="register.obj"><span
								class="glyphicon glyphicon-log-in"></span>Register</a></li>
					</c:if>
					<li><a href="cart"/>cart<span
								class="glyphicon glyphicon-shopping-cart"></span></a></li>
<%-- 					<sec:authorize access="hasRole('ROLE_ADMIN')"> --%>
<!-- 						<li><a href="product">Add Product</a></li> -->
<!-- 						<li><a href="category">Add Category</a></li> -->
<%-- 					</sec:authorize> --%>

					<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')">
						<li><a href="logout"><span
								class="glyphicon glyphicon-log-out"></span>logout</a></li>
					</sec:authorize>
				</ul>
			</div>
			</nav>
			
	<div class="container">	
	<div class="dropdown">
				<button class="btn btn-primary dropdown-toggle" type="button"
					data-toggle="dropdown">
					category <span class="caret"></span>
				</button>
				<ul class="dropdown-menu">
					<c:forEach items="${categoryList}" var="a"> 
				
				<li><a href="allproduct?pdt=${a.category_name}">${a.category_name}</a></li>
				</c:forEach> 
					</ul>
			</div>
			</div>
	
		</div>
		</div>
		</body>
		</html>
