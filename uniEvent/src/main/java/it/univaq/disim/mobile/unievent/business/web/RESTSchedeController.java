package it.univaq.disim.mobile.unievent.business.web;

import it.univaq.disim.mobile.unievent.business.domain.Esercizio;
import it.univaq.disim.mobile.unievent.business.domain.SchedaPersonale;
import it.univaq.disim.mobile.unievent.business.impl.FitWomanService;
import it.univaq.disim.mobile.unievent.business.domain.Scheda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import it.univaq.disim.mobile.unievent.business.domain.EserciziWrapper;

import java.util.List;

@RestController
@RequestMapping("/api/schede")
class RESTSchedeController {


    @Autowired
    private FitWomanService service;

    @GetMapping("/{idScheda}")
    public List<Scheda> findAllSchede() { return service.findAllSchede();
    }

/*    @PostMapping ("/eserciziDaAggiungere")
        public boolean aggiungi(@RequestBody EserciziWrapper eserciWra){

        System.out.println(eserciWra.getI());
        return true;
    }*/


    @GetMapping ("/personale")
     public List<SchedaPersonale> FindAllSchedePersonali () {
        System.out.println(service.FindAllSchedePersonali());
        return service.FindAllSchedePersonali();
    }
    @PostMapping("/creaScheda")
    public void createScheda(@RequestBody SchedaPersonale scheda) {
        System.out.println("Scheda:" + scheda);

        service.createScheda(scheda);

        System.out.println("Scheda creata");
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
