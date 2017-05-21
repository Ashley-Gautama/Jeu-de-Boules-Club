<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
	<title>Ledenlijst</title>
</head>
<body>
	<h2>Dit is de ledenlijst van de Jeu de Boules Club</h2>
	<h3>${message}</h3>
	<table border="1px" cellpadding="0" cellspacing="0">
		<tr>
			<td><strong> id</strong></td>
			<td><strong> Voornaam </strong></td>
			<td><strong> Achternaam </strong></td>
			<td><strong> Team </strong></td>
			<td><strong> </strong></td>
		</tr>
		<c:forEach var="member" items="${members}">
			<tr>
				<td>${member.id}</td>
				<td>${member.firstName}</td>
				<td>${member.lastName}</td>
				<td>${member.team.name}</td>
				<td><a
					href="${pageContext.request.contextPath}/member/edit/${member.id}">Edit</a>
					<br /> <a
					href="${pageContext.request.contextPath}/member/delete/${member.id}">Delete</a><br />
				</td>
			</tr>
		</c:forEach>
	</table>
	<p>
		<a href="${pageContext.request.contextPath}/member/add">Maak nieuw
			lid aan</a>
	</p>
	<p>
		<a href="${pageContext.request.contextPath}/menu">Terug naar het
			hoofdmenu</a>
	</p>
</body>
</html>
