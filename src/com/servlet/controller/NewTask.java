package com.servlet.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.model.Task;
import com.servlet.model.User;
import com.servlet.utils.fakedb.TodoDB;

@WebServlet("/newtask")
public class NewTask extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/view/new-task.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String title = request.getParameter("title");
		String notes = request.getParameter("notes");
		LocalDate date = LocalDate.parse(request.getParameter("date"));
		LocalTime time = LocalTime.parse(request.getParameter("time"));

		User user = (User) request.getSession().getAttribute("user");

		TodoDB db = new TodoDB();

		Task task = new Task(user.getId(), title, notes, date, time, false);

		db.addToDo(task);

		response.sendRedirect("tasks");

	}

}
