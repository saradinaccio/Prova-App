package it.univaq.disim.mobile.unievent.business.web;

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
