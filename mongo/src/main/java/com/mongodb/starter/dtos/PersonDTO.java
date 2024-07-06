package com.mongodb.starter.dtos;

import com.mongodb.starter.models.Car;
import com.mongodb.starter.models.Person;
import org.bson.types.ObjectId;

import java.util.Date;
import java.util.List;

public record PersonDTO(
        String id,
        String firstName,
        String lastName,
        int age,
        AddressDTO address,
        Date createdAt,
        Boolean insurance,
        List<CarDTO> cars)
{
    public PersonDTO(Person p) {
        this(p.getId() == null ? new ObjectId().toHexString() : p.getId().toHexString(), p.getFirstName(),
                p.getLastName(), p.getAge(), new AddressDTO(p.getAddress()), p.getCreatedAt(), p.getInsurance(),
                p.getCars().stream().map(CarDTO::new).toList());
    }

    public Person toPersonModel() {
        ObjectId _id = id == null ? new ObjectId() : new ObjectId(id);
        return new Person(_id, firstName, lastName, age, address.toAddressModel(), createdAt, insurance,
                cars.stream().map(CarDTO::toCarModel).toList());
    }

}
