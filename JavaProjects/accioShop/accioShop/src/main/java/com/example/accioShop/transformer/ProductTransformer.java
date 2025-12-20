package com.example.accioShop.transformer;

import com.example.accioShop.dto.request.ProductRequest;
import com.example.accioShop.dto.response.ProductResponse;
import com.example.accioShop.model.Product;

import lombok.experimental.UtilityClass;

import java.util.ArrayList;


@UtilityClass
public class ProductTransformer {

    public static Product ProductRequestToProduct(ProductRequest productRequest){
        Product product = Product.builder().name(productRequest.getName())
                .price(productRequest.getPrice())
                .category(productRequest.getCategory())
                .reviews(new ArrayList<>())
                .orders(new ArrayList<>())
                .build();
        return product;
    }

    public static ProductResponse productToProductResponse(Product product){

        ProductResponse productResponse = ProductResponse.builder()
                .name(product.getName())
                .price(product.getPrice())
                .category(product.getCategory())
                .sellerResponse(SellerTransformer.sellerToSellerResponse(product.getSeller()))
                .build();
        return productResponse;

    }

}
