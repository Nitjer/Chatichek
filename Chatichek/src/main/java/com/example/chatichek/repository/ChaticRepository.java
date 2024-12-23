package com.example.chatichek.repository;

import com.example.chatichek.entity.Chatic;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ChaticRepository extends JpaRepository<Chatic, Integer> {
    List<Chatic> findAll();
}
