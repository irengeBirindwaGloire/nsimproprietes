package com.nsim.snimproprietes.dto;

import java.util.Date;

import com.nsim.snimproprietes.enums.EtatLoyer;
import com.nsim.snimproprietes.enums.StatusLoyer;
import com.nsim.snimproprietes.models.Allouer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AllouerDto {

    private Long id;
    private ProprieteDto proprietaire;
    private ClientDto client;
    private Date dateDebut;
    private Date dateFin;
    private Double montantLoyer;
    private StatusLoyer statutLoyer;
    private EtatLoyer etatLoyer;
    private String modePaiement;

    public static AllouerDto fromEntity(Allouer allouer) {

        return AllouerDto.builder()
                .id(allouer.getId())
                .proprietaire(ProprieteDto.fromEntity(allouer.getProprietaire()))
                .client(ClientDto.fromEntity(allouer.getClient()))
                .dateDebut(allouer.getDateDebut())
                .dateFin(allouer.getDateFin())
                .montantLoyer(allouer.getMontantLoyer())
                .statutLoyer(allouer.getStatutLoyer())
                .etatLoyer(allouer.getEtatLoyer())
                .modePaiement(allouer.getModePaiement())
                .build();
    }
    
    public static Allouer toEntity(AllouerDto allouerDto) {

        return Allouer.builder()
                .id(allouerDto.getId())
                .proprietaire(ProprieteDto.toEntity(allouerDto.getProprietaire()))
                .client(ClientDto.toEntity(allouerDto.getClient()))
                .dateDebut(allouerDto.getDateDebut())
                .dateFin(allouerDto.getDateFin())
                .montantLoyer(allouerDto.getMontantLoyer())
                .statutLoyer(allouerDto.getStatutLoyer())
                .etatLoyer(allouerDto.getEtatLoyer())
                .modePaiement(allouerDto.getModePaiement())
                .build();
    }   
}
