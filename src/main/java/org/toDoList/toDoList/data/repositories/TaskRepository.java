package org.toDoList.toDoList.data.repositories;

import org.toDoList.toDoList.data.models.Status;
import org.toDoList.toDoList.data.models.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.toDoList.toDoList.dtos.response.MarkAsDoneResponse;

import java.util.Optional;

public interface TaskRepository extends MongoRepository<Task, String> {
    Task findByEmail(String email);

    Optional<Task> findByName(String name);

    boolean findStatusByStatus(Status status);



}
