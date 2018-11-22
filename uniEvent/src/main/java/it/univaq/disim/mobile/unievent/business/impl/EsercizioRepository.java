package it.univaq.disim.mobile.unievent.business.impl;

import it.univaq.disim.mobile.unievent.business.domain.Esercizio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EsercizioRepository extends JpaRepository <Esercizio, Long> {

    Esercizio findEsercizioById(Long id);
    List<Esercizio> findEsercizioByLivello(Long livello);
}