/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Notify.App.controller;

import com.Notify.App.model.Processo;
import com.Notify.App.repository.ProcessoRepository;
import com.Notify.App.service.ApiService;
import com.Notify.App.service.EmailService;
import jakarta.mail.MessagingException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author leosc
 */
@RestController
public class WelcomeController {
    private final ApiService apiService;
    private final EmailService emailService;
    private ProcessoRepository processoRepository;
    
    @Autowired
    public WelcomeController(ApiService apiService, EmailService emailService, ProcessoRepository processoRepository) {
        this.apiService = apiService;
        this.emailService = emailService;
        this.processoRepository = processoRepository;
    }
    
    @GetMapping
    public String Welcome(){
    return "Welcome to my Spring boot API 2";
    }
    @GetMapping("/dados")
    public List<Processo> receberDadosNoConsole() {
        List<Processo> processos = apiService.getDataFromApi();
        System.out.println("Dados da API: ");
        for (Processo processo : processos) {
        String doc = processo.getDocumento();
        String num = processo.getNumeroProcesso();
        // Verifique se já existe um processo com os mesmos dados no banco
        if (!processoRepository.existsByDocumento(doc)&& !processoRepository.existsByNumeroProcesso(num)) {
            
            processoRepository.save(processo);
        }else{
            System.out.println("ja existe!!");
        }    
    }
        
        return processos; 
    }
    @GetMapping("/dados-somente-com-email")
    public List<Processo> receberDadosNoCpf() throws MessagingException {
        List<Processo> processos = processoRepository.findAll();
        List<Processo> processosSemCepComEmail = processos.stream()
                .filter(processo -> {
                                     boolean cepVazio = processo.getCep() == null || processo.getCep().isEmpty();
                                     boolean emailNaoVazio = processo.getEmail() != null && !processo.getEmail().isEmpty();
                  return cepVazio && emailNaoVazio;  
                })
                .collect(Collectors.toList());       
        for (Processo processo : processosSemCepComEmail) {
        String email = processo.getEmail();
        String nome = processo.getNome();
        String documento = processo.getDocumento();
        String numeroProcesso = processo.getNumeroProcesso();

        String assunto = "Notificação processo Nº: " + numeroProcesso ;
        String corpoEmail = "Olá " + nome + ",\n";
        corpoEmail += "Portador do documento Nº: " + documento + " no processo " + numeroProcesso + " está pendente de alguma ação.\n";
        corpoEmail += "Por favor, tome as medidas necessárias.";
        
        // Envie a mensagem de e-mail
        
        emailService.enviarEmail("devtean01@gmail.com", assunto, corpoEmail);
        processo.setNotificado(true);
        processoRepository.save(processo);
        }
        
        return processosSemCepComEmail; 
    }  
    @GetMapping("/dados-sem-dados")
    public List<Processo> receberDadosSemDados() {
        List<Processo> processos = apiService.getDataFromApi();
        List<Processo> processosSemCepSemEmail = processos.stream()
                .filter(processo -> (processo.getCep() == null || processo.getCep().isEmpty()) &&
                                (processo.getEmail() == null || processo.getEmail().isEmpty()))
                .collect(Collectors.toList());
        return processosSemCepSemEmail;
    }
    @GetMapping("/dados-com-cep")
    public List<Processo> receberDadosComCep() {
        List<Processo> processos = apiService.getDataFromApi();
        List<Processo> processosComCep = processos.stream()
                .filter(processo -> processo.getCep() != null && !processo.getCep().isEmpty())
                .collect(Collectors.toList());
        return processosComCep;
    }
}