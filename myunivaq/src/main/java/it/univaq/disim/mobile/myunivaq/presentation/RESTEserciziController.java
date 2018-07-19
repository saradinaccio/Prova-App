package it.univaq.disim.mobile.myunivaq.presentation;

import java.util.List;

import it.univaq.disim.mobile.myunivaq.business.FitWomanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.univaq.disim.mobile.myunivaq.business.MyUnivaqService;
import it.univaq.disim.mobile.myunivaq.domain.Esercizio;

@RestController
@RequestMapping("/api/esercizi")
public class RESTEserciziController {
	
	@Autowired
	private FitWomanService service;
	
	@GetMapping
	public List<Esercizio> list() {
		return service.findAllEsercizi();
	}
	
	/*@GetMapping("/{id}")
	public Esercizio findById(@PathVariable Long id) {
		return service.findEsercizioById(Long idEsercizio);
	}*/

}
