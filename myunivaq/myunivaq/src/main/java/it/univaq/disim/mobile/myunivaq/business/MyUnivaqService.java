package it.univaq.disim.mobile.myunivaq.business;

import java.util.List;

import it.univaq.disim.mobile.myunivaq.domain.Appello;
import it.univaq.disim.mobile.myunivaq.domain.Insegnamento;
import it.univaq.disim.mobile.myunivaq.domain.Notizia;
import it.univaq.disim.mobile.myunivaq.domain.Utente;

public interface MyUnivaqService {

	Utente findUtenteByUsername(String username) throws BusinessException;

	Utente updateProfilo(Utente utente) throws BusinessException; //serve

	List<Notizia> findAllNotizie() throws BusinessException; //serve

	Notizia findNotiziaById(Long id) throws BusinessException;

	List<Insegnamento> findAllInsegnamenti(Utente utente) throws BusinessException;

	List<Appello> findAllAppelli(long idInsegnamento) throws BusinessException; //serve

	void createAppello(Appello appello) throws BusinessException; //serve

	Appello findAppelloById(long idAppello) throws BusinessException; 

	void updateAppello(Appello appello) throws BusinessException; //serve

	void deleteAppello(long idAppello) throws BusinessException;  //serve

}



// appello = scheda, scheda personale
// notizie = esercizi
