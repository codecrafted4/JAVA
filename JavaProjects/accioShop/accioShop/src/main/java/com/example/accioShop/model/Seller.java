package com.example.accioShop.model;

import com.example.accioShop.enums.Gender;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jdk.jfr.Category;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Column(length = 10,unique = true)
    private String pan;

    @Column
    private double rating;

    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "seller",cascade = CascadeType.ALL)
    @JsonIgnore
    List<Product> products = new ArrayList<>();





}
