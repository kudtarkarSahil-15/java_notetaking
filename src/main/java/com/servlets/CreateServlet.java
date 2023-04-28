package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.helper.FactoryProvider;

public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try
		{
			String title = request.getParameter("title");
			String description = request.getParameter("description");
			
			Note note = new Note(title, description, new Date());
//			System.out.println(note.getNoteId() + " : " + note.getNoteTitle() + " : " +note.getNoteWritten());
			
			//TODO hibernate: save() operation
			Session session = FactoryProvider.getFactory().openSession();
//			Transaction tx = session.beginTransaction();
			session.beginTransaction();
			
			session.save(note);
			session.getTransaction().commit();
//			tx.commit();
			
			session.close();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		PrintWriter out = response.getWriter();
		out.println("<h1>Successfully Added...</h1>");
	}

}
