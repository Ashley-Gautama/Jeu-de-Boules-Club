<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>Teamoverzicht</title>
</head>
<body>
	<h2>Jeu de Boules Club teamoverzicht</h2>
	<h3>${message}</h3>
	<h3>Voor een overzicht van de leden per team klik op de naam van
		het team!</h3>
	<table border="1px" cellpadding="0" cellspacing="0">
		<tr>
			<td><strong>id</strong></td>
			<td><strong>Naam</strong></td>
			<td><strong>Coach</strong></td>
			<td><strong></strong></td>
		</tr>
		<c:forEach var="team" items="${teams}">
			<tr>
				<td>${team.id}</td>
				<td><a
					href="${pageContext.request.contextPath}/team/teamMembers/${team.id}">${team.name}</a></td>
				<td>${team.coach}</td>
				<td><a
					href="${pageContext.request.contextPath}/team/delete/${team.id}">Delete
						Team </a></td>
				<td><a
					href="${pageContext.request.contextPath}/team/edit/${team.id}">edit
						Team </a></td>
			</tr>
		</c:forEach>
	</table>
	<p>
		<a href="${pageContext.request.contextPath}/team/add">voeg team toe</a>
	</p>
	<p>
		<a href="${pageContext.request.contextPath}/menu">Terug naar het
			hoofdmenu</a>
	</p>
</body>
</html>
