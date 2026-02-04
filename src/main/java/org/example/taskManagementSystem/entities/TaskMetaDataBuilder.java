package org.example.taskManagementSystem.entities;

import lombok.Setter;
import org.example.taskManagementSystem.Priority;
import org.example.taskManagementSystem.Status;

import java.time.LocalDateTime;

@Setter
public class TaskMetaDataBuilder {
	private String title, description;
	private LocalDateTime dueDate;
	private Status status;
	private Priority priority;

	public TaskMetaDataBuilder title(String title) {
		this.title = title;
		return this;
	}

	public TaskMetaDataBuilder description(String description) {
		this.description = description;
		return this;
	}

	public TaskMetaDataBuilder dueDate(LocalDateTime dueDate) {
		this.dueDate = dueDate;
		return this;
	}

	public TaskMetaDataBuilder priority(Priority priority) {
		this.priority = priority;
		return this;
	}

	public TaskMetaDataBuilder status(Status status) {
		this.status = status;
		return this;
	}

	public TaskMetaData build() {
		return new TaskMetaData(this.title, this.description, this.dueDate, this.status, this.priority);
	}
}
