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
public class ClaimRequestDtoForUpdate{
    private int claimId;
    private String claimDetails;
    private ClaimStatus claimStatus;
    private String date;
}
