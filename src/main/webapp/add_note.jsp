<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<%@include file="bootstrap_link.jsp"%>

</head>
<body>
	<div class="container">
		<%@include file="navbar.jsp"%>
		<br>

		<h1>Add Notes</h1>
		<br>

		<form action="CreateServlet" method="post">
			<%@include file="form_contain.jsp"%>
		</form>
	</div>


</body>
</html>