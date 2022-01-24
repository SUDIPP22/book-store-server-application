package com.bridgelabz.service;

import com.bridgelabz.builder.AddressBuilder;
import com.bridgelabz.builder.BookStoreBuilder;
import com.bridgelabz.dto.AddressDto;
import com.bridgelabz.exception.custom.BookStoreCustomException;
import com.bridgelabz.model.Address;
import com.bridgelabz.model.Book;
import com.bridgelabz.repository.AddressRepository;
import com.bridgelabz.repository.BookStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddressBuilder addressBuilder;

    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }

    public String addAddress(AddressDto addressDto) {
        Address address = new Address();
        address = addressBuilder.addressBuildEntity(addressDto, address);
        addressRepository.save(address);
        return "Address is added Successfully";
    }

    public Address findAddressById(int id) {
        return addressRepository.findById(id).
                orElseThrow(() -> new BookStoreCustomException("Address data not found of this id :" + id));
    }

    public String updateAddress(int id, AddressDto addressDto) {
        Address address = findAddressById(id);
        address = addressBuilder.addressBuildEntity(addressDto, address);
        addressRepository.save(address);
        return "Address Book is Updated Successfully";
    }
}


