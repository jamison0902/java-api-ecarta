/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.ApiNotificarCarta.service;

import com.api.ApiNotificarCarta.model.Processo;

import java.util.List;
import java.util.Optional;

public interface ProcessoService {

    Processo save(Processo processo);

    List<Processo> findAll();

    Optional<Processo> findById(Long id);

    Processo update(Processo processo);

    void deleteById(Long id);  
    
    List<Processo> encontrarRegistros();
    
//    List<Processo> findByCepNotNull();
}
