package it.univaq.disim.mobile.myunivaq.business.impl;

import java.util.List;

import it.univaq.disim.mobile.myunivaq.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.univaq.disim.mobile.myunivaq.business.BusinessException;
import it.univaq.disim.mobile.myunivaq.business.FitWomanService;
import it.univaq.disim.mobile.myunivaq.business.impl.repositories.SchedaRepository;
import it.univaq.disim.mobile.myunivaq.business.impl.repositories.InsegnamentoRepository;
import it.univaq.disim.mobile.myunivaq.business.impl.repositories.EsercizioRepository;
import it.univaq.disim.mobile.myunivaq.business.impl.repositories.UtenteRepository;

@Service
@Transactional
public class FitWomanServiceImpl implements FitWomanService {

	@Autowired
	private UtenteRepository utenteRepository;

	@Autowired
	private EsercizioRepository esercizioRepository;

	@Autowired
	private InsegnamentoRepository insegnamentoRepository;

	@Autowired
	private SchedaRepository schedaRepository;

//	@Override
//	public Utente findUtente(String username) throws BusinessException {
//		return utenteRepository.findByUsername(username);
//	}

	@Override
	public List<Esercizio> findAllEsercizi() throws BusinessException {
		return esercizioRepository.findAll();
	}


	@Override
	public Utente findUtente(String utente) throws BusinessException {
		return null;
	}

	@Override
	public Utente updateProfilo(Utente profilo) throws BusinessException {
		Utente utente = utenteRepository.findByUsername(profilo.getCognome());
		utente.setEmail(profilo.getEmail());
		return utente;
	}

	/*@Override
	public List<Insegnamento> findAllInsegnamenti(Utente utente) throws BusinessException {
		return insegnamentoRepository.findInsegnamentiByDocenteId(utente.getId(), JpaSort.unsafe(Direction.ASC, "denominazione"));
	}*/

	@Override
	public List<Scheda> findAllSchede () throws BusinessException {
		return schedaRepository.findAll();
	}

	@Override
	public void createScheda(Scheda scheda) throws BusinessException {
		schedaRepository.save(scheda);
	}

	//@Override
	/*public Appello findAppelloById(long idAppello) throws BusinessException {
		return appelloRepository.findById(idAppello).get();
	}*/

	@Override
	public void updateScheda(Scheda scheda) throws BusinessException {
		schedaRepository.save(scheda);
	}

	@Override
	public void deleteScheda(long idScheda) throws BusinessException {
		schedaRepository.deleteById(idScheda
		);
		
	}

}
