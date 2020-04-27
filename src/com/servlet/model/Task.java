package com.servlet.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Task {

	private int id;
	private int userId;
	private String title;
	private String notes;
	private LocalDate date;
	private LocalTime time;
	private boolean complete;

	public Task(int userId, String title, String notes, LocalDate date, LocalTime time, boolean complete) {
		this.userId = userId;
		this.title = title;
		this.notes = notes;
		this.date = date;
		this.time = time;
		this.complete = complete;
	}

	public Task(int userId, String title) {
		this(userId, title, null, null, null, false);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	

}
