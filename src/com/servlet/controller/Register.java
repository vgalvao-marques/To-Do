package com.servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.model.User;
import com.servlet.utils.fakedb.UserDB;

@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("WEB-INF/view/register.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		UserDB db = new UserDB();
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if(!db.get(email).isPresent()) {			
			User user = new User(name, email, password);
			db.add(user);
			System.out.println("Sucesso na missao");
			response.sendRedirect("login");
			
		}else {
			request.setAttribute("msg", "There is already a registration with email: " + email);
			request.getRequestDispatcher("WEB-INF/view/register.jsp").forward(request, response);
			
		}
		
		
	}	

}
