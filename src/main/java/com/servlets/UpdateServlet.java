package com.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.helper.FactoryProvider;

public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			String title = request.getParameter("title");
			String description = request.getParameter("description");
			int noteId = Integer.parseInt(request.getParameter("noteId"));
			
			Session s = FactoryProvider.getFactory().openSession();
			Transaction tx = s.beginTransaction();
			
			Note n = (Note)s.get(Note.class, noteId);
			n.setNoteTitle(title);
			n.setNoteDescription(description);
			n.setWrittenOn(new Date());
			
			tx.commit();
			s.close();
			
			response.sendRedirect("view_notes.jsp");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
