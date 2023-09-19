package com.notificados.notificados.service;

import com.notificados.notificados.model.Processo;
import java.util.List;
import java.util.Optional;

public interface ProcessoService {
//    Processo save(Processo processo);
    List<Processo> findAll();
    Optional<Processo> findById(Long id);
//    Processo update(Processo processo);
//    void deleteById(Long id);
}
