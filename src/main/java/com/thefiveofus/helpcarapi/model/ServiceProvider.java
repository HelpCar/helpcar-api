package com.thefiveofus.helpcarapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(value = "service-provider")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ServiceProvider {
    @Id
    private String id;
    private String fullName;
    private String email;
    private String imgUrl;
    private String serviceCenter;

}

