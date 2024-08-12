package org.toDoList.toDoList.services;

import org.springframework.stereotype.Service;
import org.toDoList.toDoList.dtos.requests.UserSignInRequest;
import org.toDoList.toDoList.dtos.requests.UserSignUpRequest;
import org.toDoList.toDoList.dtos.response.UserSignInResponse;
import org.toDoList.toDoList.dtos.response.UserSignUpResponse;

@Service
public interface UserServices {

    UserSignUpResponse signUpUser(UserSignUpRequest userSignUpRequest);
    UserSignInResponse signInUser(UserSignInRequest userSignInRequest);
}
