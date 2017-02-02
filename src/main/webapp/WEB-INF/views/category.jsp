
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="header.jsp"%>
	<div class="container">
		<h2>Category Details</h2>

		<div>
			<form:form action="category" method="POST" modelAttribute="category"
				enctype="multipart/form-data">
				<div class="form-group">
					<form:label class="control-label col-sm-2" path="category_name">Enter Category Name:</form:label>
					<div class="col-sm-10">
						<form:input type="text" path="category_name" class="form-control"
							required="true" placeholder="Enter Category Name" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<input type="submit" class="btn btn-default" name="action"
							value="Add" />
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>