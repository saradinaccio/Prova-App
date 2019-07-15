package it.univaq.disim.mobile.unievent.business.web;

import it.univaq.disim.mobile.unievent.business.domain.Esercizio;
import it.univaq.disim.mobile.unievent.business.domain.SchedaPersonale;
import it.univaq.disim.mobile.unievent.business.impl.FitWomanService;
import it.univaq.disim.mobile.unievent.business.domain.Scheda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schede")
class RESTSchedeController {

    @Autowired
    private FitWomanService service;
    

    @GetMapping ("/{token}/personale")
     public Response getAllSchedePersonali(@PathVariable(value = "token") String token) {
        List<SchedaPersonale> schede = service.getAllSchedePersonali(token);

        if(schede != null) {
            Response<Object> response = new Response<>(true, "getAllSchedePersonali");

            for(SchedaPersonale scheda : schede) {
                for(Esercizio esercizio : scheda.getEsercizi()) {
                    esercizio.setSchedepersonali(null);
                }
            }
            response.setData(schede);
            return response;
        } else {
            return Response.DEFAULT_RESPONSE_KO;
        }
    }

    @GetMapping ("/{token}/personale/{id}")
    public Response getSchedaPersonaleById(@PathVariable(value = "token") String token, @PathVariable(value = "id") Long id) {
        SchedaPersonale scheda = service.getSchedaPersonaleById(token, id);

        if(scheda != null) {
            Response<Object> response = new Response<>(true, "getSchedPersonaleById");

            for(Esercizio esercizio : scheda.getEsercizi()) {
                esercizio.setSchedepersonali(null);
            }

            response.setData(scheda);
            return response;
        } else {
            return Response.DEFAULT_RESPONSE_KO;
        }
    }

    @PostMapping("/{token}/personale")
    public Response createSchedaPersonale(@PathVariable(value = "token") String token, @RequestBody SchedaPersonale scheda) {

        if(service.createSchedaPersonale(token, scheda)) return Response.DEFAULT_RESPONSE_OK;
        else return Response.DEFAULT_RESPONSE_KO;
    }


    @PutMapping("/{token}/personale")
    public Response updateSchedaPersonale(@PathVariable(value = "token") String token, @RequestBody SchedaPersonale scheda) {
        SchedaPersonale newScheda = service.updateSchedaPersonale(token, scheda);
        if(newScheda != null) {
            Response<Object> response = new Response<>(true, "updateSchedaPersonale");
            response.setData(newScheda);
            return response;
        } else {
            return Response.DEFAULT_RESPONSE_KO;
        }
    }

    @DeleteMapping("/{token}/personale/{id}")
    public Response deleteSchedaPersonale(@PathVariable(value = "token") String token, @PathVariable long id) {
        if(service.deleteSchedaPersonale(token, id)) return Response.DEFAULT_RESPONSE_OK;
        else return Response.DEFAULT_RESPONSE_KO;
    }
}
