package org.example.taskManagementSystem;

import org.example.taskManagementSystem.entities.Task;
import org.example.taskManagementSystem.entities.TaskBuilder;
import org.example.taskManagementSystem.entities.TaskMetaDataBuilder;
import org.example.taskManagementSystem.entities.User;

import java.time.LocalDateTime;

public class TaskManagementSystem {
	public static void main(String [] args) {
		TaskManager taskManager = new TaskManager();

		User max = new User("U1", "Max");
		User alex = new User("U2", "Alex");

		Task t1 = new TaskBuilder()
				.taskId("T1")
				.createdBy(max)
				.title("Buy Potatoes")
				.assignedTo(alex)
				.priority(Priority.MEDIUM)
				.status(Status.pending)
				.build();

		Task t2 = new TaskBuilder()
				.taskId("T2")
				.createdBy(alex)
				.title("Buy Medicines")
				.assignedTo(max)
				.priority(Priority.CRITICAL)
				.dueDate(LocalDateTime.now().plusDays(1))
				.status(Status.pending)
				.build();

		taskManager.addTask(t1.getTaskId(), t1);
		taskManager.addTask(t2.getTaskId(), t2);

		taskManager.assignTaskToUser(max, "T1");
		taskManager.assignTaskToUser(alex, "T2");

//		taskManager.updateTaskStatus("T1", max, Status.completed);
//		taskManager.fetchAllTasksInSystem();
	}
}

