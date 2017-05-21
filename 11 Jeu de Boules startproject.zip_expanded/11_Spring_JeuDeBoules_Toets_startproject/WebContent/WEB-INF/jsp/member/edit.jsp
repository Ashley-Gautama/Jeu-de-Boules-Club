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
	<form:form method="POST" commandName="member"
		action="${pageContext.request.contextPath}/member/edit">
		<table>
			<tr>
				<td>Id</td>
				<td><form:input path="id" readonly="true" /></td>
			</tr>
			<tr>
				<td>Voornaam</td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<td>Achternaam</td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td>Team</td>
				<td><form:select path="team">
						<form:option value="${member.team.id}">${member.team.name}</form:option>
						<form:options items="${teamList}" itemValue="id" itemLabel="name" />
					</form:select></td>
			</tr>
			<tr>
				<td><input type="submit" value="Edit member" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
