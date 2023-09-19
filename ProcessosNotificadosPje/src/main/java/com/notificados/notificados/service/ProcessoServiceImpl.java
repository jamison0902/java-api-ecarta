package com.notificados.notificados.service;

import com.notificados.notificados.model.Processo;
import com.notificados.notificados.repository.ProcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProcessoServiceImpl implements ProcessoService {

    @Autowired
    private ProcessoRepository productRepository;

    @Override
    public List<Processo> findAll() {
//        return productRepository.findAll();
        List<Processo> todosOsProcessos = productRepository.findAll();

        List<Processo> processosNotificados = todosOsProcessos
                .stream()
                .filter(processo -> processo.isNotificado())
                .collect(Collectors.toList());

        return processosNotificados;
    }

    @Override
    public Optional<Processo> findById(Long id) {
        return productRepository.findById(id);
    }
}
