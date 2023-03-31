package com.InsuranceSystem.InsuranceManagement.service;

import com.InsuranceSystem.InsuranceManagement.Converter.ClientConverter;
import com.InsuranceSystem.InsuranceManagement.DTOs.ClientRequestDto;
import com.InsuranceSystem.InsuranceManagement.DTOs.ClientRequestDtoById;
import com.InsuranceSystem.InsuranceManagement.DTOs.ClientRequestDtoForUpdate;
import com.InsuranceSystem.InsuranceManagement.DTOs.ClientResponseDto;
import com.InsuranceSystem.InsuranceManagement.Exception.ClientNotFoundException;
import com.InsuranceSystem.InsuranceManagement.Models.Client;
import com.InsuranceSystem.InsuranceManagement.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.*;
@Service
public class ClientService{
    @Autowired
    ClientRepository clientRepository;
    public ClientResponseDto addClient(ClientRequestDto clientRequestDto){
        //convert dto to client;
         Client client= ClientConverter.clientRequestDtoToClient(clientRequestDto);
        //save the client;
        clientRepository.save(client);
        //make client response Dto
        ClientResponseDto clientResponseDto=ClientConverter.clientToclientResponseDto(client);
        return clientResponseDto;
    }
    public ClientResponseDto getClientById(ClientRequestDtoById id){

        Client client=clientRepository.findById(id.getClientId()).get();

        ClientResponseDto clientResponseDto=ClientConverter.clientToclientResponseDto(client);
        return clientResponseDto;
    }

    public String deleteClientById(ClientRequestDtoById id){

        Client client=clientRepository.findById(id.getClientId()).get();

        clientRepository.delete(client);

        String clientName=client.getClientName();
        return clientName+" This Client Deleted";
    }

    public ClientResponseDto updateClintEmailById(ClientRequestDtoForUpdate id){

        Client client=clientRepository.findById(id.getClientId()).get();
        client.setClientEmail(id.getNewEmail());

        clientRepository.save(client);

        ClientResponseDto clientResponseDto=ClientConverter.clientToclientResponseDto(client);

        return clientResponseDto;
    }
    public List<ClientResponseDto> findAllClient(){
        List<Client> list=clientRepository.findAll();
        List<ClientResponseDto> allist=new ArrayList<>();
        for(Client k:list)
        {
            ClientResponseDto clientResponseDto=ClientConverter.clientToclientResponseDto(k);
            allist.add(clientResponseDto);
        }
        return allist;
    }
}
