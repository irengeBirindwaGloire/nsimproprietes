package com.nsim.snimproprietes.dto;

import com.nsim.snimproprietes.models.Client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {

    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;

    public static ClientDto fromEntity(Client client) {

        return ClientDto.builder()
                .id(client.getId())
                .nom(client.getNom())
                .prenom(client.getPrenom())
                .email(client.getEmail())
                .telephone(client.getTelephone())
                .build();
    }

    public static Client toEntity(ClientDto clientDto) {

        return Client.builder()
                .id(clientDto.getId())
                .nom(clientDto.getNom())
                .prenom(clientDto.getPrenom())
                .email(clientDto.getEmail())
                .telephone(clientDto.getTelephone())
                .build();
    }
}
