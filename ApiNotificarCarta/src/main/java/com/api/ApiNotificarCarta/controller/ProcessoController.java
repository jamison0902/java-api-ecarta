/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.ApiNotificarCarta.controller;

import com.api.ApiNotificarCarta.model.Processo;
import com.api.ApiNotificarCarta.service.ProcessoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author jsq
 */
@RestController
@RequestMapping("processos/ecarta")
public class ProcessoController {

    @Autowired
    private ProcessoService processoService;

    @GetMapping
    public ResponseEntity<List<Processo>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(processoService.findByCepNotNull());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Processo>> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(processoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Processo> create(@RequestBody Processo processo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(processoService.save(processo));
    }

    @PutMapping
    public ResponseEntity<Processo> update(@RequestBody Processo processo) {
        return ResponseEntity.status(HttpStatus.OK).body(processoService.update(processo));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        processoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
