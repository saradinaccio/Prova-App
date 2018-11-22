package it.univaq.disim.mobile.unievent.business.impl;

import it.univaq.disim.mobile.unievent.business.domain.Utente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UtenteRepository extends JpaRepository<Utente, Long> {

    Utente findByUsername(String username);
}
