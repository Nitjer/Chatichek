package com.example.chatichek.repository;

import com.example.chatichek.entity.UserChatic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserChaticRepository extends JpaRepository<UserChatic, Integer> {
}
