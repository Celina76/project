<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>   
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp"%> 
<div class="row">
 <c:forEach items="${List}" var="product"> 
<div class="col-xs-3">
<img src="<c:url value="/resources/images/${product.product_name}.jpg"/>" class="img-responsive">
 <div class="caption"> 
 <div class="row"> 
 <div class="font-effect-wallpaper" class="col-md-12 col=xs-12" style="color:black"> 
<center>
${product.product_name }
</center>
</div>
</div>
</div> 
 </div> 






</c:forEach> 
</div>
</body>
<%@ include file="footer.jsp"%> 
</html>