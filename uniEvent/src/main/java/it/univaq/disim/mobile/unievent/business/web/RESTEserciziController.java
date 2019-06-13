package it.univaq.disim.mobile.unievent.business.web;



import java.util.List;

import it.univaq.disim.mobile.unievent.business.domain.Esercizio;
import it.univaq.disim.mobile.unievent.business.impl.FitWomanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/esercizi")
public class RESTEserciziController {

    @Autowired
    private FitWomanService service;

    @GetMapping
    public List<Esercizio> listEsercizi() {
        System.out.println("metodo listEsercizi");

        List<Esercizio> esercizios = service.findAllEsercizi();

        System.out.println(esercizios);
        return esercizios;
    }

	@GetMapping("/{id}")
	public Esercizio findById(@PathVariable Long id) {
        System.out.println("metodo findById");

        return service.findEsercizioById(id);
	}

	/*@GetMapping("/addome/livello/{livello}")
    public List<Esercizio> listEserciziLivello(@PathVariable Long livello) {
        System.out.println("metodo listEserciziLivello");

        List<Esercizio> esercizios = service.findEsercizioByLivello(livello);
        System.out.println(esercizios);
        return esercizios;
    }*/

    @GetMapping("/livello/{livello}/{zona}")
    public List<Esercizio> findEserciziByLivelloAndZona(@PathVariable long livello, @PathVariable String zona) {
        System.out.println("metodo listEserciziLivello");

        List<Esercizio> esercizios = service.findEserciziByLivelloAndZona(livello, zona);
        System.out.println(esercizios);
        return esercizios;
    }

}
