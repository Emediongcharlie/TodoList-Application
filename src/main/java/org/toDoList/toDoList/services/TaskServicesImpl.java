package org.toDoList.toDoList.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.toDoList.toDoList.data.models.Task;
import org.toDoList.toDoList.data.repositories.TaskRepository;
import org.toDoList.toDoList.dtos.requests.CreateTaskRequest;
import org.toDoList.toDoList.dtos.requests.EditTaskRequest;
import org.toDoList.toDoList.dtos.response.CreateTaskResponse;
import org.toDoList.toDoList.dtos.response.DeleteTaskResponse;
import org.toDoList.toDoList.dtos.response.EditTaskResponse;
import org.toDoList.toDoList.exceptions.InvalidNameException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServicesImpl implements TaskServices{

    @Autowired
    public final TaskRepository taskRepository;

    @Override
    public CreateTaskResponse createTask(CreateTaskRequest request) {
        validateEmail(request.getEmail());
        Task task = new Task();
        CreateTaskResponse response = new CreateTaskResponse();
        task.setName(request.getName());
        task.setEmail(request.getEmail());
        task.setPassword(request.getPassword());
        taskRepository.save(task);
        response.setName(task.getName());
        response.setEmail(task.getEmail());
        response.setId(task.getId());
        response.setPassword(task.getPassword());
        response.setMessage("Task created successfully");
        return response;
    }

    @Override
    public DeleteTaskResponse deleteAllTask() {
        taskRepository.deleteAll();
        DeleteTaskResponse response = new DeleteTaskResponse();
        response.setMessage("successfully deleted");
        return response;
    }

    @Override
    public EditTaskResponse editTaskName(EditTaskRequest request, String name) {
//        Task task = new Task();
//        Task taskToEdit = taskRepository.findByName(name);
//        taskToEdit.setName(request.getName());
//        taskToEdit.setEmail(request.getEmail());
//        taskToEdit.setPassword(request.getPassword());
//        taskRepository.save(task);
//        EditTaskResponse response = new EditTaskResponse();
//        response.setName(taskToEdit.getName());
//        response.setEmail(taskToEdit.getEmail());
//        response.setPassword(taskToEdit.getPassword());
//        response.setMessage("successfully edited");
//        return response;
        Optional<Task> task = taskRepository.findByName(name);
        if (task.isPresent()) {
            Task taskToEdit = task.get();
            taskToEdit.setName(request.getName());
            taskToEdit.setEmail(request.getEmail());
            taskToEdit.setPassword(request.getPassword());
            taskRepository.save(taskToEdit);
            EditTaskResponse response = new EditTaskResponse();
            response.setEmail(taskToEdit.getEmail());
            response.setPassword(taskToEdit.getPassword());
            response.setName(taskToEdit.getName());
            response.setMessage("successfully edited");
            return response;
        }
        throw new InvalidNameException("name is not valid");
    }

    public Task findTaskById(String id) {
       Optional<Task> task = taskRepository.findById(id);
       if (task.isPresent()) {
           task.get().getId();
       }
        return task.orElse(null);
    }

    @Override
    public List<Task> viewAllTask() {
        return taskRepository.findAll();
    }

    private void validateEmail(String email) {
        Task emailCheck = taskRepository.findByEmail(email);
        if (emailCheck != null) {
            throw new InvalidNameException("email already exist");
        }
    }

//    private void validateName(String name) {
//        Task nameCheck = taskRepository.findByName(name);
//        if (nameCheck != null) {
//            throw new InvalidNameException("name already exist");
//        }
//    }


}
