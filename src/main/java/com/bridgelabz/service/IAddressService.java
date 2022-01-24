package com.bridgelabz.service;

import com.bridgelabz.dto.AddressDto;
import com.bridgelabz.dto.ResponseDTO;
import com.bridgelabz.model.Address;

import java.util.List;

public interface IAddressService {

    List<Address> getAllAddress();

    public ResponseDTO addAddress(AddressDto addressDto);

    public Address findAddressById(int id);

    public ResponseDTO updateAddress(int id, AddressDto addressDto);

}
