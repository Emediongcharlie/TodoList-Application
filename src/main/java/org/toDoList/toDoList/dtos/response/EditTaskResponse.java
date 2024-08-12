package org.toDoList.toDoList.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditTaskResponse {

    private String name;
    private String email;
    private String password;
    private String message;
}
