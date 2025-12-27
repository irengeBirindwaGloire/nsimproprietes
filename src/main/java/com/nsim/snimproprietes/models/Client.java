package com.nsim.snimproprietes.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
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
@Setter
@Getter
@Builder
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 4, max = 50, message = "Le nom doit contenir entre 2 et 50 caractères.")
    private String nom;

    @NotBlank
    @Size(min = 4, max = 50, message = "Le prénom doit contenir entre 2 et 50 caractères.")
    private String prenom;

    @NotBlank
    @Size(min = 4, max = 100, message = "L'email doit contenir entre 4 et 100 caractères.")
    @Email(message = "L'email doit être valide.")
    @Column(unique = true)
    private String email;

    @NotBlank
    @Size(max = 15, message = "Le téléphone doit contenir entre 10 caractères.")
    private String telephone;

    @OneToMany(mappedBy = "client")
    private List<Allouer> allocations;
}
