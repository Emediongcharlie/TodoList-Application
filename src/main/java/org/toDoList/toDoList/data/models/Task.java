package org.toDoList.toDoList.data.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
@Getter
@Setter
public class Task {

    @Id
    private String id;
    private String name;
    private String description;
    private String email;
    private String password;
    private  Nature priority;
    private LocalDate dueDate;
    private Status status;
}
