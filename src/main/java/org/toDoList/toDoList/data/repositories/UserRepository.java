package org.toDoList.toDoList.data.repositories;

import org.toDoList.toDoList.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findUserByEmail(String email);

    User findUserByEmailAndPassword(String email, String password);

}
