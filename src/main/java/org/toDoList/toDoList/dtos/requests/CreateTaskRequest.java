package org.toDoList.toDoList.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTaskRequest {

    private String name;
    private String email;
    private String password;

}
