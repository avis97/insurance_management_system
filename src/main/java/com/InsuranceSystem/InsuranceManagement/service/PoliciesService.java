package com.InsuranceSystem.InsuranceManagement.service;

import com.InsuranceSystem.InsuranceManagement.Converter.PoliciesConverter;
import com.InsuranceSystem.InsuranceManagement.DTOs.*;
import com.InsuranceSystem.InsuranceManagement.Exception.PoliciesNotFoundException;
import com.InsuranceSystem.InsuranceManagement.Models.Client;
import com.InsuranceSystem.InsuranceManagement.Models.Policies;
import com.InsuranceSystem.InsuranceManagement.Repository.ClientRepository;
import com.InsuranceSystem.InsuranceManagement.Repository.PoliciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class PoliciesService{
    @Autowired
    PoliciesRepository policiesRepository;
    @Autowired
    ClientRepository clientRepository;
    public PoliciesResponseDto addPolicies(PoliciesRequestDto policiesRequestDto) throws Exception {
        Client client;
        try{
            client = clientRepository.findById(policiesRequestDto.getClientId()).get();
        }
        catch(Exception e)
        {
            throw new ClassNotFoundException("!!Sorry Client are not valid");
        }
        Policies policies= PoliciesConverter.PoliciesRequestDtoTopolicies(policiesRequestDto);
        policies.setClient(client);

        List<Policies> policiesList=client.getPoliciesList();
        policiesList.add(policies);

        clientRepository.save(client);
        PoliciesResponseDto policiesResponseDto=PoliciesConverter.policiesResponseDtoToPolicies(policies);

        return policiesResponseDto;
    }
    public PoliciesResponseDtoForAllDetails getDetailsById(PoliciesRequestDtoById id){
        //find the policies by id...
        Policies policies=policiesRepository.findById(id.getPoliciesId()).get();

        //convert policies to response dto...
        PoliciesResponseDtoForAllDetails details=PoliciesConverter.policesToAllDetailsResponseDto(policies);
        return details;
    }

    public String deletePoliciesById(PoliciesRequestDtoById id){
        Policies policies=policiesRepository.findById(id.getPoliciesId()).get();

        policiesRepository.delete(policies);
        String policyNumber=policies.getNumber();

        return policyNumber+" This policies are deleted successFully";
    }

    public PoliciesResponseDtoForAllDetails upDatePolicesDetailsById(PoliciesRequestDtoForUpdate id) throws PoliciesNotFoundException {
        Policies policies;
        try {
            policies = policiesRepository.findById(id.getPoliciesId()).get();
        }
        catch(Exception e)
        {
            throw new PoliciesNotFoundException("Invalid id!!!");
        }
        //put the new value int the policies,,
        policies.setPoliciesAmount(id.getPoliciesAmount());
        policies.setPoliciesTiming(id.getPoliciesTiming());
        policies.setPoliciesType(id.getPoliciesType());
        policies.setEndDate(id.getEndDate());

         //save the new Policies;
         policiesRepository.save(policies);

        PoliciesResponseDtoForAllDetails allDetails=PoliciesConverter.policesToAllDetailsResponseDto(policies);
        return allDetails;
    }
    public List<PoliciesResponseDtoForAllDetails> getAllPolicies(){
        List<Policies> list=policiesRepository.findAll();
        List<PoliciesResponseDtoForAllDetails> ListPolicies=new ArrayList<>();
        for(Policies key:list)
        {
            PoliciesResponseDtoForAllDetails details=PoliciesConverter.policesToAllDetailsResponseDto(key);
            ListPolicies.add(details);
        }
        return ListPolicies;
    }
}
