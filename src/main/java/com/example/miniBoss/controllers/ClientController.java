package com.example.miniBoss.controllers;

import com.example.miniBoss.dto.ClientRequestDto;
import com.example.miniBoss.dto.ClientResponseDto;
import com.example.miniBoss.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @PostMapping("/clients")
    public ClientResponseDto createClient(@RequestBody ClientRequestDto clientRequestDto) {
        return clientService.addClient(clientRequestDto);
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
