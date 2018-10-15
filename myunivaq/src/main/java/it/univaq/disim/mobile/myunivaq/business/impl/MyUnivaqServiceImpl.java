package it.univaq.disim.mobile.myunivaq.business.impl;

import java.util.List;

import it.univaq.disim.mobile.myunivaq.business.impl.repositories.*;
import it.univaq.disim.mobile.myunivaq.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.univaq.disim.mobile.myunivaq.business.BusinessException;
import it.univaq.disim.mobile.myunivaq.business.MyUnivaqService;


@Service
@Transactional
public class MyUnivaqServiceImpl implements MyUnivaqService {

	@Autowired
	private UtenteRepository utenteRepository;


	@Autowired
	private SchedaRepository schedaRepository;


	@Autowired
	private EsercizioRepository esercizioRepository;


	@Override
	public List<Esercizio> findAllEsercizi() throws BusinessException {
		return esercizioRepository.findAll(JpaSort.unsafe(Direction.DESC, "nome"));
	}

	@Override
	public List<Scheda> findAllSchede () throws BusinessException {
		return schedaRepository.findAll();
	}

	@Override
	public void createScheda(Scheda scheda) throws BusinessException {
		schedaRepository.save(scheda);
	}

	@Override
	public void updateScheda(Scheda scheda) throws BusinessException {
		schedaRepository.save(scheda);
	}

	@Override
	public void deleteScheda(long idScheda) throws BusinessException {
		schedaRepository.deleteById(idScheda);

	}

	@Override
	public Utente findUtenteByUsername(String username) throws BusinessException {
		return utenteRepository.findByUsername(username);
	}



	@Override
	public Utente updateProfilo(Utente profilo) throws BusinessException {
		Utente utente = utenteRepository.findByUsername(profilo.getUsername());
		utente.setEmail(profilo.getEmail());
		utente.setTelefono(profilo.getTelefono());
		return utente;
	}


}
