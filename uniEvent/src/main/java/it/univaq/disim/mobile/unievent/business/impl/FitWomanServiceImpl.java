package it.univaq.disim.mobile.unievent.business.impl;

import it.univaq.disim.mobile.unievent.business.domain.*;

import java.util.ArrayList;
import java.util.List;

import it.univaq.disim.mobile.unievent.business.domain.Esercizio;
import it.univaq.disim.mobile.unievent.business.domain.Scheda;
import it.univaq.disim.mobile.unievent.business.domain.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class FitWomanServiceImpl implements FitWomanService {

    @Autowired
    private EsercizioRepository esercizioRepository;

    @Autowired
    private SchedaPersonaleRepository schedaPersonaleRepository;

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
        //List<Esercizio> esercizi = new ArrayList<Esercizio>();



        return esercizioRepository.findAll();
    }

    @Override
    public Esercizio findEsercizioById(Long id) {
        return esercizioRepository.findEsercizioById(id);
    }

    @Override
    public List<Esercizio> findEsercizioByLivello(Long livello) {
        return esercizioRepository.findEsercizioByLivello(livello);
    }



    @Override
    public List<Scheda> findAllSchede() {
        return null;
    }


    @Override
    public void createScheda(SchedaPersonale scheda) {

    this.schedaPersonaleRepository.save(scheda);

    }

    @Override
    public void updateScheda(Scheda scheda) {

    }

    @Override
    public void deleteScheda(long idScheda) {

    }
}

