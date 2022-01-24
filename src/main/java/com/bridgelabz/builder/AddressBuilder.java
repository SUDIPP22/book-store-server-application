package com.bridgelabz.builder;

import com.bridgelabz.dto.AddressDto;
import com.bridgelabz.model.Address;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AddressBuilder {
    public Address addressBuildEntity(AddressDto addressDto, Address address){
        BeanUtils.copyProperties(addressDto,address);
        return address;
    }
}
