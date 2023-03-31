package com.InsuranceSystem.InsuranceManagement.Converter;


import com.InsuranceSystem.InsuranceManagement.DTOs.ClaimRequestDto;
import com.InsuranceSystem.InsuranceManagement.DTOs.ClaimResponseDto;
import com.InsuranceSystem.InsuranceManagement.Enum.ClaimStatus;
import com.InsuranceSystem.InsuranceManagement.Models.Claim;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ClaimConverter {
    public static Claim claimRequestDtoToClaim(ClaimRequestDto claimRequestDto)
    {
        return Claim.builder()
                .claimNumber(claimRequestDto.getClaimNumber())
                .claimDetails(claimRequestDto.getClaimDetails())
                .claimDate(claimRequestDto.getClaimDate())
                .claimStatus(ClaimStatus.ACTIVATED)
                .build();
    }
    public static ClaimResponseDto claimtoClaimresponseDto(Claim claim)
    {
        return ClaimResponseDto.builder()
                .claimNumber(claim.getClaimNumber())
                .claimDetails(claim.getClaimDetails())
                .policiesId(claim.getPolicies().getPoliciesId())
                .claimStatus(claim.getClaimStatus())
                .claimDate(claim.getClaimDate())
                .claimId(claim.getClaimId())
                .build();
    }
}
