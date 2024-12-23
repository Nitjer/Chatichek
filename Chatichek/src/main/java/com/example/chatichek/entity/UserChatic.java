package com.example.chatichek.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "User_Chatic")
public class UserChatic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "User_user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "Chatic_chat_id", nullable = false)
    private Chatic chatic;

    // Геттеры и сеттеры
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Chatic getChatic() {
        return chatic;
    }

    public void setChatic(Chatic chatic) {
        this.chatic = chatic;
    }
}
