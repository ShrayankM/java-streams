package org.example.taskManagementSystem.entities;

import lombok.Getter;
import lombok.Setter;
import org.example.taskManagementSystem.Priority;
import org.example.taskManagementSystem.Status;

import java.time.LocalDateTime;

@Setter
@Getter
public class Task {
	private String taskId;
	private User createdBy;
	private User assignedTo;
	private User updatedBy;
	private String title, description;
	private LocalDateTime dueDate;
	private Status status;
	private Priority priority;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	public Task(String taskId, User createdBy, User assignedTo, User updatedBy, String title, String description,
			LocalDateTime dueDate, Status status, Priority priority) {
		this.taskId = taskId;
		this.createdBy = createdBy;
		this.assignedTo = assignedTo;
		this.updatedBy = updatedBy;
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
		this.status = status;
		this.priority = priority;
		this.createdAt = LocalDateTime.now();
		this.updatedAt = LocalDateTime.now();
	}
}
