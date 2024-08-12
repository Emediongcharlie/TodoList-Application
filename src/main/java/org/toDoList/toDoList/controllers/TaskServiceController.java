package org.toDoList.toDoList.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.GetExchange;
import org.toDoList.toDoList.data.models.Task;
import org.toDoList.toDoList.data.repositories.TaskRepository;
import org.toDoList.toDoList.dtos.requests.CreateTaskRequest;
import org.toDoList.toDoList.dtos.requests.EditTaskRequest;
import org.toDoList.toDoList.dtos.response.CreateTaskResponse;
import org.toDoList.toDoList.dtos.response.EditTaskResponse;
import org.toDoList.toDoList.services.TaskServices;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class TaskServiceController {

    @Autowired
    public final TaskServices taskServices;


    @PostMapping("/create-task")
    public ResponseEntity<?> createMyTask(@RequestBody CreateTaskRequest request) {
        try{
           CreateTaskResponse response = taskServices.createTask(request);
           return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("delete-all-task")
    public ResponseEntity<?> deleteAllTasks() {
        taskServices.deleteAllTask();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/edit-task-by-name/{name}")
    public ResponseEntity<?> editTaskByName(@PathVariable("name") String name, @RequestBody EditTaskRequest request) {
        try{
            EditTaskResponse response = taskServices.editTaskName(request, name);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/find-task-by-name{id}")
    public ResponseEntity<?> findAndGetTaskByName(@PathVariable String id) {
        try {
            Task task = taskServices.findTaskById(id);
            return new ResponseEntity<>(task, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/vieww-all-task")
    public ResponseEntity<?> viewAllTasks() {
        try{
            List<Task> response = taskServices.viewAllTask();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    }

