package com.example.zwigato.dto.response;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestaurantResponse {
    private String name;
    private String location;
    boolean isOpen;
    Date registeredAt;
}
