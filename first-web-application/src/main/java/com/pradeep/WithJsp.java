package com.pradeep;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/withjsp")
public class WithJsp extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		out.println("test");
		
		String name=request.getParameter("name");
		request.setAttribute("name",name);
		request.setAttribute("password",request.getParameter("password"));
		
		request.getRequestDispatcher("/WEB-INF/views/logging.jsp").forward(request, response);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		
		if (name.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin123")) {
		
		request.setAttribute("name", request.getParameter("name"));
		request.setAttribute("password", request.getParameter("password"));
		request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
		}else {
			request.setAttribute("error","invalid user");
			request.getRequestDispatcher("/WEB-INF/views/logging.jsp").forward(request, response);
			
		}

	}

}
