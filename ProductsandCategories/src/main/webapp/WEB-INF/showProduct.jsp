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
<h1><c:out value="${product.name}"/></h1>
		<h3>Categories</h3>
		<ul>
			<c:forEach items="${product.categories}" var="category">
				<li><c:out value="${category.name}"/></li>
			</c:forEach>
		</ul>
		<h3>Add a Category</h3>
		<form:form action="/products/${product.id}" method="POST">
				<label for="category">Category:</label>
				<select name="category">
					<c:forEach items="${categories}" var="category">
        					<option value="${category.id}"><c:out value="${category.name}"/></option>
   					</c:forEach>
				</select>
			<input type="submit" value="Add Category"/>
		</form:form>
</body>
</html>