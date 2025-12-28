package com.example.Hello.models;

import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.User;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Message {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sender_id",nullable = false)
    private Users sender;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "receiver_id",nullable = false)
    private Users receiver;

    @Column(nullable = false)
    private String content;

    @Column
    @CreationTimestamp
    private Date timestamp;
}
