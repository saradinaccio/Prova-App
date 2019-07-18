package it.univaq.disim.mobile.unievent.business.impl;

import it.univaq.disim.mobile.unievent.business.domain.Routine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoutineRepository extends JpaRepository<Routine, Long> {

    @Query("SELECT nome, descrizione, durata FROM Routine routine WHERE routine.tipo = :tipo")
    List<Routine> getRoutineByTipo(@Param("tipo") int tipo);
}
