//package com.example.chatichek.entity;
//
//import jakarta.persistence.*;
//import java.util.Date;
//
//@Entity
//@Table(name = "Message")
//public class Message {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "message_id")
//    private Integer messageId;
//
//    @Column(name = "message_text", nullable = false)
//    private String messageText;
//
//    @Column(name = "message_time", nullable = false)
//    @Temporal(TemporalType.DATE)
//    private Date messageTime;
//
//    @ManyToOne
//    @JoinColumn(name = "id_sender", nullable = false)
//    private User sender;
//
//    @ManyToOne
//    @JoinColumn(name = "id_chat", nullable = false)
//    private Chatic chat;
//
//    // Геттеры и сеттеры
//    public Integer getMessageId() {
//        return messageId;
//    }
//
//    public void setMessageId(Integer messageId) {
//        this.messageId = messageId;
//    }
//
//    public String getMessageText() {
//        return messageText;
//    }
//
//    public void setMessageText(String messageText) {
//        this.messageText = messageText;
//    }
//
//    public Date getMessageTime() {
//        return messageTime;
//    }
//
//    public void setMessageTime(Date messageTime) {
//        this.messageTime = messageTime;
//    }
//
//    public User getSender() {
//        return sender;
//    }
//
//    public void setSender(User sender) {
//        this.sender = sender;
//    }
//
//    public Chatic getChat() {
//        return chat;
//    }
//
//    public void setChatId_M(Chatic chat) {
//        this.chat = chat;
//    }
//
//    public void setIdSender(Integer senderId) {
//        this.sender = new User();
//        this.sender.setUserId(senderId);
//    }
//
//    public void setIdChat(Integer chat) {
//        this.chat = new Chatic();
//        this.chat.setChatId(chat);
//    }
//}

package com.example.chatichek.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private Integer messageId;

    @Column(name = "message_text", nullable = false)
    private String messageText;

    @Column(name = "message_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date messageTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sender", nullable = false)
    private User sender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_chat", nullable = false)
    private Chatic chat;

    // Геттеры и сеттеры
    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Date getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(Date messageTime) {
        this.messageTime = messageTime;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public Chatic getChat() {
        return chat;
    }

    public void setChat(Chatic chat) {
        this.chat = chat;
    }

    public void setIdSender(Integer senderId) {
        this.sender = new User();
        this.sender.setUserId(senderId);
    }

    public void setIdChat(Integer chat) {
        this.chat = new Chatic();
        this.chat.setChatId(chat);
    }
}
