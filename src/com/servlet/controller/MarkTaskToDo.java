package com.servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.utils.fakedb.TodoDB;

@WebServlet("/todo")
public class MarkTaskToDo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		TodoDB db = new TodoDB();

		if (db.getToDo(id) != null) {
			db.getToDo(id).setComplete(false);
			response.sendRedirect("completeds");
		}

	}

}
