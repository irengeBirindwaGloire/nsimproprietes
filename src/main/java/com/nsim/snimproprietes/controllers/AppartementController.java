package com.nsim.snimproprietes.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nsim.snimproprietes.dto.ClientDto;
import com.nsim.snimproprietes.dto.ProprieteDto;
import com.nsim.snimproprietes.services.ClientService;
import com.nsim.snimproprietes.services.ProprieteService;
import jakarta.validation.Valid;

@Controller
@RequestMapping(path="/appartement", name="snim.appartement.")
public class AppartementController {

    private ProprieteService proprieteService;
    private ClientService clientService;
    public AppartementController(ProprieteService proprieteService, ClientService clientService) {
        this.proprieteService = proprieteService;
        this.clientService = clientService;
    }

    @GetMapping(path="/", name="home")
    public String index(Model model,@RequestParam(name="keyword", defaultValue="") String keyword,
            @RequestParam(name="page", defaultValue="0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size) {
        Page<ProprieteDto> pageProprietes = proprieteService.findAllProprietes(keyword, PageRequest.of(page, size)); 
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        model.addAttribute("pages", pageProprietes.getTotalPages());
        model.addAttribute("appartements", pageProprietes);
        return "appartements/home";
    }
    
    @GetMapping(path="/new", name="new")
    public String newAppartement(Model model) {
        model.addAttribute("appartement", new ProprieteDto());
        Page<ClientDto> clients = clientService.findAll();
        model.addAttribute("clients", clients);
        return "appartements/formAppartement";
    }

    @PostMapping(path="/saveAppartement", name="save")
    public String saveAppartement(@Valid ProprieteDto appartement, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            // return "appartements/formAppartement";
        }
          
        proprieteService.savePropriete(appartement);
        return "redirect:/appartement/";
    }   

    @GetMapping(path="/edit/{id}", name="edit")
    public String editAppartement(@PathVariable("id") Long id, Model model) {
        ProprieteDto proprieteDto = proprieteService.findProprieteById(id);
        Page<ClientDto> clients = clientService.findAll();
        model.addAttribute("clients", clients);
        model.addAttribute("appartement", proprieteDto);
        return "appartements/formAppartement";
    }

    @PostMapping(path="/delete", name="delete")
    public String deleteAppartement(@RequestParam("id") Long id, Model model) {
        proprieteService.deleteProprieteById(id);
        return "redirect:/appartement/";
    }

    @GetMapping(path="/{id}", name="view")
    public String viewAppartement(@PathVariable("id") Long id, Model model) { 
        ProprieteDto proprieteDto = proprieteService.findProprieteById(id);
        model.addAttribute("appartement", proprieteDto);
        System.out.println("Appartements titre: " + proprieteDto.getTitre());
        return "appartements/viewAppartement";
    }
}
