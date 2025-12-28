package com.nsim.snimproprietes.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nsim.snimproprietes.dto.AllouerDto;
import com.nsim.snimproprietes.services.AllouerService;

@Controller
@RequestMapping(path = "/proprietes", name = "proprietes.allouer.")
public class AllouerController {

    private final AllouerService allouerService;

    public AllouerController(AllouerService allouerService) {
        this.allouerService = allouerService;
    }

    @GetMapping(path = "/allouer", name = "index")
    public String index(Model model,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size,
            @RequestParam(name = "keyword", defaultValue = "ACTIF") String keyword) {
        Page<AllouerDto> allouers = allouerService.findAllouerServices(PageRequest.of(page, size));
        model.addAttribute("allouers", allouers);
        return "proprietes/allouer";
    }
}
