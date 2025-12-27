package com.nsim.snimproprietes.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nsim.snimproprietes.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Page<Client> findByNomContains(String key, Pageable pageable);
}
