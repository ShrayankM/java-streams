package org.example.taskManagementSystem.entities;

import lombok.Getter;
import lombok.Setter;
import org.example.taskManagementSystem.Priority;
import org.example.taskManagementSystem.Status;

import java.time.LocalDateTime;

@Setter
@Getter
public class TaskMetaData {
	private String title, description;
	private LocalDateTime dueDate;
	private Status status;
	private Priority priority;

	public TaskMetaData(String title, String description, LocalDateTime dueDate, Status status, Priority priority) {
		this.title = title;
		this.description = description;
		this.dueDate = dueDate;
		this.priority = priority;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Title [" + title + "], desc = [" + description + "], dueDate = {" + dueDate + "}, priority = {" + this.priority + "}, "
				+ "status = {" + status + "}";
	}
}
