<%@ page import="org.hibernate.Session"%>
<%@ page import="com.helper.FactoryProvider"%>
<%@ page import="com.entities.Note"%>
<%@ page import="java.util.*"%>


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

		<h1>Edit Notes</h1>
		<br>

		<form action="UpdateServlet" method="post">
			<%
			int noteId = Integer.parseInt(request.getParameter("noteId"));
			Session s = FactoryProvider.getFactory().openSession();
			Note n = (Note) s.get(Note.class, noteId);
			%>

			<input value="<%=n.getNoteId()%>" name="noteId" type="hidden" />
			<div class="mb-3">
				<label for="title" class="form-label">Note Title</label> <input
					required type="text" id="title" name="title"
					value="<%=n.getNoteTitle()%>" class="form-control">
			</div>

			<div class="mb-3">
				<label for="description" class="form-label">Note Description</label>
				<textarea required id="description" name="description"
					class="form-control">
     <%=n.getNoteDescription()%>
    </textarea>
			</div>

			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>

</body>
</html>