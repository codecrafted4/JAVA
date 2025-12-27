package com.example.zwigato.dto.response;

import com.example.zwigato.models.MenuItems;
import com.example.zwigato.utility.enums.OrderStatus;
import lombok.*;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class OrderResponse {
    private String customerName;

    private int totalCost;

    private OrderStatus status;

    private Date createdAt;

    private List<String> name;


}
