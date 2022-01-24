package com.bridgelabz.controller;

import com.bridgelabz.dto.AddressDto;
import com.bridgelabz.dto.BookDetailsDTO;
import com.bridgelabz.dto.ResponseDTO;
import com.bridgelabz.model.Address;
import com.bridgelabz.model.Book;
import com.bridgelabz.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping(value = "/list")
    public ResponseEntity<List<Address>>getAllAddress(){
        return new ResponseEntity<>( addressService.getAllAddress(), HttpStatus.OK);
    }

    @PostMapping(value="/create")
    public ResponseEntity<ResponseDTO> addAddress(@Valid
                                                 @RequestBody AddressDto addressDto){
    return new ResponseEntity<>(addressService.addAddress(addressDto),HttpStatus.CREATED);
    }

    @PutMapping(value="/update/{id}")
    public ResponseEntity<ResponseDTO> updateAddress(
            @PathVariable int id,
            @RequestBody AddressDto addressDto){
        return new ResponseEntity<>(addressService.updateAddress(id,addressDto),HttpStatus.OK);
    }

}
