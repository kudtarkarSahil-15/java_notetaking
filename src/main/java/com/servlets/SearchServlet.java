package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.helper.FactoryProvider;


public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			String search = request.getParameter("search");
			
			System.out.println(search);
			
			
			Session session = FactoryProvider.getFactory().openSession();
			session.beginTransaction();
			
			session.getTransaction().commit();
			session.close();
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}

}
