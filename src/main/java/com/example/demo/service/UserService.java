package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public User getUserById(String id) throws Exception {
        Optional<User> optional = this.userRepository.findById(id);

        if (optional.isEmpty()) {
            throw new Exception("No nie ma takiego");
            //TODO throw new UserExcepion
        }

        return optional.get();
    }


    public User saveUser(User user) {
        return this.userRepository.save(user);
    }

    public User deleteUser(String id) throws Exception {
        User user = this.getUserById(id);

        this.userRepository.deleteById(id);
        return user;
    }

    public User updateUser(String id, User updatedUser) throws Exception {
        User user = this.getUserById(id);

        user = new User(updatedUser.getName(), updatedUser.getSurname(), updatedUser.getAge());

        return user;
    }

    public List<User> getUsersByName(String name) {
        return this.userRepository.getAllUsersByName(name);
    }

}


