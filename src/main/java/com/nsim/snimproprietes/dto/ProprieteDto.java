package com.nsim.snimproprietes.dto;

import com.nsim.snimproprietes.models.Propriete;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@lombok.Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProprieteDto {

    private Long id;
    private String titre;
    private String description;
    private String adresse;
    private String ville;
    private String codePostal;
    private String pays;
    private Double prix;
    private String typePropriete;
    private Integer surface;
    private Integer nombreDePieces;

    public static ProprieteDto fromEntity(Propriete propriete) {
        if (propriete == null) {
            return null;
        }

        return ProprieteDto.builder()
                .id(propriete.getId())
                .titre(propriete.getTitre())
                .description(propriete.getDescription())
                .adresse(propriete.getAdresse())
                .ville(propriete.getVille())
                .codePostal(propriete.getCodePostal())
                .pays(propriete.getPays())
                .prix(propriete.getPrix())
                .typePropriete(propriete.getTypePropriete())
                .surface(propriete.getSurface())
                .nombreDePieces(propriete.getNombreDePieces())
                .build();
    }

    public static Propriete toEntity(ProprieteDto dto) {
        if (dto == null) {
            return null;
        }

        Propriete propriete = new Propriete();
        propriete.setId(dto.getId());
        propriete.setTitre(dto.getTitre());
        propriete.setDescription(dto.getDescription());
        propriete.setAdresse(dto.getAdresse());
        propriete.setVille(dto.getVille());
        propriete.setCodePostal(dto.getCodePostal());
        propriete.setPays(dto.getPays());
        propriete.setPrix(dto.getPrix());
        propriete.setTypePropriete(dto.getTypePropriete());
        propriete.setSurface(dto.getSurface());
        propriete.setNombreDePieces(dto.getNombreDePieces());
        return propriete;
    }
}
