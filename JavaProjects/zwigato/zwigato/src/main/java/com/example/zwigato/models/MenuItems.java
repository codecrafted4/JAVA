package com.example.zwigato.models;

import com.example.zwigato.utility.enums.FoodCategory;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private int price;

    @Column(nullable = false)
    private String name;


    @Enumerated(EnumType.STRING)
    @Column
    private FoodCategory category;

    @Column(columnDefinition = "TINYINT(1) DEFAULT 0")
    private boolean vegOrNon;

    @OneToMany(mappedBy = "menuItem")
    @JsonIgnore
    List<OrderItems> orders;

    @ManyToMany
    private List<Restaurant> restaurants;
}
