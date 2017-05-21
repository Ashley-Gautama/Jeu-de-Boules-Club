<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
	<title>${paginaTitel}</title>
</head>
<body>
	<h2>${paginaTitel}</h2>
	<form:form method="POST" commandName="clinic"
		action="${pageContext.request.contextPath}/clinic/add">
		<table>
			<tr>
				<td>Trainer</td>
				<td><form:input path="trainer" /></td>
			</tr>
			<tr>
				<td>Datum</td>
				<td><form:input path="datum" /></td>
			</tr>
			
			
			<tr>
				<td><input type="submit" value="Add Team" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
