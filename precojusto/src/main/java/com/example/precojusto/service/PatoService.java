package com.example.precojusto.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.precojusto.api.model.CreatePatoRequest;
import com.example.precojusto.repository.PatoDTO;
import com.example.precojusto.repository.PatoRepository;
import com.example.precojusto.repository.model.Pato;

@Service
public class PatoService {

    @Autowired
    private PatoRepository patoRepository;

    public String createPato(CreatePatoRequest pato) {
        Pato maePato = getPatoByName(pato.getMae());
        if (maePato != null) {
            maePato.updateFilhos();
            try {
                patoRepository.save(new Pato(pato.getNome(), maePato));
                return "Pato criado com sucesso!";
            } catch (Exception e) {
                return "Erro ao criar pato!";
            }
            } else {
                try {
                    patoRepository.save(new Pato(pato.getNome(), null));
                    return "Pato criado com sucesso!";
                } catch (Exception e) {
                    return "Erro ao criar pato!";
                }
        }
    }

    public PatoDTO getPatoById(Long id) {
        Pato pato = patoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pato not found"));
        PatoDTO dto = new PatoDTO();
        dto.setId(pato.getId());
        dto.setNome(pato.getNome());
        dto.setDisponivelParaVenda(pato.isDisponivel());
        dto.setFilhos(pato.getFilhos().stream().map(this::convertToDTO).collect(Collectors.toList()));
        return dto;
    }

    public Pato getPatoByName(String nome) {
        return patoRepository.findByNome(nome);
    }

    public List<PatoDTO> getAll() {
        List<Pato> patos = patoRepository.findAllWithFilhos();
        return patos.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private PatoDTO convertToDTO(Pato pato) {
        PatoDTO dto = new PatoDTO();
        dto.setId(pato.getId());
        dto.setNome(pato.getNome());
        dto.setNumeroFilhos(pato.getNfilhos());
        dto.setDisponivelParaVenda(pato.isDisponivel());
        dto.setFilhos(pato.getFilhos().stream().map(this::convertToDTO).collect(Collectors.toList()));
        return dto;
    }
}
