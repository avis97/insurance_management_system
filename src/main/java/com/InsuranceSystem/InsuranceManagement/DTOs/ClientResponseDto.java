package com.InsuranceSystem.InsuranceManagement.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientResponseDto{
    private String ClientName;
    private int ClientId;
    private String ClientEmail;
}
