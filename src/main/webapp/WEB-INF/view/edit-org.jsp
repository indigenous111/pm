<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false" %>
<html>
<head>
<title>Project Management | Organisation</title>
</head> 
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div id="handle" style="float: right">
		<a href="<c:url value='/org/edit'/>">Edit</a>
	</div>
	<div id="content">
		<h2>Organisation</h2>
		<form:form method="post" modelAttribute="organisation">
			<fieldset>
				<legend>Organisation</legend>
				<table>
					<tr>
						<td> <label>Name:</label> </td>
						<td> <form:input path="name"/></td>
					</tr>
					<tr>
						<td> <label>Description:</label> </td>
						<td> <form:textarea path="description" rows="5" cols="200"/></td>
					</tr>
					<tr>
						<td colspan="2">
							<form:hidden path="id" />
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="Update" />
						</td>
					</tr>
				</table>
			</fieldset>
		</form:form>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>