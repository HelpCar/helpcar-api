package com.thefiveofus.helpcarapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "service-center")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ServiceCenter {
    @Id
    private String id;
    private String serviceCenterName;
    private String address;
    private String descOfBusiness;
    private String businessRegCertUrl;
}
