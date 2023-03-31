package com.InsuranceSystem.InsuranceManagement.Controller;

import com.InsuranceSystem.InsuranceManagement.DTOs.*;
import com.InsuranceSystem.InsuranceManagement.Exception.ClientNotFoundException;
import com.InsuranceSystem.InsuranceManagement.Exception.PoliciesNotFoundException;
import com.InsuranceSystem.InsuranceManagement.service.PoliciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping("/")
public class PoliciesControl{
    @Autowired
    PoliciesService policiesService;
    @PostMapping("POST/api/policies")
    public ResponseEntity addPolicies(@RequestBody PoliciesRequestDto policiesRequestDto) throws Exception {
        PoliciesResponseDto policiesResponseDto;
        try {
            policiesResponseDto = policiesService.addPolicies(policiesRequestDto);
        }
        catch(ClientNotFoundException e)
        {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(policiesResponseDto,HttpStatus.ACCEPTED);
    }
    @GetMapping("GET/api/policies/{id}")
    public PoliciesResponseDtoForAllDetails getDetailsById(@RequestBody PoliciesRequestDtoById id)
    {
        return policiesService.getDetailsById(id);
    }
    @DeleteMapping("DELETE/api/policies/{id}")
    public String deletePoliciesById(@RequestBody PoliciesRequestDtoById id)
    {
        return policiesService.deletePoliciesById(id);
    }
    @PutMapping("PUT/api/policies/{id}")
    public ResponseEntity upDatePolicesDetailsById(@RequestBody PoliciesRequestDtoForUpdate id){
        PoliciesResponseDtoForAllDetails details;
        try{
            details=policiesService.upDatePolicesDetailsById(id);
        }
        catch(PoliciesNotFoundException e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(details,HttpStatus.ACCEPTED);
    }
    @GetMapping("GET/api/policies")
    public List<PoliciesResponseDtoForAllDetails> getAllPolicies()
    {
        return policiesService.getAllPolicies();
    }
}
