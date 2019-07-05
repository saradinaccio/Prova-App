package it.univaq.disim.mobile.unievent.business.impl;

import it.univaq.disim.mobile.unievent.business.domain.Esercizio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface EsercizioRepository extends JpaRepository <Esercizio, Long> {

    Esercizio findEsercizioById(Long id);
    List<Esercizio> findEsercizioByLivello(Long livello);

   @Query("SELECT nome, serie, ripetizioni, descrizione FROM Esercizio esercizi WHERE esercizi.livello = :livello AND esercizi.zona= :zona ")
    List<Esercizio> findEserciziByLivelloAndZona (@Param("livello") long livello , @Param("zona") String zona);

}