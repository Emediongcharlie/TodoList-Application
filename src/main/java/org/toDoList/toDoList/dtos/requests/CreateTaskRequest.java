package org.toDoList.toDoList.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;


@Getter
@Setter
public class CreateTaskRequest {

    private String name;
    private String email;
    private String password;
    private LocalDateTime createdAt = LocalDateTime.now();
//    private LocalDate dueDate;
//    private Period doneDate = Period.ofDays(1);

}
