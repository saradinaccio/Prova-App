package it.univaq.disim.mobile.unievent.business.web;



import java.util.List;

import it.univaq.disim.mobile.unievent.business.domain.Esercizio;
import it.univaq.disim.mobile.unievent.business.impl.FitWomanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/esercizi")
public class RESTEserciziController {

    @Autowired
    private FitWomanService service;

    @GetMapping
    public String list() {
        System.out.println("ciao");

        List<Esercizio> esercizios = service.findAllEsercizi();

        System.out.println(esercizios);
        return "prova";
    }

	/*@GetMapping("/{id}")
	public Esercizio findById(@PathVariable Long id) {
		return service.findEsercizioById(Long idEsercizio);
	}*/

}
