package it.univaq.disim.mobile.myunivaq.business;

import java.util.List;

import it.univaq.disim.mobile.myunivaq.domain.*;


public interface MyUnivaqService {

	Utente findUtenteByUsername(String username) throws BusinessException;

	//Utente updateProfilo(Utente utente) throws BusinessException;

//	List<Notizia> findAllNotizie() throws BusinessException;
//
//	Notizia findNotiziaById(Long id) throws BusinessException;
//
//	List<Insegnamento> findAllInsegnamenti(Utente utente) throws BusinessException;
//
//	List<Appello> findAllAppelli(long idInsegnamento) throws BusinessException;
//
//	void createAppello(Appello appello) throws BusinessException;
//
//	Appello findAppelloById(long idAppello) throws BusinessException;
//
//	void updateAppello(Appello appello) throws BusinessException;
//
//	void deleteAppello(long idAppello) throws BusinessException;

	Utente updateProfilo(Utente utente) throws BusinessException;
	List<Esercizio> findAllEsercizi() throws BusinessException;
	List<Scheda> findAllSchede() throws BusinessException;
	// List<Esercizio> findEsercizioById(long idEsercizio) throws BusinessException;
	void createScheda(Scheda scheda) throws BusinessException;
	void updateScheda(Scheda scheda) throws BusinessException;
	void deleteScheda(long idScheda) throws BusinessException;

}
