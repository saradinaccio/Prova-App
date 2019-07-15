package it.univaq.disim.mobile.unievent.business.impl;

import it.univaq.disim.mobile.unievent.business.domain.Esercizio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface EsercizioRepository extends JpaRepository <Esercizio, Long> {

    Esercizio findEsercizioById(Long id);

    List<Esercizio> findEsercizioByLivello(Long livello);

   @Query("SELECT nome, serie, ripetizioni, descrizione FROM Esercizio esercizio WHERE esercizio.livello = :livello AND esercizio.zona= :zona ")
    List<Esercizio> findEserciziByLivelloAndZona (@Param("livello") long livello , @Param("zona") String zona);

    @Query("SELECT nome, serie, ripetizioni, descrizione FROM Esercizio esercizio WHERE esercizio.zona = :zona ")
    List<Esercizio> findEserciziByZona (@Param("zona") String zona);

    @Query("SELECT e FROM Esercizio e JOIN e.schedepersonali s WHERE s.id = :id")
    List<Esercizio> findEserciziBySchedaPersonale(@Param("id") Long id);

}