package com.example.chatichek.service;

import com.example.chatichek.entity.Chatic;
import com.example.chatichek.repository.ChaticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChaticService {

    @Autowired
    private ChaticRepository chaticRepository;

    public List<Chatic> getAllChats() {
        return chaticRepository.findAll();
    }

    public Chatic saveChatic(Chatic chatic) {
        return chaticRepository.save(chatic);
    }
}
