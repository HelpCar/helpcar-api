package com.thefiveofus.helpcarapi.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "vehicle")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Vehicle {
    @Id
    private String id;
    private String type;
    private String manufacture;
    private String model;
    private String manufacturedYear;
    private String powerSource;
    private String transmission;
    private String userEmail;

}
