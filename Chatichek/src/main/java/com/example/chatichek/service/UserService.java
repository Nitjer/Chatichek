package com.example.chatichek.service;

import com.example.chatichek.entity.User;
import com.example.chatichek.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> login(String login, String password) {
        return userRepository.findByLogin(login)
                .filter(user -> user.getPassword().equals(password));
    }
    public User findByLogin(String login){
        return userRepository.findByLogin(login).orElse(null);
    }
    public User findByLoginAndPassword(String login, String password) {
        return userRepository.findByLoginAndPassword(login, password);
    }

    public User findByUsername (String nickname){
        return userRepository.findByNickname(nickname);
    }

}
