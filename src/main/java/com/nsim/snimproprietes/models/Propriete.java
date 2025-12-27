package com.nsim.snimproprietes.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "proprietes")
public class Propriete {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 4, max = 100, message = "Le titre doit contenir entre 4 et 100 caractères.")
    private String titre;

    @NotBlank
    @Size(min = 10, max = 500, message = "La description doit contenir entre 10 et 500 caractères.")
    private String description;

    @NotBlank
    @Size(min = 10, max = 200, message = "L'adresse doit contenir entre 10 et 200 caractères.")
    private String adresse;

    @NotBlank
    @Size(min = 4, max = 100, message = "La ville doit contenir entre 4 et 100 caractères.")
    private String ville;

    @NotBlank
    @Size(min = 4, max = 20, message = "Le code postal doit contenir entre 4 et 20 caractères.")
    private String codePostal;

    @NotBlank
    @Size(min = 4, max = 100, message = "Le pays doit contenir entre 4 et 100 caractères.")
    private String pays;

    @NotBlank
    @Size(min = 4, max = 50, message = "Le type de propriété doit contenir entre 4 et 50 caractères.")
    private Double prix;

    @NotBlank
    @Size(min = 4, max = 50, message = "Le type de propriété doit contenir entre 4 et 50 caractères.")
    private String typePropriete;

    @NotBlank
    @Size(min = 4, max = 50, message = "Le type de propriété doit contenir entre 4 et 50 caractères.")
    private Integer surface;

    @NotBlank
    @Size(min = 4, max = 50, message = "Le type de propriété doit contenir entre 4 et 50 caractères.")
    private Integer nombreDePieces;

    @OneToMany(mappedBy = "proprietaire")
    private List<Allouer> allocations;
}
