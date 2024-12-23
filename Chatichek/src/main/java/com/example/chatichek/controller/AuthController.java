package com.example.chatichek.controller;
import com.example.chatichek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.chatichek.repository.UserRepository;
import com.example.chatichek.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;

import java.util.Optional;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository; // Репозиторий для работы с БД

    @Autowired
    private UserService userService; // Репозиторий для работы с БД

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Возвращаем страницу логина
    }

    @PostMapping("/login")
    public String login(@RequestParam String login,
                        @RequestParam String password,
                        Model model,
                        HttpSession session) {
        System.out.println(login);
        // Поиск пользователя в базе данных
        User user = userService.findByLoginAndPassword(login,password);

        if (user != null) {
            // Успешная аутентификация
            session.setAttribute("user", user); // Сохраняем пользователя в сессии
            return "redirect:/home";           // Перенаправляем на home
        } else {
            // Ошибка аутентификации
            model.addAttribute("error", "Неправильный логин или пароль!");
            return "login"; // Оставляем пользователя на странице логина
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Удаляем сессию
        return "redirect:/auth/login";
    }
}
