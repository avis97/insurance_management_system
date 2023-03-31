package com.InsuranceSystem.InsuranceManagement.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientRequestDtoForUpdate{
    private int clientId;
    private String newEmail;
}
