/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Notify.App.model;
import jakarta.persistence.*;
import lombok.Data;

/**
 *
 * @author leosc
 */
@Data
@Entity
@Table(name = "dados_processos5")
public class Processo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_db")
    private Integer idParte;
    
    @Column(name = "id")
    private Integer id;    
    
    @Column(name = "numeroProcesso")
    private String numeroProcesso;

    @Column(name = "nome")
    private String nome;
    
    @Column(name = "documento")
    private String documento;

    @Column(name = "email")
    private String email;

    @Column(name = "cep")
    private String cep;

    @Column(name ="notificado")
    private boolean notificado;

}
