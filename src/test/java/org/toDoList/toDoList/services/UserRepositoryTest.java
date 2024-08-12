package org.toDoList.toDoList.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.toDoList.toDoList.data.models.User;
import org.toDoList.toDoList.data.repositories.UserRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testName(){
        User user = new User();
        user.setName("Emediong");
        userRepository.save(user);
        assertEquals(user.getName(), "Emediong");
        }

}
