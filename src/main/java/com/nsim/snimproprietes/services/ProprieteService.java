package com.nsim.snimproprietes.services; 

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nsim.snimproprietes.dto.ProprieteDto;

@Service
public interface ProprieteService {

    // Add methods here
    public Page<ProprieteDto> findAllProprietes(String keyword, Pageable pageable);

    public ProprieteDto findProprieteById(Long id);

    public ProprieteDto savePropriete(ProprieteDto dto);

    public void deleteProprieteById(Long id);

}
