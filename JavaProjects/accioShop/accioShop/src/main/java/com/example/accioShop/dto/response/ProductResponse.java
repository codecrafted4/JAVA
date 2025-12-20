package com.example.accioShop.dto.response;

import com.example.accioShop.enums.Category;
import com.example.accioShop.model.Seller;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ProductResponse {
    private String name;
    private int price;
    private Category category;
    private SellerResponse sellerResponse;

}
