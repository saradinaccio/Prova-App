package it.univaq.disim.mobile.myunivaq.presentation;

import it.univaq.disim.mobile.myunivaq.domain.Scheda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.univaq.disim.mobile.myunivaq.business.FitWomanService;

import java.util.List;

@RestController
@RequestMapping("/api/schede")
class RESTSchedeController {

	
	@Autowired
	private FitWomanService service;

	@GetMapping("/{idScheda}")
	public List<Scheda> findAllSchede() { return service.findAllSchede();
	}

	@PostMapping
	public void createScheda(@RequestBody Scheda scheda) {
		service.createScheda(scheda);
	}
	
	@PutMapping
	public void updateScheda(@RequestBody Scheda scheda) {
		service.updateScheda(scheda);
	}
	
	@DeleteMapping("/{idScheda}")
	public void deleteScheda( @PathVariable long idScheda) {
		service.deleteScheda(idScheda);
	}
}
