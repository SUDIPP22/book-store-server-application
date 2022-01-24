package com.bridgelabz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    @Pattern(regexp = "^[a-zA-Z]{2,}$", message = "Name is Invalid")
    private String name;

    @Pattern(regexp = "^[a-zA-Z]{2,}$", message = "City is Invalid")
    private String city;

    @Pattern(regexp = "^[a-zA-Z]{2,}$", message = "State is Invalid")
    private String state;

    @Pattern(regexp = "^[0-9]{2,}$", message = "Zip is Invalid")
    private String zip;

    @Pattern(regexp = "^[0-9]{2,}$", message = "PhoneNumber is Invalid")
    private String phoneNumber;

    @Pattern(regexp = "[\\w\\s]+", message = "Address is Invalid")
    private String address;

    @Pattern(regexp = "[\\w\\s]+", message = "Landmark is Invalid")
    private String landmark;

    private String type;
}
