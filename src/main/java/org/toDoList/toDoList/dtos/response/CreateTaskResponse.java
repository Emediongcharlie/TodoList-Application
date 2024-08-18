package org.toDoList.toDoList.dtos.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

@Getter
@Setter
public class CreateTaskResponse {

    private String id;
    private String name;
    private String email;
    private String password;
    private String message;
    private LocalDateTime date = LocalDateTime.now();
//    private LocalDate dueDate = LocalDate.of(2024, 8, 17);
//    private Period doneDate;
}
