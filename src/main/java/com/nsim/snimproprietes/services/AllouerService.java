package com.nsim.snimproprietes.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nsim.snimproprietes.dto.AllouerDto;

@Service
public interface AllouerService {

    public Page<AllouerDto> findAllouerServices(Pageable pageable);

    public AllouerDto findAllouerById(Long id);

    public AllouerDto saveAllouer(AllouerDto dto);

    public void deleteAllouerById(Long id);

    public List<AllouerDto> findAllouerByClient(String client);

} 