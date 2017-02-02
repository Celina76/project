<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
  <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>   
<title>Edit</title>
</head>
<body>

        <h1>Edit Product Info</h1>  
        <center>
       <div class="container">
       <form:form action="update" modelAttribute="ProductInfo" method="post">
         <table width="400px" height="150px">
    <tr>
    <div class="form-group">
     <td><form:label path="product_name">Product name</form:label></td>
     <td><form:input path="product_name" class="form-control" value="${productObject.product_name}" /></td>
     </div>
    </tr>
    <tr>
    <div class="form-group">
     <td><form:label path="description">Description</form:label></td>
     <td><form:input path="description" class="form-control" value="${productObject.description}"/></td>
    </div>
    </tr>
    <tr>
    <div class="form-group">
     <td><form:label path="supplier_name">supplier name</form:label></td>
     <td><form:input path="supplier_name" class="form-control" value="${productObject.supplier_name}"/></td>
   </div>
    </tr>
    <tr>
    <div class="form-group">
     <td><form:label path="category_name">Category Name</form:label></td>
     <td><form:input path="category_name"  class="form-control" value="${productObject.category_name}"/></td>
     </div>
     </tr>
     
    
    <tr>
     <td></td>
     <td><input type="submit" value="update" />
     </td>
    </tr>
   </table>
 
  </form:form>
 
</div>
  </center>
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
<%--   <form:form  class="form-horizontal"action="update" modelAttribute="prod" method="post"> --%>
<!--      <table width="400px" height="150px"> -->
   
<!--     <tr> -->
<!--     <div class="form-group"> -->
<%--      <td><form:label path="product_name">Product name</form:label></td> --%>
<%--      <td><form:input path="product_name" class="form-control" value="${prodObj.product_name}"/></td> --%>
<!--     </div> -->
<!--     </tr> -->
<!--     <tr> -->
<!--     <div class="form-group"> -->
<%--      <td><form:label path="description">Description</form:label></td> --%>
<%--      <td><form:input path="description" class="form-control" value="${prodObj.description}"/></td> --%>
<!--    </div> -->
<!--     </tr> -->
<!--     <tr> -->
<!--     <div class="form-group"> -->
<%--      <td><form:label path="category_name">Category Name</form:label></td> --%>
<%--      <td><form:input path="category_name"  class="form-control" value="${prodObj.category_name}"/></td> --%>
<!--      </div> -->
<!--      </tr> -->
<!--      <tr> -->
<!--      <div class="form-group"> -->
<%--      <td><form:label path="supplier_name">Supplier Name</form:label></td> --%>
<%--      <td><form:input path="supplier_name" class="form-control" value="${prodObj.supplier_name}"/></td> --%>
<!--      </div> -->
<!--      </tr> -->
<!--     </tr> -->
<!--     <tr> -->
<!--      <td></td> -->
<!--      <td><input type="submit" value="update" /> -->
<!--      </td> -->
<!--     </tr> -->
<!--    </table> -->
 
<%--   </form:form> --%>
 
<!-- </div> -->
</body>
</html>