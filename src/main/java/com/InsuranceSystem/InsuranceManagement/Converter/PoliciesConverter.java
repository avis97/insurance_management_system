package com.InsuranceSystem.InsuranceManagement.Converter;

import com.InsuranceSystem.InsuranceManagement.DTOs.PoliciesRequestDto;
import com.InsuranceSystem.InsuranceManagement.DTOs.PoliciesRequestDtoForUpdate;
import com.InsuranceSystem.InsuranceManagement.DTOs.PoliciesResponseDto;
import com.InsuranceSystem.InsuranceManagement.DTOs.PoliciesResponseDtoForAllDetails;
import com.InsuranceSystem.InsuranceManagement.Models.Policies;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PoliciesConverter{

    public static Policies PoliciesRequestDtoTopolicies(PoliciesRequestDto policiesRequestDto)
    {
        return Policies.builder()
                .number(policiesRequestDto.getNumber())
                .policiesType(policiesRequestDto.getPoliciesType())
                .policiesAmount(policiesRequestDto.getAmount())
                .policiesTiming(policiesRequestDto.getTiming())
                .endDate(policiesRequestDto.getEndDate())
                .build();
    }
    public static PoliciesResponseDto policiesResponseDtoToPolicies(Policies policies)
    {
        return PoliciesResponseDto.builder()
                .PoliciesNumber(policies.getNumber())
                .policiesType(policies.getPoliciesType())
                .ClientId(policies.getClient().getClientId())
                .build();
    }
    public static PoliciesResponseDtoForAllDetails policesToAllDetailsResponseDto(Policies policies)
    {
        return PoliciesResponseDtoForAllDetails.builder()
                .endDate(policies.getEndDate())
                .startDate(policies.getStartDate())
                .policiesTiming(policies.getPoliciesTiming())
                .policiesAmount(policies.getPoliciesAmount())
                .clientId(policies.getClient().getClientId())
                .policiesType(policies.getPoliciesType())
                .number(policies.getNumber())
                .build();
    }

//    public static Policies PoliciesRequestDtoForUpdateToPolicies(PoliciesRequestDtoForUpdate update)
//    {
//        return Policies.builder()
//                //.number(update.getNumber())
//                .policiesType(update.getPoliciesType())
//                .policiesTiming(update.getPoliciesTiming())
//                .endDate(update.getEndDate())
//                .policiesAmount(update.getPoliciesAmount())
//                .build();
//    }
}
