/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Notify.App.repository;

import com.Notify.App.model.Processo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author leosc
 */
@Repository
public interface ProcessoRepository extends JpaRepository<Processo, Integer> { 
     boolean existsByDocumento(String documento); 
     boolean existsByNumeroProcesso(String numeroProcesso);
 
}
