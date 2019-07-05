package it.univaq.disim.mobile.unievent.business.impl;

import it.univaq.disim.mobile.unievent.business.domain.Scheda;
import it.univaq.disim.mobile.unievent.business.domain.SchedaPersonale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SchedaPersonaleRepository extends JpaRepository<SchedaPersonale, Long> {

    @Query("SELECT goal FROM SchedaPersonale schedaP ")
    List<SchedaPersonale> FindAllSchedePersonali ();
}

