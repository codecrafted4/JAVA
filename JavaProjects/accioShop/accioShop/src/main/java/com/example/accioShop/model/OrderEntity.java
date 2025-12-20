package com.example.accioShop.model;

import com.example.accioShop.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column
    private String id;

    @Column
    private int value;

    @Column
    @Enumerated(value = EnumType.STRING)
    private OrderStatus status;

    @ManyToMany
    @JoinTable
    List<Product> products = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "customer_id")
    Customer customer;
}
