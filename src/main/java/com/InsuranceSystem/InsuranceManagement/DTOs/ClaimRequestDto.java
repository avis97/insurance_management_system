package com.InsuranceSystem.InsuranceManagement.DTOs;

import com.InsuranceSystem.InsuranceManagement.Enum.ClaimStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClaimRequestDto{
    private String claimNumber;
    private String claimDetails;
    private String claimDate;
    private int policiesId;
}
