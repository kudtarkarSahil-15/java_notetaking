<%@ page import="org.hibernate.Session"%>
<%@ page import="org.hibernate.query.Query"%>
<%@ page import="com.helper.FactoryProvider"%>
<%@ page import="com.entities.Note"%>
<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>

<%@include file="bootstrap_link.jsp"%>

<link href="css/style.css" rel="stylesheet">

</head>
<body>
	<div class="container">
		<%@include file="navbar.jsp"%>
		<br>
		<h1>View Notes</h1>
	</div>

	<div class="container">
		<%
		Session s = FactoryProvider.getFactory().openSession();
		Query q = s.createQuery("from Note");
		List<Note> l = q.list();
		for (Note n : l) {
		%>
		<!-- Content card -->
		<!-- out.print(n.getNoteId() + " : " + n.getNoteTitle()); -->

		<div class="card container mt-3" style="width:">
			<div class="row">
				<div class="card-body col-2">
					<img src="img/note.png" class="card-img-left"
						style="max-width: 100px;" alt="...">
				</div>

				<div class="card-body col-8">
					<h5 class="card-title"><%=n.getNoteTitle()%></h5>
					<p class="card-text"><%=n.getNoteDescription()%></p>

					<a href="edit_notes.jsp?noteId=<%=n.getNoteId()%>"
						class="btn btn-primary">Edit</a> <a
						href="DeleteServlet?noteId=<%=n.getNoteId()%>"
						class="btn btn-danger">Delete</a>
				</div>
				
				<div class ="card-body col-2">
				   <p class="card-text"><%= n.getNoteWritten() %></p>
				</div>
			</div>
		</div>

		<%
		}
		s.close();
		%>





	</div>
</body>
</html>