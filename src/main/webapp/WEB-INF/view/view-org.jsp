<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
		<form>
			<fieldset>
				<legend>Organisation</legend>
				<table>
					<tr>
						<td> <label>Name:</label> </td>
						<td> ${organisation.name}</td>
					</tr>
					<tr>
						<td> <label>Description:</label> </td>
						<td> ${organisation.description} </td>
					</tr>
				</table>
			</fieldset>
		</form>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>