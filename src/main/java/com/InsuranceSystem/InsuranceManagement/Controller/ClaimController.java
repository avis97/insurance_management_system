package com.InsuranceSystem.InsuranceManagement.Controller;
import java.util.*;
import com.InsuranceSystem.InsuranceManagement.DTOs.ClaimRequestDto;
import com.InsuranceSystem.InsuranceManagement.DTOs.ClaimRequestDtoById;
import com.InsuranceSystem.InsuranceManagement.DTOs.ClaimRequestDtoForUpdate;
import com.InsuranceSystem.InsuranceManagement.DTOs.ClaimResponseDto;
import com.InsuranceSystem.InsuranceManagement.Exception.PoliciesNotFoundException;
import com.InsuranceSystem.InsuranceManagement.service.ClaimService;
import com.InsuranceSystem.InsuranceManagement.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class ClaimController{
    @Autowired
    ClaimService claimService;
    @PostMapping("POST/api/claims")
    private ResponseEntity addClaim(@RequestBody ClaimRequestDto claimRequestDto){
        ClaimResponseDto claimResponseDto;
        try {
          claimResponseDto=claimService.addClaim(claimRequestDto);
        }
        catch(PoliciesNotFoundException e)
        {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(claimResponseDto,HttpStatus.ACCEPTED);
    }
    @GetMapping("GET/api/claims/{id}")
    private ResponseEntity getClaimById(@RequestBody ClaimRequestDtoById id)
    {
        ClaimResponseDto claimResponseDto;
        try
        {
            claimResponseDto=claimService.getClaimById(id);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(claimResponseDto,HttpStatus.ACCEPTED);
    }
    @DeleteMapping("DELETE/api/claims/{id}")
    private String deleteClaimById(@RequestBody ClaimRequestDtoById id)
    {
        return claimService.deleteClaimById(id);
    }
    @PutMapping("PUT/api/claims/{id}")
    private ClaimResponseDto updateClaimById(@RequestBody ClaimRequestDtoForUpdate id)
    {
        return claimService.updateClaimById(id);
    }
    @GetMapping("GET/api/claims")
    private List<ClaimResponseDto> getAllClaim()
    {
        return claimService.getAllClaim();
    }
}
