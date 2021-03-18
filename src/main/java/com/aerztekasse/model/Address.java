package com.aerztekasse.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Address {
    private String streetName;
    private String streetNo;
    private String city;
    private int zipCode;
    private String state;
    private String country;
}
