package com.notificados.notificados.model;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Processo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(unique = true, nullable = false)
    private String documento;

    @Column(name = "email")
    private String email;

    @Column(name = "cep")
    private String cep;

    @Column(unique = true, nullable = false)
    private String numeroProcesso;

    @Column(name ="notificado")
    private boolean notificado;

    @Column(name ="logradouro")
    private String logradouro;

    @Column(name ="complemento")
    private String complemento;

    @Column(name ="bairro")
    private String bairro;

    @Column(name ="localidade")
    private String localidade;

    @Column(name ="uf")
    private String uf;


}
