<%@include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:if test="${ !empty list}">
<div class="container">
		<div class="row text-center">
			<h2>products</h2>
			
<!-- 				<div class="thumbnail"> -->
<div class="row text-center">
<c:forEach items="${list }" var="product">
<div class="col-xs-4 col-sm-3">
					<a href="#"><div class="div1">
					<img src="<c:url value='resources/images/${product.product_name}.jpg'/>"
						alt="music" class="img-responsive"
						style="width: 400px; height: 370px" />
						</div></a>
					</br>
					<sec:authorize access="hasRole('ROLE_USER')"><a href="viewImg?pdt=${product.id }">
					<button type="button" class="btn-btn-info">View Details</button>
					</a></sec:authorize>
					<h1>${product.product_name}</h1>
					</p>
					<p>
					<h2>${product.price}</h2>
					</p>

					<%-- 					<sec:authorize access="hasRole('ROLE_USER')"> --%>
<%-- 					<a href="addtocart?pdt=${product.product_id}"><button type="button" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span>Add to Cart</button></a> --%>

<%-- 					<button type="button" class="btn btn-danger">Buy Now</button></sec:authorize> --%>
				</div>
		
			 </c:forEach> 
			 	</div>
		</div>
	</div>
	</c:if>
</body>
</html>