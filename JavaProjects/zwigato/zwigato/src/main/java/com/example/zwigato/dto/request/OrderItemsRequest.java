package com.example.zwigato.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class OrderItemsRequest {

    private int menuItemsId;

    private int quantity;

}
