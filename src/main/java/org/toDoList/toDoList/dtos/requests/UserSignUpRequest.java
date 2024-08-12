package org.toDoList.toDoList.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserSignUpRequest {

    private String name;
    private String email;
    private String password;
}
