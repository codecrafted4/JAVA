package com.example.zwigato.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String name;


    @Column
    private String location;

    @Column
    private boolean isOpen;

    @CreationTimestamp
    @Column
    Date registeredAt;

    @ManyToMany(mappedBy = "restaurants",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<MenuItems> menuItems;

}
