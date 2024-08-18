package org.toDoList.toDoList.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.toDoList.toDoList.dtos.requests.UserSignInRequest;
import org.toDoList.toDoList.dtos.requests.UserSignUpRequest;
import org.toDoList.toDoList.dtos.response.UserSignInResponse;
import org.toDoList.toDoList.dtos.response.UserSignUpResponse;
import org.toDoList.toDoList.services.UserServices;

@RestController
@RequiredArgsConstructor
@RequestMapping
@CrossOrigin(origins = "*")

public class UserServicesController {

    @Autowired
    private UserServices userServices;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody UserSignUpRequest request) {
        try{
            UserSignUpResponse signUpResponse = userServices.signUpUser(request);
            return new ResponseEntity<>(signUpResponse, HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserSignInRequest request) {
        try{
            UserSignInResponse loginResponse = userServices.loginUser(request);
            return new ResponseEntity<>(loginResponse, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
