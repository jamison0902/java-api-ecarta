/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.ApiNotificarCarta.model;

import jakarta.persistence.Column;
import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Data
@Entity
public class Processo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nome;

    @Column(unique = true,nullable=false)
    private String documento;

    private String email;

    private String cep;

    @Column(unique = true,nullable=false)
    private String numeroProcesso;

    private boolean notificado;

    private String logradouro;

    private String complemento;

    private String bairro;

    private String localidade;

    private String uf;
    
}
