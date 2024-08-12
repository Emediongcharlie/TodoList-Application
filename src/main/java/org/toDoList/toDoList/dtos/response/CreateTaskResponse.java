package org.toDoList.toDoList.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTaskResponse {

    private String id;
    private String name;
    private String email;
    private String password;
    private String message;
}
