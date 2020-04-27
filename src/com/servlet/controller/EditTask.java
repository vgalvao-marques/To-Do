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
import com.servlet.utils.fakedb.TodoDB;

@WebServlet("/edit")
public class EditTask extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		TodoDB db = new TodoDB();

		if (db.getToDo(id) != null) {
			request.setAttribute("task", db.getToDo(id));
			request.getRequestDispatcher("WEB-INF/view/edit-task.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String notes = request.getParameter("notes");
		LocalDate date = LocalDate.parse(request.getParameter("date"));
		LocalTime time = LocalTime.parse(request.getParameter("time"));

		TodoDB db = new TodoDB();

		if (db.getToDo(id) != null) {
			Task task = db.getToDo(id);
			task.setTitle(title);
			task.setNotes(notes);
			task.setDate(date);
			task.setTime(time);

		}
		response.sendRedirect("tasks");
	}

}
