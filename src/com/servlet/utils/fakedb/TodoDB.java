package com.servlet.utils.fakedb;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.servlet.model.Task;

public class TodoDB {

	private static int seq_id = 100;
	private static Map<Integer, Task> dbToDo = new LinkedHashMap<Integer, Task>();

	public Task getToDo(int id) {
		if (TodoDB.dbToDo.containsKey(id)) {
			return TodoDB.dbToDo.get(id);
		}
		return null;
	}
	
	public List<Task> getToDoList(int userId){		
		List<Task> todos = new ArrayList<Task>(TodoDB.dbToDo.values());		
		return todos.stream().filter(t -> t.getUserId() == userId).collect(Collectors.toList());		
	}

	public void addToDo(Task todo) {
		todo.setId(seq_id++);
		TodoDB.dbToDo.put(todo.getId(), todo);
	}

	public void updateToDo(int id, Task update) {
		if (TodoDB.dbToDo.containsKey(id)) {
			Task todo = TodoDB.dbToDo.get(id);
			todo.setTitle(update.getTitle());
			todo.setNotes(update.getNotes());
			todo.setDate(update.getDate());
			todo.setTime(update.getTime());
			todo.setComplete(update.isComplete());

		}
	}

	public void deleteToDo(int id) {
		if (TodoDB.dbToDo.containsKey(id)) {
			Task todo = TodoDB.dbToDo.get(id);
			TodoDB.dbToDo.remove(todo.getId(), todo);
		}

	}

}
