/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.ApiNotificarCarta.service;

import com.api.ApiNotificarCarta.model.Processo;
import com.api.ApiNotificarCarta.repository.ProcessoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author jsq
 */

@Service
public class ProcessoServiceImpl implements ProcessoService{
    
    @Autowired
    private ProcessoRepository processoRepository;
    
    @Override
    public Processo save(Processo processo) {
        return processoRepository.save(processo);
    }
    
    @Override
    public List<Processo> findAll() {
        return processoRepository.findAll();
    }

    @Override
    public Optional<Processo> findById(Long id) {
        return processoRepository.findById(id);
    }

    @Override
    public Processo update(Processo processo) {
        return processoRepository.save(processo);
    }

    @Override
    public void deleteById(Long id) {
        processoRepository.deleteById(id);
    }    
    
    @Override
    public List<Processo> findByCepNotNull() {
        if(processoRepository.findByCepNotNull().size()>9) return processoRepository.findByCepNotNull();
        else return null;    
    }
}
