package it.univaq.disim.mobile.myunivaq.business.impl.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import it.univaq.disim.mobile.myunivaq.domain.Esercizio;

import java.util.List;


public interface EsercizioRepository extends JpaRepository <Esercizio, Long> {
}
