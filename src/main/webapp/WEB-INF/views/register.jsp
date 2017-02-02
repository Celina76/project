<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Registration</title>
<style>
body {
	width: 100%;
	height: 400px;
	background-image: url("resources/images/a.jpg");
	background-size: cover;
}
</style>
</head>
<body>
 	<%@ include file="header.jsp"%>  

	<div class="container">
		<form:form class="form-horizontal" modelAttribute="user">
<%-- 	<a href="${flowExecutionUrl}&_eventId_home">Home</a> --%>
			<div class="form-group">
				<form:label class="col-md-4 control-label" for="textinput" path="firstname">First
					Name</form:label>
				<div class="col-md-4">
					<form:input type="text" name="firstname"
						placeholder="Insert your First Name" class="form-control input-md" required="true"
						path="firstname"/> <span class="help-block">
					</span>
					<!-- to display validation messages -->
					<c:forEach
						items="${flowRequestContext.messageContext.getMessagesBySource('firstname')}"
						var="err">
						<div>
							<span>${err.text}</span>
						</div>
					</c:forEach>
					
					<br />

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<form:label class="col-md-4 control-label" for="textinput" path="lastname">Last
					Name</form:label>
				<div class="col-md-4">
					<form:input type="text" name="lastname"
						placeholder="Insert your Last Name" class="form-control input-md"
						path="lastname"/> <span class="help-block"> </span>
					<!-- to display validation messages -->
					<c:forEach
						items="${flowRequestContext.messageContext.getMessagesBySource('lastname')}"
						var="err">
						<div>
							<span>${err.text}</span>
						</div>
					</c:forEach>
					<br />

				</div>

			</div>
			<!-- Text input-->
			<div class="form-group">
				<form:label class="col-md-4 control-label" for="textinput" path="username">UserName</form:label>
				<div class="col-md-4">
					<form:input type="text" name="username" placeholder="Insert  your UserName"
						class="form-control input-md" path="username"/> <span
						class="help-block"> </span>
					<!-- to display validation messages -->
					<c:forEach
						items="${flowRequestContext.messageContext.getMessagesBySource('username')}"
						var="err">
						<div>
							<span>${err.text}</span>
						</div>
					</c:forEach>
					<br />

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<form:label class="col-md-4 control-label" for="textinput" path="email">Email</form:label>
				<div class="col-md-4">
					<form:input type="email" name="email" placeholder="Insert your Email"
						class="form-control input-md" path="email"/> <span
						class="help-block"> </span>
					<!-- to display validation messages -->
					<c:forEach
						items="${flowRequestContext.messageContext.getMessagesBySource('email')}"
						var="err">
						<div>
							<span>${err.text}</span>
						</div>
					</c:forEach>
					<br />

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<form:label class="col-md-4 control-label" for="textinput" path="password">Password</form:label>
				<div class="col-md-4">
					<form:input type="password" name="password"
						placeholder="Insert your Password" class="form-control input-md"
						path="password"/> <span class="help-block"> </span>
					<!-- to display validation messages -->
					<c:forEach
						items="${flowRequestContext.messageContext.getMessagesBySource('password')}"
						var="err">
						<div>
							<span>${err.text}</span>
						</div>
					</c:forEach>
					<br />

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<form:label class="col-md-4 control-label" for="textinput" path="password">Confirm
					Password</form:label>
				<div class="col-md-4">
					<form:input type="password" name="confirmpwd"
						placeholder="Confirm your Password" class="form-control input-md"
						path="confirmpwd"/> <span class="help-block">
					</span>
					<!-- to display validation messages -->
					<c:forEach
						items="${flowRequestContext.messageContext.getMessagesBySource('confirmpwd')}"
						var="err">
						<div>
							<span>${err.text}</span>
						</div>
					</c:forEach>
					<br />

				</div>
			</div>

			<!-- Button -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="singlebutton"> </label>
				<div class="col-md-4">
					<!-- 					<button class="btn btn-success" type="submit" value="submit">Register</button> -->
					<input name="_eventId_submit" type="submit" value="Submit" />Register<br>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</div>
			</div>
		</form:form>
	</div>

	<%@ include file="footer.jsp"%>  
</body>
</html>