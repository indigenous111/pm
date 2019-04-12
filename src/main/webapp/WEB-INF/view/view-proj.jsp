<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<title>Project Management | Project</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div id="handle" style="float: right">
		<a href="<c:url value='/project/update/${project.id}'/>">Edit</a>
	</div>
	<div id="content">
		<h2>View Project</h2>
		<form>
			<fieldset>
				<legend>Project - ${project.name}</legend>
				<table>
					<tr>
						<td><label>Name:</label></td>
						<td>${project.name}</td>
					</tr>
					<tr>
						<td><label>Status:</label></td>
						<td>${project.status.status}</td>
					</tr>
					<tr>
						<td><label>Description:</label></td>
						<td>${project.description}</td>
					</tr>
					<tr>
						<td><label>Created On:</label></td>
						<td>${project.createdOn}</td>
					</tr>
					<tr>
						<td><label>Last Updated:</label></td>
						<td>${project.modifiedOn}</td>
					</tr>
				</table>
			</fieldset>
		</form>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>