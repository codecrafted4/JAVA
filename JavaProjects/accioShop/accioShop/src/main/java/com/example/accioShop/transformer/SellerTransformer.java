package com.example.accioShop.transformer;

import com.example.accioShop.dto.response.SellerResponse;
import com.example.accioShop.model.Seller;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SellerTransformer {
    public static SellerResponse sellerToSellerResponse(Seller seller){
        SellerResponse sellerResponse = SellerResponse.builder()
                .name(seller.getName())
                .email(seller.getEmail())
                .build();
        return sellerResponse;
    }
}
