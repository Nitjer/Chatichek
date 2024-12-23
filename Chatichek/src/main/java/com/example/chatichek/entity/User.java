package com.example.chatichek.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "\"User\"")
public class User {

    @Id
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "login", nullable = false, unique = true)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "admin", nullable = false)
    private Boolean admin = false;

    @Column(name = "nickname", nullable = false, unique = true)
    private String nickname;

    @OneToMany(mappedBy = "sender")
    private List<Message> messages;

    @ManyToMany(mappedBy = "users")
    private List<Chatic> chats;


    // Геттеры и сеттеры


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Chatic> getChats() {
        return chats;
    }

    public void setChats(List<Chatic> chats) {
        this.chats = chats;
    }

    public boolean isRole() {
        return Boolean.TRUE.equals(admin);
    }
}
