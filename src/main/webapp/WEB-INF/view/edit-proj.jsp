<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<title>Project Management | Project</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div id="content">
		<h2>Update Project</h2>
		<fieldset>
			<legend>Project - ${project.name}</legend>
			<form:form method="POST" modelAttribute="project">
				<table>
					<tr>
						<td><label>Name:</label></td>
						<td><form:input path="name" /></td>
					</tr>
					<tr>
						<td><label>Status:</label></td>
						<td>
							<form:select path="status.id">
								<form:options items="${statuses}" itemValue="id" itemLabel="status"></form:options>
							</form:select>
						</td>
					</tr>
					<tr>
						<td><label>Description:</label></td>
						<td><form:textarea path="description" rows="5" cols="200"></form:textarea></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Update" /></td>
					</tr>
				</table>
			</form:form>
		</fieldset>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>