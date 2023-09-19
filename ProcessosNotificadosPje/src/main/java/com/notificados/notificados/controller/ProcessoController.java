package com.notificados.notificados.controller;

import com.notificados.notificados.model.Processo;
import com.notificados.notificados.service.ProcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("processos")
public class ProcessoController {

    @Autowired
    private ProcessoService productService;

    @GetMapping
    public ResponseEntity<List<Processo>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(productService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Processo>> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(productService.findById(id));
    }
}
