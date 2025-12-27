package com.nsim.snimproprietes.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nsim.snimproprietes.dto.ClientDto;
import com.nsim.snimproprietes.services.ClientService;

import jakarta.validation.Valid;

@Controller
@RequestMapping(path = "/client", name = "snim.client.")
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(path = "/", name = "home")
    public String index(Model model,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size,
            @RequestParam(name = "keyword", defaultValue = "") String keyword
    ) {
        Page<ClientDto> clients = clientService.findAllClients(keyword, PageRequest.of(page, size));
        model.addAttribute("clients", clients);
        model.addAttribute("pages", new int[clients.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        return "client/home";
    }
    

    @GetMapping(path = "/new", name = "new")
    public String newClient(Model model) {
        model.addAttribute("client", new ClientDto());
        return "client/formClient";
    }

    @PostMapping(path = "/saveClient", name = "save")
    public String saveClient(@Valid ClientDto client, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors())
            return "client/formClient";
        clientService.save(client);
        return "redirect:/client/";
    }
}
