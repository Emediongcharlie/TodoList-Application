package org.toDoList.toDoList.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MarkAsDoneRequest {

    private String name;
    private String email;
    private String password;
}
