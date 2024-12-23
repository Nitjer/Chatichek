package com.example.chatichek.controller;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // Изменили аннотацию на @Controller
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "home"; // Возвращаем имя HTML-файла (home.html) без расширения
    }
//    @GetMapping("/home")
//    public String homePage() {
//        return "home";
//    }
@GetMapping
public String chatPage(@RequestParam(value = "chatId", required = false) Integer chatId,
                       Model model, HttpSession session) {
    // Логика загрузки данных
    return "chat"; // Имя файла chat.html
}
}