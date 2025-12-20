package com.example.accioShop.dto.response;

import lombok.*;
import com.example.accioShop.enums.OrderStatus;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder



public class OrderResponse {

    String id;


    int value;


    OrderStatus status;
}
