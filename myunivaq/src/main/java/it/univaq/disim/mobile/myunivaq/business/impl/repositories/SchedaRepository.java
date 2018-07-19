package it.univaq.disim.mobile.myunivaq.business.impl.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import it.univaq.disim.mobile.myunivaq.domain.Scheda;

public interface SchedaRepository extends JpaRepository<Scheda, Long> {
    List<Scheda> findSchedaByUtenteId (Long idUtente);
}
