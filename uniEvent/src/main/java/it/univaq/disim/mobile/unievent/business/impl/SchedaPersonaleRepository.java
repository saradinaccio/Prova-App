package it.univaq.disim.mobile.unievent.business.impl;

import it.univaq.disim.mobile.unievent.business.domain.Utente;
import it.univaq.disim.mobile.unievent.business.domain.SchedaPersonale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SchedaPersonaleRepository extends JpaRepository<SchedaPersonale, Long> {

    @Query("SELECT schedaP FROM SchedaPersonale schedaP WHERE schedaP.utente =:utente")
    List<SchedaPersonale> getAllSchedePersonali(@Param("utente") Utente utente);

    @Query("DELETE FROM  SchedaPersonale schedaP WHERE schedaP.id =:id")
    boolean deleteScheda(@Param("id") Long id);

}

