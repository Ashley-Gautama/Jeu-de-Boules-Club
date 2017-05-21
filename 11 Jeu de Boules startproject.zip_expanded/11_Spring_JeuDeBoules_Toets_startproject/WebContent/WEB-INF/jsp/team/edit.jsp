<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>

<html>
<head>
	<title>${paginaTitel}</title>
</head>

<body>
	<h2>${paginaTitel}</h2>
	<form:form method="POST" commandName="team"
		action="${pageContext.request.contextPath}/team/edit">
		<table>
			<tr>
				<td>Id</td>
				<td><form:input path="id" readonly="true" /></td>
			</tr>
			<tr>
				<td>Naam</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Coach</td>
				<td><form:input path="coach" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Edit team" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
