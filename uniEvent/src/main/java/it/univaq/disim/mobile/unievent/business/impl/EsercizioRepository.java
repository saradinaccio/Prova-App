package it.univaq.disim.mobile.unievent.business.impl;

import it.univaq.disim.mobile.unievent.business.domain.Esercizio;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EsercizioRepository extends JpaRepository <Esercizio, Long> {
}
