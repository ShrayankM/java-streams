package org.example.taskManagementSystem;

import org.example.taskManagementSystem.entities.Task;
import org.example.taskManagementSystem.entities.TaskMetaData;
import org.example.taskManagementSystem.entities.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TaskManager {
	private HashMap<String, Task> taskMap;
	private HashMap<String, List<Task>> userTaskMap;

	public TaskManager() {
		this.taskMap = new HashMap<>();
		this.userTaskMap = new HashMap<>();
	}

	public void addTask(String taskId, Task task) {
		taskMap.putIfAbsent(taskId, task);
	}

	public void updateTaskTitle(String taskId, String title) {
		if (taskMap.get(taskId) != null) {
			if (title != null && !title.isEmpty()) {
				Task currentTask = taskMap.get(taskId);
				currentTask.setTitle(title);
			}
		} else {
			System.out.println("Task not found in the system");
		}
	}

//	public void updateTask(User updatedBy, TaskMetaData taskMetaData, String taskId) {
//		Task task = taskMap.get(taskId);
//		if (task != null) {
//			TaskMetaData currentTaskMetaData = task.getTaskMetaData();
//
//			if (taskMetaData.getTitle() != null) currentTaskMetaData.setTitle(taskMetaData.getTitle());
//			if (taskMetaData.getDescription() != null) currentTaskMetaData.setDescription(taskMetaData.getDescription());
//			if (taskMetaData.getDueDate() != null) currentTaskMetaData.setDueDate(taskMetaData.getDueDate());
//			if (taskMetaData.getStatus() != null) currentTaskMetaData.setStatus(taskMetaData.getStatus());
//			if (taskMetaData.getPriority() != null) currentTaskMetaData.setPriority(taskMetaData.getPriority());
//
//			task.setUpdatedBy(updatedBy);
//		}
//	}

	public boolean deleteTask(String taskId) {
		Task task = taskMap.get(taskId);
		if (task != null) {
			taskMap.remove(taskId);
			return true;
		}
		return false;
	}

	public void assignTaskToUser(User assignedUser, String taskId) {
		String userId = assignedUser.getId();
		if (userTaskMap.get(userId) == null) {
			List<Task> taskList = new ArrayList<>();

			Task task = taskMap.get(taskId);
			if (task != null) {
				task.setAssignedTo(assignedUser);
				taskList.add(task);
			}

			userTaskMap.put(userId, taskList);
		} else {
			List<Task> userTaskList = userTaskMap.get(userId);

			Task task = taskMap.get(taskId);
			if (task != null) {
				task.setAssignedTo(assignedUser);
				userTaskList.add(task);
			}

			userTaskMap.put(userId, userTaskList);
		}
	}

//	public void fetchAllTasksInSystem() {
//		for (Task task: taskMap.values()) {
//			System.out.println("Task =  " + task + " metadata = {" + task.getTaskMetaData() + "}");
//		}
//	}
//
//	public void displayAllTasksForUser(String userId) {
//		List<Task> userTasks = userTaskMap.get(userId);
//		for (Task task: userTasks) {
//			System.out.println("Task =  " + task + " metadata = {" + task.getTaskMetaData() + "}");
//		}
//	}
//
//	public void updateTaskStatus(String taskId, User updatedBy, Status taskStatus) {
//		String userId = updatedBy.getId();
//
//		List<Task> userTaskList = userTaskMap.get(userId);
//		for (Task task : userTaskList) {
//			if (task.getTaskId().equals(taskId)) {
//				TaskMetaData taskMetaData = task.getTaskMetaData();
//				taskMetaData.setStatus(taskStatus);
//
//				task.setTaskMetaData(taskMetaData);
//			}
//		}
//	}
}
