package com.nsim.snimproprietes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nsim.snimproprietes.models.Allouer;

@Repository
public interface AllouerRepository extends JpaRepository<Allouer, Long> {

    @Query("SELECT a FROM Allouer a WHERE a.client.nom LIKE %:client% OR a.client.prenom LIKE %:client%")
    public List<Allouer> findAllouerByClient(String client);
}
