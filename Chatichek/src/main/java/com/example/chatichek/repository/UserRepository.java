package com.example.chatichek.repository;

import com.example.chatichek.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByLogin(String login);
    User findByLoginAndPassword(String login, String password);
    User findByNickname(String nickname);
}

