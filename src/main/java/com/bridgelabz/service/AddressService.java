package com.bridgelabz.service;

import com.bridgelabz.builder.AddressBuilder;
import com.bridgelabz.dto.AddressDto;
import com.bridgelabz.dto.ResponseDTO;
import com.bridgelabz.exception.custom.BookStoreCustomException;
import com.bridgelabz.model.Address;
import com.bridgelabz.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class AddressService implements IAddressService{

    private static final String ADDRESS_ADDED = "Book details are added successfully";
    private static final String ADDRESS_UPDATED = "Address Book is Updated Successfully";;
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddressBuilder addressBuilder;


    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }

    public ResponseDTO addAddress(AddressDto addressDto) {
        Address address = new Address();
        address = addressBuilder.addressBuildEntity(addressDto, address);
        addressRepository.save(address);
        return new ResponseDTO(HttpStatus.CREATED, ADDRESS_ADDED);
    }

    public Address findAddressById(int id) {
        return addressRepository.findById(id).
                orElseThrow(() -> new BookStoreCustomException("Address data not found of this id :" + id));
    }

    public ResponseDTO updateAddress(int id, AddressDto addressDto) {
        Address address = findAddressById(id);
        address = addressBuilder.addressBuildEntity(addressDto, address);
        addressRepository.save(address);
        return new ResponseDTO(HttpStatus.OK, ADDRESS_UPDATED);
    }
}


