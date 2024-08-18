package org.toDoList.toDoList.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.toDoList.toDoList.data.models.Task;
import org.toDoList.toDoList.data.repositories.TaskRepository;
import org.toDoList.toDoList.dtos.requests.CreateTaskRequest;
import org.toDoList.toDoList.dtos.requests.EditTaskRequest;
import org.toDoList.toDoList.dtos.response.CreateTaskResponse;
import org.toDoList.toDoList.dtos.response.EditTaskResponse;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskServicesTest {

    @Autowired
    private TaskServices taskServices;
    @Autowired
    private TaskRepository taskRepository;

    @BeforeEach
    public void setUp() {
        taskServices.deleteAllTask();
    }

    @Test
    public void testAddTask() {
        CreateTaskRequest request = new CreateTaskRequest();
        request.setName("Test Task");
        request.setPassword("22222");
        request.setEmail("java@test.com");
        CreateTaskResponse response = taskServices.createTask(request);
        assertThat(response).isNotNull();
        assertThat(response.getName().contains("Test Task"));
    }

    @Test
    public void testDeleteTask() {
        CreateTaskRequest request = new CreateTaskRequest();
        request.setName("Test Task");
        request.setPassword("22222");
        request.setEmail("java@test.com");
        CreateTaskResponse response = taskServices.createTask(request);
        assertThat(response).isNotNull();
        taskServices.deleteAllTask();
        assertThat(taskServices.findTaskById(response.getId())).isNull();
    }

    @Test
    public void testUpdateTaskByName() {
        CreateTaskRequest request = new CreateTaskRequest();
        EditTaskRequest editTaskRequest = new EditTaskRequest();
        request.setName("Test Task");
        request.setPassword("22222");
        request.setEmail("java@test.com");
        CreateTaskResponse response = taskServices.createTask(request);
        assertThat(response).isNotNull();
        editTaskRequest.setName("Test Task");
        editTaskRequest.setPassword("33333");
        editTaskRequest.setEmail("python@test.com");
        EditTaskResponse editResponse = taskServices.editTaskName(editTaskRequest, response.getName());
        assertThat(editResponse).isNotNull();
        assertThat(response.getPassword().contains("33333"));
    }

    @Test
    public void testFindTaskByPassword(){
        CreateTaskRequest request = new CreateTaskRequest();
        request.setName("Test Task");
        request.setPassword("22222");
        request.setEmail("ema@test.com");
        CreateTaskResponse response = taskServices.createTask(request);
        assertThat(response).isNotNull();
        assertThat(response.getName().contains("Test Task"));
    }

    @Test
    public void testViewAll(){
        CreateTaskRequest request = new CreateTaskRequest();
        request.setName("T Task");
        request.setPassword("22222");
        request.setEmail("java@test.com");
        CreateTaskResponse response = taskServices.createTask(request);
        assertThat(response).isNotNull();
        CreateTaskRequest request2 = new CreateTaskRequest();
        request2.setName("Test Task");
        request2.setPassword("22222");
        request2.setEmail("ema@test.com");
        taskServices.createTask(request2);
        assertEquals(taskRepository.count(), 2);
    }
}
