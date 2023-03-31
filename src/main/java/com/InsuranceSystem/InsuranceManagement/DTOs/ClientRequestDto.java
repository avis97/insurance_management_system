package com.InsuranceSystem.InsuranceManagement.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientRequestDto{
    private String name;
    private String email;
    private String date_Of_birth;

}
