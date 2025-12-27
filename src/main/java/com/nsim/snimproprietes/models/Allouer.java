package com.nsim.snimproprietes.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.nsim.snimproprietes.enums.EtatLoyer;
import com.nsim.snimproprietes.enums.StatusLoyer;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.Instant;
import java.util.Date;

@jakarta.persistence.Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@jakarta.persistence.Table(name = "allouer")
public class Allouer {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "propriete_id")
    @NotBlank(message = "La propriété ne peut pas être vide.")
    private Propriete proprietaire;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @NotBlank(message = "Le client ne peut pas être vide.")
    private Client client;

    @NotBlank(message = "La date de début ne peut pas être vide.")
    private Date dateDebut;

    @NotBlank(message = "La date de fin ne peut pas être vide.")
    private Date dateFin;
    
    @NotNull(message = "Le montant du loyer ne peut pas être nul.")
    @Size(min = 0, max = 1000000,message = "Le montant du loyer doit être positif.")
    private Double montantLoyer;

    @NotBlank(message = "Le statut du loyer ne peut pas être vide.")
    @Size(min = 2, max = 20, message = "Le statut du loyer doit contenir entre 2 et 20 caractères.")
    @Enumerated(jakarta.persistence.EnumType.STRING)
    private StatusLoyer statutLoyer;

    @NotBlank(message = "L'état du loyer ne peut pas être vide.")
    @Enumerated(jakarta.persistence.EnumType.STRING)
    private EtatLoyer etatLoyer;

    @NotBlank(message = "Le mode de paiement ne peut pas être vide.")
    @Size(min = 2, max = 50, message = "Le mode de paiement doit contenir entre 2 et 50 caractères.")
    private String modePaiement;

    @NotBlank(message = "Les conditions spéciales ne peuvent pas être vides.")
    @Size(max = 255, message = "Les conditions spéciales ne doivent pas dépasser 255 caractères.")
    private String conditions ;

    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate()
    private Instant updatedAt;
}
