<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
<title>welcome</title>
 <style>
 body
 {
 width: 100%;
	height: 400px;
	background-image: url("resources/images/6.jpg");
/* 	background-size: cover; */
	}
	

  
  </style>
 <%@ include file="header.jsp" %>
<body >

 
<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>
<div class="container">

<form:form name="login" action="${pageContext.request.contextPath}/login" modelAttribute="UserInfo" method="POST">
<div class="form-group">
<label for="jusername">UserName:</label>
<input type="text" class="form-control" name="username" placeholder="Enter username">

</div>

<div class="form-group">
<label for="jpassword">PassWord:</label>
<input type="password" class="form-control" name="password" placeholder="Enter Password">

</div>

<div class="checkbox">
<label><input type="checkbox">Remeber Me</label>

</div>
<button type="submit" class="btn btn-default">Submit</button>

 <input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />

</form:form>
</div>

<%@ include file="footer.jsp" %>

		</body>
