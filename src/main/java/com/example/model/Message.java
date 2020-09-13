package com.example.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class  Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String text;
    private String tag;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    public Message() {
    }

    public Message(String text, String tag, User user) {
        this.text = text;
        this.tag = tag;
        this.author = user;
    }

    public String getAuthorName(){
        return author != null ?  author.getUsername() : "<none>";
    }
}
