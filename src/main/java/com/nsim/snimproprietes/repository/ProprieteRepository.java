package com.nsim.snimproprietes.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nsim.snimproprietes.models.Propriete;

@Repository
public interface ProprieteRepository extends JpaRepository<Propriete, Long> {

    Page<Propriete> findByTitreContains(String keyword, Pageable pageable);
}
