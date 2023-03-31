package com.InsuranceSystem.InsuranceManagement.DTOs;

import com.InsuranceSystem.InsuranceManagement.Enum.PoliciesType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PoliciesResponseDto{
    private String PoliciesNumber;
    private PoliciesType policiesType;
    private int ClientId;
}
