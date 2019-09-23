<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1><c:out value="${category.name}"/></h1>
		<h3>Categories</h3>
		<ul>
			<c:forEach items="${category.products}" var="category">
				<li><c:out value="${product.name}"/></li>
			</c:forEach>
		</ul>
		<h3>Add a Category</h3>
		<form:form action="/categories/${category.id}" method="POST">
				<label for="Product">Product:</label>
				<select name="product">
					<c:forEach items="${products}" var="product">
        					<option value="${product.id}"><c:out value="${product.name}"/></option>
   					</c:forEach>
				</select>
			<input type="submit" value="Add Product"/>
		</form:form>
</body>
</html>