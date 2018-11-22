package it.univaq.disim.mobile.unievent.business.impl;

import it.univaq.disim.mobile.unievent.business.domain.Esercizio;
import it.univaq.disim.mobile.unievent.business.domain.Scheda;
import it.univaq.disim.mobile.unievent.business.domain.Utente;
import java.util.List;

public interface FitWomanService {

    Utente findUtenteByUsername(String username);

    Utente updateProfilo(Utente utente);
    List<Esercizio> findAllEsercizi();
    List<Scheda> findAllSchede();
    // List<Esercizio> findEsercizioById(long idEsercizio) throws BusinessException;
    void createScheda(Scheda scheda);
    void updateScheda(Scheda scheda) ;
    void deleteScheda(long idScheda);

}

