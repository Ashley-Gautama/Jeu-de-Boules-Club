<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>${paginaTitel}</title>
</head>

<body>
	<h2>${paginaTitel}</h2>
	<form:form method="POST" commandName="clinic"
		action="${pageContext.request.contextPath}/clinic/edit">
		<table>
			<tr>
				<td>Id</td>
				<td><form:input path="id" readonly="true" /></td>
			</tr>
			<tr>
				<td>Trainer</td>
				<td><form:input path="trainer" /></td>
			</tr>
			<tr>
				<td>Datum</td>
				<td><form:input path="datum" /></td>
			</tr>

			<tr>
				<td><form:hidden path="deelnemers"     /></td>
				

			</tr>
			
			<tr>
				<td><input type="submit" value="Edit Clinic" /></td>

			</tr>
			<tr>
				

			</tr>
		</table>
	</form:form>
	
	<form action="${pageContext.request.contextPath}/clinic/cliniclist">
					<input type="submit" value="back" />
				</form>
</body>
</html>
