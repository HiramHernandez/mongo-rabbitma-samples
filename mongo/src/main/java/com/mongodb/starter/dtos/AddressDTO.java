package com.mongodb.starter.dtos;

import com.mongodb.starter.models.Address;

public record AddressDTO(int number, String street, String postcode, String city, String country) {
    public AddressDTO(Address a){
        this(a.getNumber(), a.getStreet(), a.getPostcode(), a.getCity(), a.getCountry());
    }

    public Address toAddressModel(){
        return new Address(number, street, postcode, city, country);
    }
}
