<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Product</title>
</head>
<body>
<form:form action="/products/new" method="post" modelAttribute = "product">
<form:input type="text" path="name"/>
<form:input type="textbox" path="description"/>
<form:input type="number" path="price"/>
<input type="submit"/>
</form:form>
</body>
</html>