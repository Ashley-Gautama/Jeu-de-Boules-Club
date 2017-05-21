<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>

<html>
<head>
	<title>Clinicoverzicht</title>
</head>
<body>
	<h2>Jeu de Boules Club clinicoverzicht</h2>
	<h3>${message}</h3>
	<h3>Voor een overzicht van de teams per clinic klik op de naam van trainer betreffende clinic!</h3>
	<table border="1px" cellpadding="0" cellspacing="0">
		<tr>
			<td><strong>id</strong></td>
			<td><strong>Trainer</strong></td>
			<td><strong>Datum</strong></td>
			
		</tr>
		<c:forEach var="clinic" items="${clinics}">
			<tr>
				<td>${clinic.id}</td>
				<td><a href="${pageContext.request.contextPath}/clinic/clinicDeelnemers/${clinic.id}">${clinic.trainer}</a></td>
				<td>${clinic.datum}</td>
				
				<td><a href="${pageContext.request.contextPath}/clinic/edit/${clinic.id}">Edit </a></td>
				<td><a href="${pageContext.request.contextPath}/clinic/delete/${clinic.id}">Delete </a></td>
				
				
			</tr>
		</c:forEach>
	</table>
	
	<p>
		<a href="${pageContext.request.contextPath}/clinic/add">maak nieuwe clinic</a>
	</p>
	<p>
		<a href="${pageContext.request.contextPath}/menu">Terug naar het hoofdmenu</a>
	</p>
</body>
</html>
