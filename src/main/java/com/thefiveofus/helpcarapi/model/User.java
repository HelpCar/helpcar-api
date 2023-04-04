package com.thefiveofus.helpcarapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "user")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class User {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String mobileNo;
}