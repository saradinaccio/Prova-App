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
    private SessionRepository sessionRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private EsercizioRepository esercizioRepository;

    @Autowired
    private SchedaPersonaleRepository schedaPersonaleRepository;

    @Override
    public Session login(String username, String password) {
        Utente user = utenteRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            Session session = new Session();
            session.setUser(user);
            session.setToken(Utility.generateToken());
            Session newSession = sessionRepository.save(session);
            return newSession;
        } else {
            return null;
        }
    }

    @Override
    public void logout(String token) {
        Session session = sessionRepository.findByToken(token);
        if (session != null) {
            sessionRepository.delete(session);
        }
    }

    @Override
    public boolean createUtente(Utente utente) {
        Utente u = utenteRepository.findByUsername(utente.getUsername());
        if (u != null) {
            return false;
        }
        utenteRepository.save(utente);
        return true;
    }

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
    public List<SchedaPersonale> FindAllSchedePersonali (){
        return schedaPersonaleRepository.FindAllSchedePersonali();
    }

    @Override
    public List<Scheda> findAllSchede() {
        return null;
    }

    @Override
    public List<Esercizio> findEserciziByLivelloAndZona(long livello, String zona) {
        List<Esercizio> sc = esercizioRepository.findEserciziByLivelloAndZona(livello, zona);
        System.out.println(sc);
        return sc;
       // return esercizioRepository.findEserciziByLivelloAndZona(livello, zona);

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

