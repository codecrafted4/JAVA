package com.example.accioShop.dto.request;

import com.example.accioShop.enums.Category;
import jakarta.persistence.*;
import lombok.*;

import java.util.Locale;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ProductRequest {

    private String name;

    private int price;

    Category category;
}
