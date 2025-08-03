package com.example.miniBoss.controllers;

import com.example.miniBoss.dto.ClientRequestDto;
import com.example.miniBoss.dto.ClientResponseDto;
import com.example.miniBoss.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;
    private static final Logger log = LoggerFactory.getLogger(ClientController.class);

    @PostMapping("/clients")
    public ClientResponseDto createClient(@RequestBody ClientRequestDto clientRequestDto) {
        return clientService.addClient(clientRequestDto);
    }


    @GetMapping("/log-test")
    public String logTest() {
        log.info("INFO: This is an info message");
        log.debug("DEBUG: This is a debug message");
        log.error("ERROR: This is an error message");
        return "Check logs in the console";
    }


    @GetMapping("/clients")
    public Page<ClientResponseDto> getAllClients(Pageable pageable) {
        return clientService.getAllClients(pageable);
    }

    @GetMapping("/clients/{id}")
    public ClientResponseDto getClient(@PathVariable int id) {
        return clientService.getClientById(id);
    }

    @DeleteMapping("/clients/{id}")
    public void deleteClient(@PathVariable int id) {
        clientService.deleteClientById(id);
    }
    @PutMapping("/clients/{id}")
    public ClientResponseDto updateClient(@PathVariable int id, @RequestBody ClientRequestDto clientRequestDto) {
        return clientService.updateClientById(id, clientRequestDto);
    }
}
