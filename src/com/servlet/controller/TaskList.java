package com.servlet.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.model.Task;
import com.servlet.model.User;
import com.servlet.utils.fakedb.TodoDB;

@WebServlet("/tasks")
public class TaskList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		TodoDB db = new TodoDB();
		
		User user = (User) request.getSession().getAttribute("user");
		
		List<Task> tasks = db.getToDoList(user.getId()).stream()
				.filter(t -> t.isComplete() == false).collect(Collectors.toList());
		
		request.setAttribute("tasks", tasks);

		request.getRequestDispatcher("WEB-INF/view/tasks.jsp").forward(request, response);
	}

}
