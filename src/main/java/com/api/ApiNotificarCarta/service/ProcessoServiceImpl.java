/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.ApiNotificarCarta.service;

import com.api.ApiNotificarCarta.model.Cep;
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
public class ProcessoServiceImpl implements ProcessoService {

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
    public List<Processo> encontrarRegistros(){
        // Retrição de exibição para no mínimo 10 processos
        if (processoRepository.encontrarRegistros().size() > 9) {
            // Atualiza o banco pegando as informações do viacep
            for (Processo i : processoRepository.encontrarRegistros()) {
                if (i.getLogradouro()== null) {
                    Cep buscar = new Cep();
                    buscar.GetCep(i.getCep());
                    i.setBairro(buscar.bairro);
                    i.setLogradouro(buscar.logradouro);
                    i.setComplemento(buscar.complemento);
                    i.setLocalidade(buscar.localidade);
                    i.setUf(buscar.uf);
                    update(i);
                }
            }
            return processoRepository.encontrarRegistros();
        } else {
            return null;
        }
    }
}
