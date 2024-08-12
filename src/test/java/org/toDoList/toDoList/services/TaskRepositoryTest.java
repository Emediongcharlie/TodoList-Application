package org.toDoList.toDoList.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.toDoList.toDoList.data.models.Task;
import org.toDoList.toDoList.data.repositories.TaskRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskRepositoryTest {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void testName(){
        Task task = new Task();
        task.setName("Test Task");
        taskRepository.save(task);
        assertEquals(task.getName(), "Test Task");
    }
}
