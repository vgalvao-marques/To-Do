package com.servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.model.User;
import com.servlet.utils.fakedb.UserDB;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/view/index.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if (User.validateCredential(email, password)) {
			UserDB udb = new UserDB();
			request.getSession().setAttribute("user", udb.get(email).get());
			response.sendRedirect("tasks");
			return;

		} else {
			request.setAttribute("msg", "Invalid email or password.");
			request.getRequestDispatcher("WEB-INF/view/index.jsp").forward(request, response);
		}

	}

}
