package com.example.miniBoss.service;


import com.example.miniBoss.dto.ClientRequestDto;
import com.example.miniBoss.dto.ClientResponseDto;
import com.example.miniBoss.entity.ClientEntity;
import com.example.miniBoss.mapper.ClientMapper;
import com.example.miniBoss.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientResponseDto addClient(ClientRequestDto clientRequestDto) {
        ClientEntity clientEntity = clientMapper.toEntity(clientRequestDto);
        ClientEntity savedEntity = clientRepository.save(clientEntity);
        return clientMapper.toResponse(savedEntity);
    }
    public Page<ClientResponseDto> getAllClients(Pageable pageable) {
        return clientRepository.findAll(pageable).map(clientMapper::toResponse);
    }
    public ClientResponseDto getClientById(Integer id) {
        return clientRepository.findById(id).map(clientMapper::toResponse).orElse(null);
    }
    public void deleteClientById(Integer id) {
        clientRepository.deleteById(id);
    }

    public ClientResponseDto updateClientById(int id, ClientRequestDto clientRequestDto) {
        ClientEntity existingEntity = clientRepository.findById(id).orElse(null);
        clientMapper.updateEntity(clientRequestDto, existingEntity);
        assert existingEntity != null;
        ClientEntity savedEntity = clientRepository.save(existingEntity);
        return clientMapper.toResponse(savedEntity);
    }

}
