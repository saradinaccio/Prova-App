package it.univaq.disim.mobile.unievent.business.impl;

import it.univaq.disim.mobile.unievent.business.domain.Scheda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchedaRepository extends JpaRepository<Scheda, Long> {
    //  List<Scheda> findSchedaByUtenteId (Long idUtente);
}
