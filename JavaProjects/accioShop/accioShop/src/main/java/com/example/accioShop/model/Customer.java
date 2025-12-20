package com.example.accioShop.model;

import com.example.accioShop.enums.Gender;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private int age;

    @Column(unique = true,nullable = false)
    @Email
    private String email;

    @Column
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(length = 10)
    private String mobNum;

    @CreationTimestamp
    Date createdAt;

//    @OneToOne(mappedBy = "customer")
//    Address address;
//    for bidirectional

    @OneToMany(mappedBy = "customer")
    @JsonBackReference
    List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    List<OrderEntity> orderEntities = new ArrayList<>();



}
