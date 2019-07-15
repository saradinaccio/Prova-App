package it.univaq.disim.mobile.unievent.business.impl;

import it.univaq.disim.mobile.unievent.business.domain.*;

import java.util.List;

public interface FitWomanService {

    List<Esercizio> findAllEsercizi(String token);
    Esercizio getEsercizioById(String token, Long id);
    List<Esercizio> getEserciziByZona(String token, String zona);
    List<Esercizio> getEserciziByLivelloAndZona(String token, Long livello, String zona);

    Session login(String username, String password);
    void logout(String token);
    Session createUtente(Utente utente);
    Utente findUtenteById(String token, Long Id);
    Utente updateUtente (String token, Utente utente);


    Utente findUtenteByUsername(String username);
    List<Scheda> findAllSchede();
    List<SchedaPersonale> getAllSchedePersonali(String token);
    SchedaPersonale getSchedaPersonaleById(String token, Long id);
    boolean createSchedaPersonale(String token, SchedaPersonale scheda);
    SchedaPersonale updateSchedaPersonale(String token, SchedaPersonale newScheda) ;
    boolean deleteSchedaPersonale(String token, Long id);

}

