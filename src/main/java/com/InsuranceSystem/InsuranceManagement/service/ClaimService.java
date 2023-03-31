package com.InsuranceSystem.InsuranceManagement.service;
import com.InsuranceSystem.InsuranceManagement.Converter.ClaimConverter;
import com.InsuranceSystem.InsuranceManagement.DTOs.ClaimRequestDto;
import com.InsuranceSystem.InsuranceManagement.DTOs.ClaimRequestDtoById;
import com.InsuranceSystem.InsuranceManagement.DTOs.ClaimRequestDtoForUpdate;
import com.InsuranceSystem.InsuranceManagement.DTOs.ClaimResponseDto;
import com.InsuranceSystem.InsuranceManagement.Exception.PoliciesNotFoundException;
import com.InsuranceSystem.InsuranceManagement.Models.Claim;
import com.InsuranceSystem.InsuranceManagement.Models.Policies;
import com.InsuranceSystem.InsuranceManagement.Repository.ClaimRepository;
import com.InsuranceSystem.InsuranceManagement.Repository.ClientRepository;
import com.InsuranceSystem.InsuranceManagement.Repository.PoliciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class ClaimService{
    @Autowired
    PoliciesRepository policiesRepository;
    @Autowired
    ClaimRepository claimRepository;
    public ClaimResponseDto addClaim(ClaimRequestDto claimRequestDto) throws PoliciesNotFoundException{
        Policies policies;
        try {
            policies = policiesRepository.findById(claimRequestDto.getPoliciesId()).get();
        }
        catch(Exception e)
        {
            throw new PoliciesNotFoundException("Dont Have The Policies In our service!!!");
        }
        Claim claim= ClaimConverter.claimRequestDtoToClaim(claimRequestDto);
        claim.setPolicies(policies);

        List<Claim> claimList=policies.getClaimList();
        claimList.add(claim);

        policiesRepository.save(policies);
        //make claim to responseDto..
        ClaimResponseDto claimResponseDto=ClaimConverter.claimtoClaimresponseDto(claim);
        return claimResponseDto;
    }

    public ClaimResponseDto getClaimById(ClaimRequestDtoById id) throws Exception {
         Claim claim;
         try {
             claim = claimRepository.findById(id.getClaimId()).get();
         }
         catch(Exception e)
         {
             throw new Exception("InValid id!!");
         }

         ClaimResponseDto responseDto=ClaimConverter.claimtoClaimresponseDto(claim);
         return responseDto;
    }

    public String deleteClaimById(ClaimRequestDtoById id){
        Claim claim=claimRepository.findById(id.getClaimId()).get();

        claimRepository.delete(claim);

        String number=claim.getClaimNumber();

        return number+" This number Claim Is Deleted Done.";
    }
    public ClaimResponseDto updateClaimById(ClaimRequestDtoForUpdate id){
        Claim claim=claimRepository.findById(id.getClaimId()).get();
        claim.setClaimDetails(id.getClaimDetails());
        claim.setClaimStatus(id.getClaimStatus());
        claim.setClaimDate(id.getDate());

        Claim newClaim=claimRepository.save(claim);

        ClaimResponseDto responseDto=ClaimConverter.claimtoClaimresponseDto(newClaim);
        return responseDto;
    }

    public List<ClaimResponseDto> getAllClaim(){

        List<Claim> claimList=claimRepository.findAll();
        List<ClaimResponseDto> allList=new ArrayList<>();
        for(Claim key:claimList)
        {
            ClaimResponseDto responseDto=ClaimConverter.claimtoClaimresponseDto(key);
            allList.add(responseDto);
        }
        return allList;
    }
}
