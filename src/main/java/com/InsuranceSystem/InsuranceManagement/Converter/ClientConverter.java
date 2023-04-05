package com.InsuranceSystem.InsuranceManagement.Converter;

import com.InsuranceSystem.InsuranceManagement.DTOs.ClientRequestDto;
import com.InsuranceSystem.InsuranceManagement.DTOs.ClientResponseDto;
import com.InsuranceSystem.InsuranceManagement.Models.Client;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ClientConverter{
    public static Client clientRequestDtoToClient(ClientRequestDto clientDto)
    {
        return Client.builder()
                .clientName(clientDto.getName())
                .clientEmail(clientDto.getEmail())
                .clientDob(clientDto.getDate_Of_birth())
                .phoneNumber(clientDto.getPhoneNumber())
                .build();
    }
    public static ClientResponseDto clientToclientResponseDto(Client client)
    {
        return ClientResponseDto.builder()
                .ClientEmail(client.getClientEmail())
                .ClientName(client.getClientName())
                .ClientId(client.getClientId())
                .PhoneNumber(client.getPhoneNumber())
                .build();
    }
}
