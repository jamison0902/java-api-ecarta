package com.notificados.notificados.repository;
import com.notificados.notificados.model.Processo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessoRepository extends JpaRepository<Processo, Long> {
}
