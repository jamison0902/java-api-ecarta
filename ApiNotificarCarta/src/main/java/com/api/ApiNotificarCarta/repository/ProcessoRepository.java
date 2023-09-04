/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.ApiNotificarCarta.repository;

import com.api.ApiNotificarCarta.model.Processo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author jsq
 */
public interface ProcessoRepository extends JpaRepository<Processo, Long> {
    
    public List<Processo> findByCepNotNull();
    
}
