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
		<h2>Project list</h2>
		<form>
			<fieldset>
				<legend>Project list</legend>
				<table>
					<tr>
						<th>S.No.</th>
						<th>Name</th>
						<th>Status</th>
						<th>Created On</th>
						<th>Last Updated</th>
					</tr>
					<c:forEach items="${projects}" varStatus="counter" var="project">
						<tr>
							<td>${counter.index + 1}</td>
							<td><a href="<c:url value="/project/view/${project.id}"/>">${project.name}</a></td>
							<td>${project.status.status}</td>
							<td>${project.createdOn}</td>
							<td>${project.modifiedOn}</td>
						</tr>
					</c:forEach>
				</table>
			</fieldset>
		</form>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>