<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>

<html>
<head>
	<title>TeamMemberslijst</title>
</head>
<body>
	<h2>Leden van team ${team.name}</h2>
	<h3>${message}</h3>
	<table border="1px" cellpadding="0" cellspacing="0">
		<tr>
			<td><strong>Voornaam</strong></td><td><strong>Achternaam</strong></td>
		</tr>
		<c:forEach var="member" items="${teamMembers}">
			<tr>
				<td>${member.firstName}</td><td>${member.lastName}</td>
				<td><a href="${pageContext.request.contextPath}/member/deleteFromTeam/${member.id}">Remove member</a></td>
			</tr>
		</c:forEach>
	</table>
	<p/>
	<a href="${pageContext.request.contextPath}/menu">Terug naar het menu</a>
</body>
</html>
