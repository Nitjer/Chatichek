//package com.example.chatichek.entity;
//
//import jakarta.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name = "Chatic")
//public class Chatic {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "chat_id")
//    private Integer chatId;
//
//    @Column(name = "chat_name", nullable = false)
//    private String chatName;
//
//    @OneToMany(mappedBy = "chat")
//    private List<Message> messages;
//
//    @ManyToMany
//    @JoinTable(
//            name = "User_Chatic",
//            joinColumns = @JoinColumn(name = "Chatic_chat_id"),
//            inverseJoinColumns = @JoinColumn(name = "User_user_id")
//    )
//    private List<User> users;
//
//    // Геттеры и сеттеры
//    public Integer getChatId() {
//        return chatId;
//    }
//
//    public void setChatId(Integer chatId) {
//        this.chatId = chatId;
//    }
//
//    public String getChatName() {
//        return chatName;
//    }
//
//    public void setChatName(String chatName) {
//        this.chatName = chatName;
//    }
//
//    public List<Message> getMessages() {
//        return messages;
//    }
//
//    public void setMessages(List<Message> messages) {
//        this.messages = messages;
//    }
//
//    public List<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(List<User> users) {
//        this.users = users;
//    }
//}
//

package com.example.chatichek.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "chatic")
public class Chatic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_id")
    private Integer chatId;

    @Column(name = "chat_name", nullable = false)
    private String chatName;

    @OneToMany(mappedBy = "chat", fetch = FetchType.LAZY)
    private List<Message> messages;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_chatic",
            joinColumns = @JoinColumn(name = "chatic_chat_id"),
            inverseJoinColumns = @JoinColumn(name = "user_user_id")
    )
    private List<User> users;

    // Геттеры и сеттеры
    public Integer getChatId() {
        return chatId;
    }

    public void setChatId(Integer chatId) {
        this.chatId = chatId;
    }

    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
