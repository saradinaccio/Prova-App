package it.univaq.disim.mobile.unievent.business.impl;

import it.univaq.disim.mobile.unievent.business.domain.*;

import java.util.List;

import it.univaq.disim.mobile.unievent.business.domain.Esercizio;
import it.univaq.disim.mobile.unievent.business.domain.Scheda;
import it.univaq.disim.mobile.unievent.business.domain.Utente;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author uniEvent
 */
@Service
@Transactional
public class FitWomanServiceImpl implements FitWomanService {

    @Override
    public Utente findUtenteByUsername(String username) {
        return null;
    }

    @Override
    public Utente updateProfilo(Utente utente) {
        return null;
    }

    @Override
    public List<Esercizio> findAllEsercizi() {
        return null;
    }

    @Override
    public List<Scheda> findAllSchede() {
        return null;
    }

    @Override
    public void createScheda(Scheda scheda) {

    }

    @Override
    public void updateScheda(Scheda scheda) {

    }

    @Override
    public void deleteScheda(long idScheda) {

    }
}

