package org.toDoList.toDoList.services;

import org.springframework.stereotype.Service;
import org.toDoList.toDoList.data.models.Task;
import org.toDoList.toDoList.dtos.requests.CreateTaskRequest;
import org.toDoList.toDoList.dtos.requests.EditTaskRequest;
import org.toDoList.toDoList.dtos.response.CreateTaskResponse;
import org.toDoList.toDoList.dtos.response.DeleteTaskResponse;
import org.toDoList.toDoList.dtos.response.EditTaskResponse;
import org.toDoList.toDoList.dtos.response.MarkAsDoneResponse;

import java.util.List;

@Service
public interface TaskServices {

    CreateTaskResponse createTask(CreateTaskRequest request);
    DeleteTaskResponse deleteAllTask();
    EditTaskResponse editTaskName(EditTaskRequest request, String name);
    List<Task> viewAllTask();
    Task findTaskById(String name);
    DeleteTaskResponse deleteTaskByName(String name);
    MarkAsDoneResponse taskDone(String name);
}
