<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>

<html>
<head>
	<title>ClinicTeamlijst</title>
</head>
<body>
	<h2>Teams voor clinic van ${clinic.trainer}</h2>
	<h3>${message}</h3>
	<table border="1px" cellpadding="0" cellspacing="0">
		<tr>
			<td><strong>naam team</strong></td><td><strong>coach team</strong></td>
		</tr>
		<c:forEach var="team" items="${clinicDeelnemers}">
			<tr>
				<td>${team.name}</td><td>${team.coach}</td>
				<td><a href="${pageContext.request.contextPath}/clinic/clinicDeelnemers/${id}/removeteam/${team.id}">Remove Team</a></td>
			</tr>
		</c:forEach>
	</table>
	<p/>
	
	<form:form method="POST" commandName="clinic"
		action="${pageContext.request.contextPath}/clinic/clinicDeelnemers/${id}/editTeams">
		<table>
			<tr>
				<td><form:hidden path="id" /></td>
			</tr>
			<tr>
				<td><form:hidden path="trainer" /></td>
			</tr>
			<tr>
				<td><form:hidden path="datum" /></td>
			</tr>

			
			<tr>
				<td>selecteer deelnemers</td>
				<td><form:checkboxes items="${teams }" path="deelnemers"
						itemValue="id" itemLabel="name" /></td>










			</tr>
			<tr>
				<td><input type="submit" value="voeg teams toe aan clinic" /></td>

			</tr>
			<tr>
				

			</tr>
		</table>
	</form:form>
	
	
	<form action="${pageContext.request.contextPath}/clinic/cliniclist">
					<input type="submit" value="back" />
				</form>
	<a href="${pageContext.request.contextPath}/menu">Terug naar het menu</a>
</body>
</html>