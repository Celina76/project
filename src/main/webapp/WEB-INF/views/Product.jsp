<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- <meta name="viewport" content="width=device-width, initial-scale=1"> -->
<!-- <link rel="stylesheet" -->
<!-- 	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> -->
<!-- <script -->
<!-- 	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script> -->
<!-- <script -->
<!-- 	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->

<title>Add Products</title>
</head>
<body>
	<%@ include file="header.jsp"%>

	<div class="container">
		<form:form class="form-horizontal" action="productadd" method="POST"
			modelAttribute="product" enctype="multipart/form-data">

			<div class="form-group">
				<label class="col-md-4 control-label" for="product_name">Product
					Name</label>
				<div class="col-md-4">
					<form:input type="text" placeholder="Insert Product Name"
						class="form-control input-md" required="true" path="product_name" />
					<span class="help-block"> </span>
					<form:errors path="product_name" cssClass="error" />

				</div>
			</div>
			<div class="form-group">
				<label class="col-md-4 control-label" for="description">description</label>
				<div class="col-md-4">
					<form:input type="text" placeholder="description details"
						class="form-control input-md" required="true" path="description" />
					<span class="help-block"> </span>
					<form:errors path="description" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-4 control-label" for="price">price</label>
				<div class="col-md-4">
					<form:input type="text" placeholder="enter price"
						class="form-control input-md" required="true" path="price" />
					<span class="help-block"> </span>
					<form:errors path="price" cssClass="error" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-4 control-label" for="quantity">Quantity</label>
				<div class="col-md-4">
					<form:input type="text" placeholder="Enter Quantity"
						class="form-control input-md" required="true" path="quantity" />
					<span class="help-block"> </span>
					<form:errors path="quantity" cssClass="error" />
				</div>

			</div>

			<div class="form-group">
				<label class="col-md-4 control-label" for="supplier_name">Supplier
					name</label>
				<div class="col-md-4">
					<form:input type="text" placeholder="Supplier name"
						class="form-control input-md" required="true" path="supplier_name" />
					<span class="help-block"> </span>
					<form:errors path="supplier_name" cssClass="error" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-4 control-label" for="category_name">category
					Name</label>
				<div class="col-md-4">
				<form:errors path="category_name" cssClass="error" />
						<form:select path="category_name" class="form-control" >
							<form:option value="NONE" label="---Select Category Name---"/> 
							<c:if test="${!empty categoryList}" >
								<c:forEach items="${categoryList}" var="a">
							
									<form:option value="${a.category_name}" />
								</c:forEach>
							</c:if>
						</form:select>
				
				
				
				
				
				
<%-- 					<form:select placeholder="category name" --%>
<%-- 						class="form-control input-md" required="true" path="category_name"> --%>
<%-- <%-- 						<form:option value="NONE" label="--Select Category Name---"/> --%> 
<%-- 						<form:options items="${categoryList}" itemValue="c_id" itemLabel="category_name"></form:options> --%>
<!-- 						<span class="help-block"> </span> -->
<%-- 					</form:select> --%>
<%-- 					<form:errors path="category_name" cssClass="error" /> --%>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-4 control-label" for="image">File
					to upload:</label>
				<div class="col-md-4">
					<form:input type="file" placeholder="select the file"
						class="form-control input-md" path="image" />
					<!-- 						<div class ="form-group"> -->
					<!--  <div class="col-md-4"> -->
					<!-- 		<input type="submit" value="Upload"> Press here to upload the file!</div> -->
					<!-- 		</div> -->

				</div>
			</div>


			<div class="form-group">
				<label class="col-md-4 control-label" for="singlebutton"> </label>
				<div class="col-md-4">
					<button class="btn btn-success" type="submit">Add Product</button>
				</div>
			</div>

		</form:form>
	</div>
	<a href="list">click here to see the list</a>

	<%@ include file="footer.jsp"%>
</body>
</html>