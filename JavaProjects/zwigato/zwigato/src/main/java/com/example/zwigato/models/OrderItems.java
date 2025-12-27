package com.example.zwigato.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItems {
    @Id
    @Column
    private String id;

    @Column
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    OrderEntity orderEntity;

    @ManyToOne
    @JoinColumn(name = "menu-items_id")
    MenuItems menuItem;


}
