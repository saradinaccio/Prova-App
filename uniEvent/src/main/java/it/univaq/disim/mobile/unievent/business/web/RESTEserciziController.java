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

    @GetMapping("/{token}")
    public Response getAllEsercizi(@PathVariable(value = "token") String token) {

        List<Esercizio> esercizi = service.findAllEsercizi(token);

        for(Esercizio esercizio : esercizi) {
            esercizio.setSchedepersonali(null);
        }

        if(esercizi != null) {
            Response<Object> response = new Response<>(true, "getAllEsercizi");
            response.setData(esercizi);
            return response;
        } else {
            return Response.DEFAULT_RESPONSE_KO;
        }
    }

	@GetMapping("/{token}/{id}")
	public Response getEsercizioById(@PathVariable String token, @PathVariable Long id) {

        Esercizio esercizio = service.getEsercizioById(token, id);

        if(esercizio != null) {
            Response<Object> response = new Response<>(true, "getEsercizioById");
            response.setData(esercizio);
            return response;
        } else {
            return Response.DEFAULT_RESPONSE_KO;
        }
	}

	/*@GetMapping("/addome/livello/{livello}")
    public List<Esercizio> listEserciziLivello(@PathVariable Long livello) {
        System.out.println("metodo listEserciziLivello");

        List<Esercizio> esercizios = service.findEsercizioByLivello(livello);
        System.out.println(esercizios);
        return esercizios;
    }*/

    @GetMapping("{token}/livello/{livello}/{zona}")
    public Response getEserciziByLivelloAndZona(@PathVariable String token, @PathVariable long livello, @PathVariable String zona) {
        List<Esercizio> esercizi = service.getEserciziByLivelloAndZona(token, livello, zona);

        if(esercizi != null) {
            Response<Object> response = new Response<>(true, "getEserciziByLivelloAndZona");
            response.setData(esercizi);
            return response;
        } else {
            return Response.DEFAULT_RESPONSE_KO;
        }
    }

    @GetMapping("/{token}/zona/{zona}")
    public Response getEserciziByZona(@PathVariable(value = "token") String token, @PathVariable String zona) {
        List<Esercizio> esercizi = service.getEserciziByZona(token, zona);

        if (esercizi != null) {
            Response<Object> response = new Response<>(true, "getEserciziByZona");
            response.setData(esercizi);
            return response;
        } else {
            return Response.DEFAULT_RESPONSE_KO;
        }
    }
}
