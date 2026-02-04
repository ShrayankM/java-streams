package org.example.taskManagementSystem.entities;

import org.example.taskManagementSystem.Priority;
import org.example.taskManagementSystem.Status;

import java.time.LocalDateTime;

public class TaskBuilder {
	private String taskId;
	private User createdBy;
	private User assignedTo;
	private User updatedBy;
	private String title, description;
	private LocalDateTime dueDate;
	private Status status;
	private Priority priority;

	public TaskBuilder taskId(String taskId) {
		this.taskId = taskId;
		return this;
	}

	public TaskBuilder createdBy(User createdBy) {
		this.createdBy = createdBy;
		return this;
	}

	public TaskBuilder assignedTo(User assignedTo) {
		this.assignedTo = assignedTo;
		return this;
	}

	public TaskBuilder updatedBy(User updatedBy) {
		this.updatedBy = updatedBy;
		return this;
	}

	public TaskBuilder title(String title) {
		this.title = title;
		return this;
	}

	public TaskBuilder description(String description) {
		this.description = description;
		return this;
	}

	public TaskBuilder dueDate(LocalDateTime dueDate) {
		this.dueDate = dueDate;
		return this;
	}

	public TaskBuilder status(Status status) {
		this.status = status;
		return this;
	}

	public TaskBuilder priority(Priority priority) {
		this.priority = priority;
		return this;
	}

	public Task build() {
		return new Task(taskId, createdBy, assignedTo, updatedBy, title, description, dueDate, status, priority);
	}
}
