package com.example.zwigato.utility.transformers;

import com.example.zwigato.dto.request.AddressRequest;
import com.example.zwigato.dto.response.AddressResponse;
import com.example.zwigato.dto.response.CustomerResponse;
import com.example.zwigato.models.Address;

public class AddressTransformer {

    public static Address addressRequestToAddress(AddressRequest addressRequest){
        return Address.builder()
                .city(addressRequest.getCity())
                .house_No(addressRequest.getHouse_No())
                .pinCode(addressRequest.getPinCode())
                .state(addressRequest.getState())
                .build();
    }
    public static AddressResponse addressToAddressResponse(Address address)
    {
        return AddressResponse.builder()
                .city(address.getCity())
                .state(address.getState())
                .house_No(address.getHouse_No())
                .pinCode(address.getPinCode())
                .build();
    }
}
