package it.univaq.disim.mobile.myunivaq.business;

import it.univaq.disim.mobile.myunivaq.domain.Utente;
import it.univaq.disim.mobile.myunivaq.domain.Scheda;
import it.univaq.disim.mobile.myunivaq.domain.Esercizio;

import java.util.List;

public interface FitWomanService {
    Utente findUtente(String utente) throws BusinessException;
    Utente updateProfilo(Utente utente) throws BusinessException;
    List<Esercizio> findAllEsercizi() throws BusinessException;
    List<Scheda> findAllSchede() throws BusinessException;
   // List<Esercizio> findEsercizioById(long idEsercizio) throws BusinessException;
    void createScheda(Scheda scheda) throws BusinessException;
    void updateScheda(Scheda scheda) throws BusinessException;
    void deleteScheda(long idScheda) throws BusinessException;

}
