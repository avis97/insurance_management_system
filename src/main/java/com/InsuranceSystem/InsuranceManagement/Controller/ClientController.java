package com.InsuranceSystem.InsuranceManagement.Controller;

import com.InsuranceSystem.InsuranceManagement.DTOs.ClientRequestDto;
import com.InsuranceSystem.InsuranceManagement.DTOs.ClientRequestDtoById;
import com.InsuranceSystem.InsuranceManagement.DTOs.ClientRequestDtoForUpdate;
import com.InsuranceSystem.InsuranceManagement.DTOs.ClientResponseDto;
import com.InsuranceSystem.InsuranceManagement.Models.Client;
import com.InsuranceSystem.InsuranceManagement.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping("/")
public class ClientController{
    @Autowired
    ClientService clientService;
    @PostMapping("POST/api/clients")
    private ClientResponseDto addClient(@RequestBody ClientRequestDto clientRequestDto)
    {
      return clientService.addClient(clientRequestDto);
    }
    @GetMapping("GET/api/clients/{id}")
    private ClientResponseDto getClientById(@RequestBody ClientRequestDtoById id)
    {
        return clientService.getClientById(id);
    }
    @PutMapping("PUT/api/clients/{id}")
    private ClientResponseDto updateClintEmailById(@RequestBody ClientRequestDtoForUpdate id)
    {
        return clientService.updateClintEmailById(id);
    }
    @GetMapping("GET/api/clients")
    public List<ClientResponseDto> findAllClient()
    {
        return clientService.findAllClient();
    }
    @DeleteMapping("DELETE/api/clients/{id}")
    private String deleteClientById(@RequestBody ClientRequestDtoById id)
    {
        return clientService.deleteClientById(id);
    }
}
