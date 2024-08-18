package org.toDoList.toDoList.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.toDoList.toDoList.data.models.User;
import org.toDoList.toDoList.data.repositories.UserRepository;
import org.toDoList.toDoList.dtos.requests.UserSignInRequest;
import org.toDoList.toDoList.dtos.requests.UserSignUpRequest;
import org.toDoList.toDoList.dtos.response.UserSignInResponse;
import org.toDoList.toDoList.dtos.response.UserSignUpResponse;
import org.toDoList.toDoList.exceptions.InvalidEmailException;

@Service
@RequiredArgsConstructor
public class UserServicesImpl implements UserServices {

    @Autowired
    private final UserRepository userRepository;



    @Override
    public UserSignUpResponse signUpUser(UserSignUpRequest userSignUpRequest) {
        validateByEmail(userSignUpRequest.getEmail());
        User user = new User();
        user.setEmail(userSignUpRequest.getEmail());
        user.setPassword(userSignUpRequest.getPassword());
        user.setName(userSignUpRequest.getName());
        userRepository.save(user);
        UserSignUpResponse userSignUpResponse = new UserSignUpResponse();
        userSignUpResponse.setMessage("Successfully signed up user");
        return userSignUpResponse;
    }

    @Override
    public UserSignInResponse loginUser(UserSignInRequest userSignInRequest) {
        User user = new User();
        validateByEmailAndPassword(userSignInRequest.getEmail(), userSignInRequest.getPassword());
        user.setEmail(userSignInRequest.getEmail());
        user.setPassword(userSignInRequest.getPassword());
//        userRepository.save(user);
        UserSignInResponse userSignInResponse = new UserSignInResponse();
        userSignInResponse.setMessage("Successfully logged in user");
        return userSignInResponse;
    }

    private void validateByEmail(String email) {
        User userByEmail = userRepository.findUserByEmail(email);
            if (userByEmail != null) {
                throw new InvalidEmailException("email exist already");
            }
        }
    private void validateByEmailAndPassword(String email, String password) {
        User userByEmail = userRepository.findUserByEmailAndPassword(email, password);
        if (userByEmail == null) {
            throw new InvalidEmailException("User email or password not available, sign up please");
        }
    }

}
